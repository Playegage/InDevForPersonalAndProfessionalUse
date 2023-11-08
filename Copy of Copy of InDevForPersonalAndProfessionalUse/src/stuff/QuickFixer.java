package stuff;

import java.awt.AWTException;
import java.awt.Robot;

public class QuickFixer {
	public static void main(String[] args) {
		Robot r=null;
		try {
			r=new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		Typer t=new Typer(r);
		Mouse m=new Mouse(r);
		String file="";
		quickfix(file,t,m,r);
	}
	public static void quickfix(String file,Typer t, Mouse m, Robot r){
		t.goToFile(file);
		r.delay(500);
		t.left(1);
		r.delay(500);
		while(m.getY()<700){
			t.findItAndMove(false,0," ","return null");
			t.right(1);
			t.openQuickFixPane();
			//t.down(0);
			t.confirm();
		}
	}
}
