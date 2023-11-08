package stuff;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Typer {
	Robot r;
	Clipboard c=Toolkit.getDefaultToolkit().getSystemClipboard();
	
	public Typer(Robot rob){
		this.setR(rob);
	}
	private void type(String line){
		for(int i=0;i<line.length();i++){
			String test=""+line.charAt(i);
			switch(test){
				case" ":
					r.keyPress(KeyEvent.VK_SPACE);
					r.keyRelease(KeyEvent.VK_SPACE);
					break;
				case"a":
					r.keyPress(KeyEvent.VK_A);
					r.keyRelease(KeyEvent.VK_A);
					break;
				case"A":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_A);
					r.keyRelease(KeyEvent.VK_A);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"b":
					r.keyPress(KeyEvent.VK_B);
					r.keyRelease(KeyEvent.VK_B);
					break;
				case"B":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_B);
					r.keyRelease(KeyEvent.VK_B);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"c":
					r.keyPress(KeyEvent.VK_C);
					r.keyRelease(KeyEvent.VK_C);
					break;
				case"C":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_C);
					r.keyRelease(KeyEvent.VK_C);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"d":
					r.keyPress(KeyEvent.VK_D);
					r.keyRelease(KeyEvent.VK_D);
					break;
				case"D":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_D);
					r.keyRelease(KeyEvent.VK_D);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"e":
					r.keyPress(KeyEvent.VK_E);
					r.keyRelease(KeyEvent.VK_E);
					break;
				case"E":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_E);
					r.keyRelease(KeyEvent.VK_E);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"f":
					r.keyPress(KeyEvent.VK_F);
					r.keyRelease(KeyEvent.VK_F);
					break;
				case"F":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_F);
					r.keyRelease(KeyEvent.VK_F);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"g":
					r.keyPress(KeyEvent.VK_G);
					r.keyRelease(KeyEvent.VK_G);
					break;
				case"G":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_G);
					r.keyRelease(KeyEvent.VK_G);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"h":
					r.keyPress(KeyEvent.VK_H);
					r.keyRelease(KeyEvent.VK_H);
					break;
				case"H":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_H);
					r.keyRelease(KeyEvent.VK_H);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"i":
					r.keyPress(KeyEvent.VK_I);
					r.keyRelease(KeyEvent.VK_I);
					break;
				case"I":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_I);
					r.keyRelease(KeyEvent.VK_I);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"j":
					r.keyPress(KeyEvent.VK_J);
					r.keyRelease(KeyEvent.VK_J);
					break;
				case"J":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_J);
					r.keyRelease(KeyEvent.VK_J);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"k":
					r.keyPress(KeyEvent.VK_K);
					r.keyRelease(KeyEvent.VK_K);
					break;
				case"K":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_K);
					r.keyRelease(KeyEvent.VK_K);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"l":
					r.keyPress(KeyEvent.VK_L);
					r.keyRelease(KeyEvent.VK_L);
					break;
				case"L":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_L);
					r.keyRelease(KeyEvent.VK_L);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"m":
					r.keyPress(KeyEvent.VK_M);
					r.keyRelease(KeyEvent.VK_M);
					break;
				case"M":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_M);
					r.keyRelease(KeyEvent.VK_M);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"n":
					r.keyPress(KeyEvent.VK_N);
					r.keyRelease(KeyEvent.VK_N);
					break;
				case"N":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_N);
					r.keyRelease(KeyEvent.VK_N);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"o":
					r.keyPress(KeyEvent.VK_O);
					r.keyRelease(KeyEvent.VK_O);
					break;
				case"O":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_O);
					r.keyRelease(KeyEvent.VK_O);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"p":
					r.keyPress(KeyEvent.VK_P);
					r.keyRelease(KeyEvent.VK_P);
					break;
				case"P":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_P);
					r.keyRelease(KeyEvent.VK_P);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"q":
					r.keyPress(KeyEvent.VK_Q);
					r.keyRelease(KeyEvent.VK_Q);
					break;
				case"Q":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_Q);
					r.keyRelease(KeyEvent.VK_Q);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"r":
					r.keyPress(KeyEvent.VK_R);
					r.keyRelease(KeyEvent.VK_R);
					break;
				case"R":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_R);
					r.keyRelease(KeyEvent.VK_R);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"s":
					r.keyPress(KeyEvent.VK_S);
					r.keyRelease(KeyEvent.VK_S);
					break;
				case"S":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_S);
					r.keyRelease(KeyEvent.VK_S);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"t":
					r.keyPress(KeyEvent.VK_T);
					r.keyRelease(KeyEvent.VK_T);
					break;
				case"T":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_T);
					r.keyRelease(KeyEvent.VK_T);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"u":
					r.keyPress(KeyEvent.VK_U);
					r.keyRelease(KeyEvent.VK_U);
					break;
				case"U":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_U);
					r.keyRelease(KeyEvent.VK_U);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"v":
					r.keyPress(KeyEvent.VK_V);
					r.keyRelease(KeyEvent.VK_V);
					break;
				case"V":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_V);
					r.keyRelease(KeyEvent.VK_V);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"w":
					r.keyPress(KeyEvent.VK_W);
					r.keyRelease(KeyEvent.VK_W);
					break;
				case"W":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_W);
					r.keyRelease(KeyEvent.VK_W);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"x":
					r.keyPress(KeyEvent.VK_X);
					r.keyRelease(KeyEvent.VK_X);
					break;
				case"X":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_X);
					r.keyRelease(KeyEvent.VK_X);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"y":
					r.keyPress(KeyEvent.VK_Y);
					r.keyRelease(KeyEvent.VK_Y);
					break;
				case"Y":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_Y);
					r.keyRelease(KeyEvent.VK_Y);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"z":
					r.keyPress(KeyEvent.VK_Z);
					r.keyRelease(KeyEvent.VK_Z);
					break;
				case"Z":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_Z);
					r.keyRelease(KeyEvent.VK_Z);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"`":
					r.keyPress(KeyEvent.VK_BACK_QUOTE);
					r.keyRelease(KeyEvent.VK_BACK_QUOTE);
					break;
				case"~":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_BACK_QUOTE);
					r.keyRelease(KeyEvent.VK_BACK_QUOTE);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"1":
					r.keyPress(KeyEvent.VK_1);
					r.keyRelease(KeyEvent.VK_1);
					break;
				case"!":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_1);
					r.keyRelease(KeyEvent.VK_1);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"2":
					r.keyPress(KeyEvent.VK_2);
					r.keyRelease(KeyEvent.VK_2);
					break;
				case"@":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_2);
					r.keyRelease(KeyEvent.VK_2);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"3":
					r.keyPress(KeyEvent.VK_3);
					r.keyRelease(KeyEvent.VK_3);
					break;
				case"#":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_3);
					r.keyRelease(KeyEvent.VK_3);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"4":
					r.keyPress(KeyEvent.VK_4);
					r.keyRelease(KeyEvent.VK_4);
					break;
				case"$":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_4);
					r.keyRelease(KeyEvent.VK_4);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"5":
					r.keyPress(KeyEvent.VK_5);
					r.keyRelease(KeyEvent.VK_5);
					break;
				case"%":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_5);
					r.keyRelease(KeyEvent.VK_5);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"6":
					r.keyPress(KeyEvent.VK_6);
					r.keyRelease(KeyEvent.VK_6);
					break;
				case"^":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_6);
					r.keyRelease(KeyEvent.VK_6);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"7":
					r.keyPress(KeyEvent.VK_7);
					r.keyRelease(KeyEvent.VK_7);
					break;
				case"&":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_7);
					r.keyRelease(KeyEvent.VK_7);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"8":
					r.keyPress(KeyEvent.VK_8);
					r.keyRelease(KeyEvent.VK_8);
					break;
				case"*":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_8);
					r.keyRelease(KeyEvent.VK_8);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"9":
					r.keyPress(KeyEvent.VK_9);
					r.keyRelease(KeyEvent.VK_9);
					break;
				case"(":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_9);
					r.keyRelease(KeyEvent.VK_9);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"0":
					r.keyPress(KeyEvent.VK_0);
					r.keyRelease(KeyEvent.VK_0);
					break;
				case")":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_0);
					r.keyRelease(KeyEvent.VK_0);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"-":
					r.keyPress(KeyEvent.VK_MINUS);
					r.keyRelease(KeyEvent.VK_MINUS);
					break;
				case"_":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_MINUS);
					r.keyRelease(KeyEvent.VK_MINUS);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"=":
					r.keyPress(KeyEvent.VK_EQUALS);
					r.keyRelease(KeyEvent.VK_EQUALS);
					break;
				case"+":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_EQUALS);
					r.keyRelease(KeyEvent.VK_EQUALS);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case",":
					r.keyPress(KeyEvent.VK_COMMA);
					r.keyRelease(KeyEvent.VK_COMMA);
					break;
				case"<":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_COMMA);
					r.keyRelease(KeyEvent.VK_COMMA);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case".":
					r.keyPress(KeyEvent.VK_PERIOD);
					r.keyRelease(KeyEvent.VK_PERIOD);
					break;
				case">":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_PERIOD);
					r.keyRelease(KeyEvent.VK_PERIOD);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"/":
					r.keyPress(KeyEvent.VK_SLASH);
					r.keyRelease(KeyEvent.VK_SLASH);
					break;
				case"?":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_SLASH);
					r.keyRelease(KeyEvent.VK_SLASH);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case";":
					r.keyPress(KeyEvent.VK_SEMICOLON);
					r.keyRelease(KeyEvent.VK_SEMICOLON);
					break;
				case":":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_SEMICOLON);
					r.keyRelease(KeyEvent.VK_SEMICOLON);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"\'":
					r.keyPress(KeyEvent.VK_QUOTE);
					r.keyRelease(KeyEvent.VK_QUOTE);
					break;
				case"\"":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_QUOTE);
					r.keyRelease(KeyEvent.VK_QUOTE);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"[":
					r.keyPress(KeyEvent.VK_OPEN_BRACKET);
					r.keyRelease(KeyEvent.VK_OPEN_BRACKET);
					break;
				case"{":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_OPEN_BRACKET);
					r.keyRelease(KeyEvent.VK_OPEN_BRACKET);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"]":
					r.keyPress(KeyEvent.VK_CLOSE_BRACKET);
					r.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
					break;
				case"}":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_CLOSE_BRACKET);
					r.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
				case"\\":
					r.keyPress(KeyEvent.VK_BACK_SLASH);
					r.keyRelease(KeyEvent.VK_BACK_SLASH);
					break;
				case"|":
					r.keyPress(KeyEvent.VK_SHIFT);
					r.keyPress(KeyEvent.VK_BACK_SLASH);
					r.keyRelease(KeyEvent.VK_BACK_SLASH);
					r.keyRelease(KeyEvent.VK_SHIFT);
					break;
			}				
		}
	}
	public void typeAndEnter(String line){
		type(line);
		confirm();
	}
	public void typeOnly(String line){
		type(line);
	}
	public void confirm(){
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public void exit(){
		typeAndEnter("exit");
	}
	public void ctrlC(){
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}//TODO
	public void ctrlA(){
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	public void ctrlS(){
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_S);
		r.keyRelease(KeyEvent.VK_S);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	public void ctrlZ(){
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_Z);
		r.keyRelease(KeyEvent.VK_Z);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	public void find(){
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_F);
		r.keyRelease(KeyEvent.VK_F);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	public void copyAll(){
		ctrlA();
		r.delay(100);
		ctrlC();
		r.delay(100);
	}
	public String copyFile(String file){
		goToFile(file);
		r.delay(200);
		left(1);
		r.delay(200);
		copyAll();
		return getCopied();
	}
	public List<Integer> findOccurencesInFile(String filecontents, String checkfor){
		int count=0;
		List<Integer> places=new ArrayList<Integer>();
		places.add(filecontents.indexOf(checkfor));
		for(int i=filecontents.indexOf(checkfor);i>=0;i=filecontents.indexOf(checkfor,i+1)){
			places.add(filecontents.indexOf(checkfor,i));
			count++;
			System.out.println(places.get(count));
			
		}
		return places;
	}
	public List<Integer> findNewLinesInFile(String filecontents){
		List<Integer> places=new ArrayList<Integer>();
		places.add(filecontents.indexOf("\n"));
		for(int i=filecontents.indexOf("\n");i>=0;i=filecontents.indexOf("\n",i+1)){
			places.add(filecontents.indexOf("\n",i));
		}
		return places;
	}
	public List<String> grep(String filename, String checkfor, String beforeafterboth, int linesbeforeafter){
		int linenum=0;
		int before=0;
		int after=0;
		boolean notfirstline=true;
		boolean search=true;
		String filecontents=copyFile(filename);
		List<Integer> places=findOccurencesInFile(filecontents,checkfor);
		List<Integer> newlines=findNewLinesInFile(filecontents);
		List<String> occurences=new ArrayList<String>();
		for(int i=0;i<=places.size();i++){
			linenum=0;
			search=true;
			while(search){
				if(newlines.get(linenum)>places.get(i)){
					search=false;
				}else{
					linenum++;
				}
			}
			if(((linenum-1)-linesbeforeafter)>=0){
				before=(linenum-1)-linesbeforeafter;
			}else{
				before=0;
			}
			if((linenum+linesbeforeafter)<newlines.size()){
				after=linenum+linesbeforeafter;
			}else{
				after=newlines.size()-1;
			}
			notfirstline=places.get(0)>newlines.get(0);
			if(notfirstline){
				notfirstline=linenum>linesbeforeafter;
			}
			if(beforeafterboth.equals("before")&&notfirstline){
				occurences.add(filecontents.substring(newlines.get(before),newlines.get(linenum)));
			}else if(beforeafterboth.equals("after")&&notfirstline){
				occurences.add(filecontents.substring(newlines.get((linenum-1)),newlines.get(after)));
			}else if(beforeafterboth.equals("both")&&notfirstline){
				occurences.add(filecontents.substring(newlines.get(before),newlines.get(after)));
			}else if(notfirstline){
				occurences.add(filecontents.substring(newlines.get((linenum-1)),newlines.get(linenum)));
			}else if(beforeafterboth.equals("before")){
				occurences.add(filecontents.substring(0,newlines.get(linenum)));
			}else if(beforeafterboth.equals("after")){
				occurences.add(filecontents.substring(0,newlines.get(after)));
			}else if(beforeafterboth.equals("both")){
				occurences.add(filecontents.substring(0,newlines.get(after)));
			}else{
				occurences.add(filecontents.substring(0,newlines.get(linenum)));
			}
		}
		return occurences;
	}
	//TODO
	public void paste(){
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	public void fullscreenF(){
		r.keyPress(KeyEvent.VK_F11);
		r.keyRelease(KeyEvent.VK_F11);
	}
	public void fullscreenC(){
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	public String getCopied(){
		String copiedText="";
		try {
			copiedText= (String) c.getData(DataFlavor.stringFlavor);
		} catch (UnsupportedFlavorException | IOException e) {
			e.printStackTrace();
		}
		return copiedText;	
	}
	public void setR(Robot r) {
		this.r = r;
	}
	//TODO
	public void tab(int times){
		for(int i=0;i<times;i++){
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			r.delay(100);
		}
	}
	public void home(){
		r.keyPress(KeyEvent.VK_HOME);
		r.keyRelease(KeyEvent.VK_HOME);
	}
	public void end(){
		r.keyPress(KeyEvent.VK_END);
		r.keyRelease(KeyEvent.VK_END);
	}
	public void esc(){
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
	}
	public void left(int times){
		for(int i=0;i<times;i++){
			r.keyPress(KeyEvent.VK_LEFT);
			r.keyRelease(KeyEvent.VK_LEFT);
			r.delay(100);
		}
	}
	public void right(int times){
		for(int i=0;i<times;i++){
			r.keyPress(KeyEvent.VK_RIGHT);
			r.keyRelease(KeyEvent.VK_RIGHT);
			r.delay(100);
		}
	}
	public void up(int times){
		for(int i=0;i<times;i++){
			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);
			r.delay(100);
		}
	}
	public void down(int times){
		for(int i=0;i<times;i++){
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.delay(100);
		}
	}
	///////////ECLIPSE SHORTCUTS////////////////

	public void openClassNavigationPane(){
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyRelease(KeyEvent.VK_T);
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_SHIFT);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	public void openQuickFixPane(){
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_1);
		r.keyPress(KeyEvent.VK_1);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	public void goToFile(String file){
		openClassNavigationPane();
		r.delay(200);
		typeOnly(file);
		r.delay(200);
		confirm();
		r.delay(1000);
	}
	public void findIt(String findit){
		find();
		r.delay(200);
		typeAndEnter(findit);
		r.delay(200);
		esc();
	}
	public void findItAndMove(boolean newlinebefore,int up,String homeend,String findit){
		findIt(findit);
		if(up>0){
			r.delay(500);
			up(up);
		}
		if(homeend.equals(" ")){
			//do nothing
		}else if(homeend.equals("end")){
			r.delay(500);
			end();
			r.delay(500);
		}else if(homeend.equals("home")){
			r.delay(500);
			home();
			r.delay(500);
		}
		if(newlinebefore){
			confirm();
			r.delay(500);
		}
	}
	public void replaceIt(String findit, String replacewith){
		find();
		r.delay(200);
		typeAndEnter(findit);
		r.delay(200);
		tab(1);
		r.delay(200);
		typeOnly(replacewith);
		r.delay(200);
		tab(7);
		r.delay(200);
		confirm();
	}
	public String findCopyReturn(String findit){
		r.delay(200);
		findItAndMove(false, 0, " ", findit);
		r.delay(200);
		ctrlC();
		r.delay(200);
		String copied=getCopied();
		return copied;
	}
	public void gototop(){
		findItAndMove(false,0," ","package");
	}
	//TODO
}
