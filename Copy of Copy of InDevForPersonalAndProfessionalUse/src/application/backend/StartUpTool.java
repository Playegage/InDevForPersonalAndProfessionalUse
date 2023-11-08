package application.backend;

import java.awt.Robot;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import stuff.Typer;
import encrypter.StringMixer;

public class StartUpTool {
	static int j=0;//guc to 9
	static Scanner sf2;
	static String s1="";
	static String s2="";
	static File me=new File("");
	public static void startUp(int in2, int in3, String in4, String unameq, int delay, Typer t, Robot r) {
		try{ 
			sf2=new Scanner (new File(me.getAbsolutePath()+"/src/encrypter/StringComboData.txt"));
			System.out.println("clicked");
			if(in2<in3){
				while(j<in2){
					sf2.next();
					j++;
				}
				s1=s1+sf2.next();
				while(j<in3-1){
					sf2.next();
					j++;
				}
				s2=s2+sf2.next();
			}else{
				while(j<in3){
					sf2.next();
					j++;
				}
				s2=s2+sf2.next();
				while(j<in2-1){
					sf2.next();
					j++;
				}
				s1=s1+sf2.next();
			}
			j=0;
			String mixed=StringMixer.mix(s1,s2);
			s1="";
			s2="";
			r.delay(delay);
			switch(unameq){
				case"yes":
					t.typeAndEnter(in4);
			}
			r.delay(500);
			t.typeAndEnter(mixed);
			System.out.println("typed");
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}

}
