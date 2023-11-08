package stuff;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;


public class Mouse {
	Robot r;

	public Mouse(Robot rob){
		this.setR(rob);
	}
	public int getX(){
		int x=(int)MouseInfo.getPointerInfo().getLocation().getX();
		return x;
	}
	public int getY(){
		int y=(int)MouseInfo.getPointerInfo().getLocation().getY();
		return y;
	}
	public void lClick(int x, int y){
		r.mouseMove(x,y);
		r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	public void rClick(int x, int y){
		r.mouseMove(x,y);
		r.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		r.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
	}
	public void mClick(int x, int y){
		r.mouseMove(x,y);
		r.mousePress(InputEvent.BUTTON2_DOWN_MASK);
		r.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
	}
	public void doubleClick(int x, int y){
		lClick(x,y);
		r.delay(100);
		lClick(x,y);
		r.delay(100);
	}
	public void tripleClick(int x, int y){
		lClick(x,y);
		r.delay(100);
		lClick(x,y);
		r.delay(100);
		lClick(x,y);
		r.delay(100);
	}
	public void holdClick(int x, int y){
		r.mouseMove(x,y);
		r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	}
	public void releaseClick(int x, int y){
		r.mouseMove(x,y);
		r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	public void scrollD(int amount){
		r.mouseWheel(amount);
	}
	public void scrollU(int amount){
		r.mouseWheel(-amount);
	}
	public double[] getLocation(){
		double[] coords={MouseInfo.getPointerInfo().getLocation().getX(),MouseInfo.getPointerInfo().getLocation().getX()};
		return coords;
	}
	public void setR(Robot r) {
		this.r = r;
	}
}
