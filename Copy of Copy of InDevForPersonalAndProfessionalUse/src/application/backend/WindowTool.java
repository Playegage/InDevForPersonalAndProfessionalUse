package application.backend;

import java.awt.Robot;

import stuff.Mouse;

public class WindowTool {
	static int xinit = 350;
	static int yinit = 279;
	public static void setWindow(Mouse m, Robot r){
		m.lClick(xinit, yinit);
		r.delay(200);
	}
	public static void setWindow(int x, int y, Mouse m, Robot r){
		m.lClick(x, y);
		r.delay(200);
	}
}
