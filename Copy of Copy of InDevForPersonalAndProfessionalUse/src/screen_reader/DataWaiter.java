package screen_reader;
import java.awt.AWTException;
import java.awt.Robot;

import utilities.Mouse;
import utilities.Typer;


public class DataWaiter {
	@SuppressWarnings("unused")
	public static void main(String[] args){
		Robot r = null;
		try {
			r=new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		Typer t=new Typer(r);
		Mouse m=new Mouse(r);
	}
	public static void waitForCompletion(int waitonline, int startwithchar, Robot r){
		boolean waiting = true;
		boolean waitingfortwo = true;
		String buffer="";
		System.out.println("Waiting For Completion");
		LocationStorage.setCharactertostartwith(startwithchar+1);
		
		for(int i=0;i<startwithchar;i++){
			buffer=buffer+" ";
		}
		while(waiting){
			int ln=MassPixelReader.searchKnown(buffer,1,"terminal","",2,39+(12*waitonline),r,true);//waitonline=0...82
			if(ln<0 && waitingfortwo){
				waiting=false;
			}else if(ln<0){
				waitingfortwo=false;
			}else{
				waitingfortwo=true;
			}
		}
		System.out.print("Proceeding");
	}
}
