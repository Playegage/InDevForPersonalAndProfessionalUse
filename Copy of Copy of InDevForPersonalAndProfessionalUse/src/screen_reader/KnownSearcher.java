package screen_reader;

import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class KnownSearcher {

	public static void main(String[] args) {
		
	}
	

	public static int searchKnown(String tofind, int lines, String loc, String scrn, int xmin, int ymin, Robot r, boolean waiting) {
		BufferedImage img=null;
		int characters=tofind.length();
		int workingfont=LocationStorage.getFont();
		int xmax=0;
		int xminoriginal=xmin;
		int ymax=0;
		int hoffset=LocationStorage.getHoffset();
		int voffset=LocationStorage.getVoffset();
		int foundin=-1;
		String bgc="";
		String colorcheck="";
		boolean match=false;
		LocationStorage.setLengthofinput(characters);
		switch(loc){
			case"terminal":
				bgc=bgc+r.getPixelColor(1819,1020).getRGB();
			default:
				bgc="idk lol";
		}
		System.out.println("Looking for "+tofind);
		for(int ln=0; ln<lines;ln++){
			try{
				System.out.println("Checking line "+ln);
				xmin=xmin+((LocationStorage.getCharactertostartwith()-1)*7);
				ymax=ymin+((workingfont+0)*(LocationStorage.getLinetostartwith()-1));
				colorcheck=colorcheck+r.getPixelColor(xmin+hoffset,ymin+voffset).getRGB();
				for(int c=LocationStorage.getCharactertostartwith()-1;c<characters;c++){
					match=false;
					match=captureCharacter(img,tofind,loc,colorcheck,bgc,xmin,ymin,xmax,ymax,hoffset,voffset,ln,c,r);
					if(!match){
						break;
					}
					xmin=xmin+7;
				}
				if(match && !waiting){
					System.out.println("has been found on line "+(ln+LocationStorage.getLinetostartwith()));
					foundin=ln;
					break;
				}else if(match){
					foundin=ln;
					break;
				}
			}catch(StringIndexOutOfBoundsException e){
				break;
			}
			xmin=xminoriginal;
			if(loc.equals("terminal")){
				ymin=ymax+5;//change based on what the new font is...
			}else{
				ymin=ymax;
			}
		}
		File me=new File("");
		File dir=new File(me.getAbsolutePath()+"/src/screen_reader/output/");
		for(File f:dir.listFiles()){
			if(f.getName().contains("Error")){
				System.out.println("Deleting "+f.getName());
				f.delete();
			}
		}
		return foundin;
	}
	private static boolean captureCharacter(BufferedImage img, String tofind, String loc, String colorcheck, String bgc, int xmin, int ymin, int xmax, int ymax, int hoffset, int voffset, int ln, int c, Robot r){
		//System.out.println("Hoffset="+hoffset+" Voffset="+voffset);
		//System.out.println(LocationStorage.isOffByNoPixels());
		boolean match=false;
		boolean invert=false;
		xmax=xmin+7;
		img=new BufferedImage(xmax-xmin+1,ymax-ymin+1, BufferedImage.TYPE_INT_ARGB);
		int x=xmin;
		int y=ymin;
		String color="";
		String character="";		
		while(x<xmax){
			while(y<ymax){
				color=color+r.getPixelColor(x, y).getRGB();
				//System.out.println("xmax="+xmax+" x="+x+" ymax="+ymax+" y="+y+" color="+color+" colorcheck="+colorcheck);
				//System.out.println((x==xmin)+" "+(y==ymin)+" "+(colorcheck.equals("-1"))+" "+(loc.equals("other")));
				//System.out.println("Invert="+invert);
				if(x==xmin&&y==ymin&&colorcheck.equals("-1")&&loc.equals("other")){
					invert=true;
				}
				if(invert){
					if(color.equals(bgc)){
						img.setRGB(x-xmin, y-ymin, -16777216);
					}else{
						img.setRGB(x-xmin, y-ymin, -1);
					}
				}else{
					if(color.equals(bgc)){
						img.setRGB(x-xmin, y-ymin, -1);
					}else{
						img.setRGB(x-xmin, y-ymin, -16777216);
					}
				}
				color="";
				y++;
			}
			y=ymin;
			x++;
		}
		character="";
		character=character+tofind.charAt(c);
		match=searchForCharactersMatchKnown(img,ln,character,loc,xmin,ymin,xmax,ymax);
		if(!match){
			File me = new File("");
			File f=new File(me.getAbsolutePath()+"src/screen_reader/output/Error"+ln+"_"+c+".png");
			try {
				ImageIO.write(img, "png", f);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("");
		}else{
			System.out.print(character);
		}
		return match;
	}
	private static boolean searchForCharactersMatchKnown(BufferedImage img, int ln, String c, String loc, int xmin, int ymin, int xmax,	int ymax) {
		File me=new File("");
		BufferedImage letter=null;
		int x=0;
		int y=0;
		String c1="";
		String c2="";
		boolean matched=true;
		try{
			x=1;
			y=0;
			try{
				if(Character.isUpperCase(c.charAt(0))){
					letter=ImageIO.read(new File(me.getAbsolutePath()+"src/screen_reader/charlibrary/"+loc+"/"+c+"Upper.png"));
				}else if(c.equals(".")){
					letter=ImageIO.read(new File(me.getAbsolutePath()+"src/screen_reader/charlibrary/"+loc+"/dot.png"));
				}else if(c.equals(" ")){
					letter=ImageIO.read(new File(me.getAbsolutePath()+"src/screen_reader/charlibrary/"+loc+"/space.png"));
				}else{
					letter=ImageIO.read(new File(me.getAbsolutePath()+"src/screen_reader/charlibrary/"+loc+"/"+c+".png"));
				}
				outerloop:
				while(x<xmax-xmin){
					while(y<ymax-ymin){
						c1="";
						c2="";
						//System.out.println("xmax="+xmax+" x="+x+" ymax="+ymax+" y="+y+" color="+color);
						c1=c1+letter.getRGB(x, y);
						c2=c2+img.getRGB(x, y);
						if(!c1.equals(c2)){
							if(!(x==1 && y>=9)&&!(x==1 && y==4)&&!(x==1 && y==2)){
								matched=false;
								break outerloop;
							}
						}
						y++;
					}
					y=0;
					x++;
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}catch(StringIndexOutOfBoundsException e){
		}
		return matched;
	}
}
