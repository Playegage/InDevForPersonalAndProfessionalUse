package stuff;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;

public class MouseLocator {

	public static void main(String[] args) throws InterruptedException {
		Robot r=null;
		try {
			r=new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		int x=0;
		int y=0;
		while(true){
			x=(int)MouseInfo.getPointerInfo().getLocation().getX();
			y=(int)MouseInfo.getPointerInfo().getLocation().getY();
			System.out.println("x="+x+";");
			System.out.println("y="+y+";");
			
			System.out.println("color="+r.getPixelColor(x, y).getRGB()+";");
			Thread.sleep(1000);
		}

	}

}
