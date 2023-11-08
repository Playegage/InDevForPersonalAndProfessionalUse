package extra_utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Calendar;

import stuff.Mouse;

public class MovementTester {

	public static void main(String[] args) {
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		Mouse m=new Mouse(r);
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK)-1;
		if(day == 1){
			System.out.println("monday");
			//monday();
		}else if(day == 2){
			System.out.println("tuesday");
			//tuesday();
		}else if(day == 3){
			System.out.println("wednesday");
			//wednesday();
		}else if(day == 4){
			System.out.println("thursday");
			//thursday();
		}else if(day == 5){
			System.out.println("friday");
			//friday();
		}
		
		m.lClick(566, 1074);
		r.delay(10);
		m.lClick(612, 1067);
		r.delay(10);
		m.lClick(753,515);
		r.delay(1000);
		m.lClick(753,515);
		r.delay(1000);
		while(true){
			m.lClick(753,515);
			r.delay(2000+((int)(100*Math.random())));
			m.lClick(753,515);
			r.delay(58000+((int)(100*Math.random())));
			r.delay(58000+((int)(100*Math.random())));
			r.delay(58000+((int)(100*Math.random())));
		}
	}

}
