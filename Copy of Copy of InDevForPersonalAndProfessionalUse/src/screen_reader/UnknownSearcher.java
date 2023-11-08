package screen_reader;

import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

public class UnknownSearcher {

	public static void main(String[] args) {

	}
	
	public static String searchUnknown(int ln, String loc, String scrn, int xmin, int ymin, Robot r) {
		BufferedImage img=null;
		int workingfont=LocationStorage.getFont();
		int xmax=0;
		int ymax=0;
		int hoffset=0;
		int voffset=0;
		String bgc="";
		String colorcheck="";
		String character="";
		String match="";
		switch(loc){
			case"terminal":
				bgc=bgc+r.getPixelColor(1819,1020).getRGB();
			default:
				bgc="idk lol";
		}
		Date date=new Date();
		long times=date.getTime();
		try{
			System.out.println("Locating Offset");
			xmin=xmin+((LocationStorage.getCharactertostartwith()-1)*7)+1;
			ymax=ymin+workingfont;
			for(int c=0;c<100;c++){
				xmax=xmin+7;
				colorcheck="";
				colorcheck=colorcheck+r.getPixelColor(xmin+hoffset,ymin+voffset).getRGB();
				
				if(match.equals("")||LocationStorage.isOffByNoPixels()){
					hoffset=0;
					voffset=0;
					match=match+captureCharacter(img,loc,scrn,colorcheck,bgc,xmin,ymin,xmax,ymax,hoffset,voffset,r);
					if(!match.equals("")&&c==0){
						System.out.println("Not Off By Any");
					}
				}
				if(match.equals("")||LocationStorage.both1DownAnd1Left()){
					hoffset=-1;
					voffset=-1;
					match=match+captureCharacter(img,loc,scrn,colorcheck,bgc,xmin,ymin,xmax,ymax,hoffset,voffset,r);
					if(!match.equals("")&&c==0){
						System.out.println("Not Off By Any");
					}
				}
				
				if(match.subSequence(match.length()-2,match.length()-1).equals("  ")){
					match=match.substring(5,match.length()-2);
					break;
				}else{
					System.out.print(character);
				}
				xmin=xmax;
			}
			LocationStorage.setHoffset(hoffset);
			LocationStorage.setVoffset(voffset);
			System.out.println(match+" has been found on line "+ln);
			System.out.println(LocationStorage.isOffByNoPixels());
		}catch(StringIndexOutOfBoundsException e){
		}
		date= new Date();
		long timee=date.getTime();
		int time = (int) (timee-times);
		System.out.println("It took "+time/1000+" seconds");
		return match;
	}
	private static String captureCharacter(BufferedImage img, String loc, String scrn, String colorcheck, String bgc, int xmin, int ymin, int xmax, int ymax, int hoffset, int voffset, Robot r){
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
		character=searchForCharacterMatchUnknown(img, loc, xmin, ymin, xmax, ymax);
		if(character.equals("")){
			File me = new File("");
			File f=null;
			if(hoffset==0&&voffset==0){
				f=new File(me.getAbsolutePath()+"src/screen_reader/output/original.png");
			}else{
				f=new File(me.getAbsolutePath()+"src/screen_reader/output/error"+hoffset+"_"+voffset+".png");
			}
			try {
				ImageIO.write(img, "png", f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			File me = new File("");
			File f=null;
			if(hoffset!=0||voffset!=0){
				f=new File(me.getAbsolutePath()+"src/screen_reader/output/corrected.png");
			}else{
				f=new File(me.getAbsolutePath()+"src/screen_reader/output/original.png");
			}
			try {
				ImageIO.write(img, "png", f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return character;
	}
	private static String searchForCharacterMatchUnknown(BufferedImage img,String loc, int xmin, int ymin, int xmax, int ymax) {
		File me=new File("");
		BufferedImage letter=null;
		int x=0;
		int y=0;
		boolean match=true;
		String c1="";
		String c2="";
		String matched="";
		String[] charlibrary={"."," ","_","-","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T",
				              "U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r",
				              "s","t","u","v","w","x","y","z"};
		
		try{
			for(int index=0; index<charlibrary.length;index++){
				x=1;
				y=0;
				try{
					if(charlibrary[index].equals(".")){
						letter=ImageIO.read(new File(me.getAbsolutePath()+"src/screen_reader/charlibrary/"+loc+"/dot"));
					}else if(charlibrary[index].equals(" ")){
						letter=ImageIO.read(new File(me.getAbsolutePath()+"src/screen_reader/charlibrary/"+loc+"/space.png"));
					}else if(Character.isUpperCase(charlibrary[index].charAt(0))){
						letter=ImageIO.read(new File(me.getAbsolutePath()+"src/screen_reader/charlibrary/"+loc+"/"+charlibrary[index].toLowerCase()+"Upper.png"));
					}else{
						letter=ImageIO.read(new File(me.getAbsolutePath()+"src/screen_reader/charlibrary/"+loc+"/"+charlibrary[index]+".png"));
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
									match=false;
									break outerloop;
								}
							}
							y++;
						}
						y=0;
						x++;
					}
					if(match){
						matched=charlibrary[index];
//						File f=new File(me.getAbsolutePath()+"src/screen_reader/output/"+index+"_"+xmax+".png");
//						try {
//							ImageIO.write(img, "png", f);
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
						break;
					}else{
//						File f=new File(me.getAbsolutePath()+"src/screen_reader/output/error.png");
//						try {
//							ImageIO.write(img, "png", f);
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
					}
					match=true;
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}catch(StringIndexOutOfBoundsException e){
		}
		return matched;
	}
}
