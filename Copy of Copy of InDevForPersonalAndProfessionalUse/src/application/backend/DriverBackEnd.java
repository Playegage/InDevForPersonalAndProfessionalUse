package application.backend;

import java.awt.Robot;

import stuff.Mouse;
import stuff.Typer;
import encrypter.ObscuringDataGenerator;

@SuppressWarnings("static-access")
public class DriverBackEnd extends Thread{
	static Robot r;//from list
	static Typer t;//version 1
	static Mouse m;
	private Thread thr;
	String in0="";
	String[] in={"","","",""};
	
	
	public DriverBackEnd(String in0,String[] in, Robot rob){
		this.in0=in0;
		this.in=in;
		this.r=rob;
		System.out.println("Starting with "+in0+", "+in[1]+", "+in[2]+", "+in[3]+", and "+in[4]);
		
	}
	
	public void doStuff(){
		t=new Typer(r);
		m=new Mouse(r);
		System.out.println("doing stuff with "+in0+", "+in[1]+", "+in[2]+", "+in[3]+", "+in[5]+", and "+in[6]);
		int in1=Integer.parseInt(in[1]);
		int in2=Integer.parseInt(in[2]);
		int delay=(int)Double.parseDouble(in[4]);
		//System.out.println("Starting with "+in1+", "+in2+", "+in[0]+", "+in[3]+", and "+delay);
		switch(in0){
			case"start":
				WindowTool.setWindow(m, r);
				StartUpTool.startUp(in1,in2,in[0],in[3],delay,t,r);
				//uname ln1 ln2 useuname delay Ber
				r.delay(5000);
				break;
		}
	}
	public static String initialize(String[] in){
		return ObscuringDataGenerator.initialize(in[1]); 
	}
	public void start(){
		if (thr == null){
			thr=new Thread(this,in0);
			thr.run();
		}
	}
	@Override
	public void run(){
		doStuff();
	}
}
