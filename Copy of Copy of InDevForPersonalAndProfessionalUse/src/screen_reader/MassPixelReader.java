package screen_reader;
import java.awt.AWTException;
import java.awt.Robot;
import java.util.Date;


public class MassPixelReader {
	public static void main(String[] args){
		Robot r = null;
		try {
			r=new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		Date date=new Date();
		String tofind="teststring";
		int lines=4; 
		int xmin=2;
		int ymin=39;
		long times=date.getTime();
		String loc="terminal";
		System.out.println("Staring Search");
		
		int ln=searchKnown(tofind,lines,loc,"",xmin,ymin,r,false);
		if(ln>=0){
			System.out.println(searchUnknown(ln,loc,"",xmin,ymin,r)+" was returned");
		}
		date=new Date();
		long timee=date.getTime();
		int time = (int) (timee - times);
		System.out.print("It Took "+time/1000+" Seconds");
	}
	public static int searchKnown(String tofind, int lines, String loc, String scrn, int xmin, int ymin, Robot r, boolean waiting) {
		return KnownSearcher.searchKnown(tofind, lines, loc, scrn, xmin, ymin, r, waiting);
	}
	public static String searchUnknown(int ln, String loc, String scrn, int xmin, int ymin, Robot r) {
		return UnknownSearcher.searchUnknown(ln, loc, scrn, xmin, ymin, r);
	}

}
