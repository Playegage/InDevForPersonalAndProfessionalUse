package extra_utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Calendar;

import stuff.Typer;

public class TimeCalculator{

	public static void main(String[] args) {
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		Typer t=new Typer(r);
		Calendar calendar = Calendar.getInstance();
		String sminss="";
		String eminss="";
		String sampm="";
		String eampm="";
		String htw="";
		String temp="";
		String firstsampm="am";
		String[] startlist={"7"};//Add meetings
		String[] stoplist={""};
		double desiredhours=9.0;
		double goal=50.0; 
		double hoursalreadyworked=0; //ansible template in jina2
		double hoursworkedthisinterval=0;
		double hoursfromlastfriday=10.0;
		double totalhoursleftthisweek=0;
		double hoursinmeeting=0;//tc 1 
		double totalhoursthisweek=hoursfromlastfriday;
		double[] hoursthisweek={0.0,10.0,8.5,0.0,0.0,0.0,0.0}; 
		int prevstop=0;
		int day = calendar.get(Calendar.DAY_OF_WEEK)-1;
		int stop24h=0;
		int prevshours=0;
		int shours=0;
		int smins=0;
		int ehours=0;
		int emins=0;
		boolean changedthisweek=true;
		
		String time=java.time.LocalTime.now().toString();
		System.out.println("It is "+time.substring(0,5));//+Integer.parseInt(time.substring(0,2)+time.substring(3,5)));		
		
		if(day >= 1 && day <= 3 && desiredhours == 9){
			desiredhours=12;
		}else if(day >= 4 && desiredhours == 9){
			desiredhours=10;
		}
		
		sampm=firstsampm;
		while(temp!=startlist[0]){
			temp=startlist[0];
			startlist[0]=startlist[0].replace(","," ");
			startlist[0]=startlist[0].replace("  "," ");
		}
		temp="";
		while(temp!=stoplist[0]){
			temp=stoplist[0];
			stoplist[0]=stoplist[0].replace(","," ");
			stoplist[0]=stoplist[0].replace("  "," ");
		}
		temp="";
		startlist=startlist[0].split(" ");
		stoplist=stoplist[0].split(" ");
		for(int i=0;i<startlist.length;i++){
			shours=0;
			smins=0;
			ehours=0;
			emins=0;
			sminss="";
			eminss="";
			if(startlist[i].contains(":")){
				startlist[i]=startlist[i].replace(":","");
			}else if(startlist[i].contains(".")){
				startlist[i]=startlist[i].replace(".","");
			}
			if(startlist[i].length()==1){
				startlist[i]="0"+startlist[i]+"00";
			}else if(startlist[i].length()==2){
				startlist[i]=startlist[i]+"00";
			}else if(startlist[i].length()<4){
				startlist[i]="0"+startlist[i];
			}
			try{

				if(stoplist[i].contains(":")){
					stoplist[i]=stoplist[i].replace(":","");
				}else if(stoplist[i].contains(".")){
					stoplist[i]=stoplist[i].replace(".","");
				}
				if(stoplist[i].length()==1){
					stoplist[i]="0"+stoplist[i]+"00";
				}else if(stoplist[i].length()==2){
					stoplist[i]=stoplist[i]+"00";
				}else if(stoplist[i].length()<4){
					stoplist[i]="0"+stoplist[i];
				}
			}catch(IndexOutOfBoundsException e){}
			prevshours=shours;
			shours=Integer.parseInt(startlist[i].substring(0,2));
			if(firstsampm.equals("am")&&i>0){
				if(shours>=prevshours && shours!=12 && eampm.equals("am")){
					sampm="am";
				}else if(shours>=prevshours && shours!=12 && eampm.equals("pm")){
					sampm="pm";
				}else if(sampm.equals("pm")||eampm.equals("pm")){
					sampm="am";
				}else{
					sampm="pm";
				}
			}else if(i>0){
				if(shours>=prevshours && shours!=12 && eampm.equals("pm")){
					sampm="pm";
				}else if(shours>=prevshours && shours!=12 && eampm.equals("am")){
					sampm="am";
				}else if(sampm.equals("am")||eampm.equals("am")){
					sampm="pm";
				}else{
					sampm="am";
				}
			}
			if(prevstop>shours){
				if(sampm.equals("pm")){
					sampm="am";
				}else{
					sampm="pm";
				}
			}
			eampm=sampm;
			if(shours>11){
				if(shours!=12){
					shours=shours-12;
				}
				if(sampm.equals("pm")){
					sampm="am";
				}else{
					sampm="pm";
				}
			}
			smins=Integer.parseInt(startlist[i].substring(2));
			if(smins>60){
				smins=smins-60;
				shours++;
			}
			if(smins<10){
				sminss=sminss+"0";
			}
			sminss=sminss+smins;
			try{
				ehours=Integer.parseInt(stoplist[i].substring(0,2));
				if(ehours<shours){
					stop24h=ehours+12;	
					if(sampm.equals("pm")){
						eampm="am";
					}else{
						eampm="pm";
					}
				}else{
					stop24h=ehours;	
				}
				hoursworkedthisinterval=stop24h-shours;
				hoursalreadyworked=hoursalreadyworked+hoursworkedthisinterval;
			}catch(IndexOutOfBoundsException e){
				ehours=(int)(shours+desiredhours-hoursalreadyworked);
			}
			if(ehours>=12){
				if(ehours!=12){
					ehours=ehours-12;
				}
				if(sampm.equals("pm")){
					eampm="am";
				}else{
					eampm="pm";
				}
				if(shours==12){
					if(sampm.equals("pm")){
						sampm="am";
					}else{
						sampm="pm";
					}
				}
			}
			try{
				emins=Integer.parseInt(stoplist[i].substring(2));
				if((smins-emins)!=0){
					hoursalreadyworked=hoursalreadyworked+(-(smins-emins)/60.);
					hoursworkedthisinterval=hoursworkedthisinterval+(-(smins-emins)/60.);
				}
			}catch(IndexOutOfBoundsException e){
				emins=(int)Math.rint((((smins/60.)+((desiredhours-hoursalreadyworked)-(int)(desiredhours-hoursalreadyworked)))*60));
			}
			if(emins>=60){
				emins=emins-60;
				ehours=ehours+1;
			}
			if(emins<10){
				eminss=eminss+"0";
			}
			eminss=eminss+emins;
			if(shours==12&&startlist.length<=stoplist.length){
				if(sampm.equals("pm")){
					sampm="am";
				}else{
					sampm="pm";
				}
			}

			hoursalreadyworked=Math.round(hoursalreadyworked * 10.0) / 10.0;
			hoursworkedthisinterval=Math.round(hoursworkedthisinterval * 10.0) / 10.0;
			prevstop=ehours;
			
			try{
				if(!stoplist[i].equals("")){
					System.out.println((Math.round(hoursworkedthisinterval * 10.0) / 10.0)+" hours worked between "+shours+":"+sminss+sampm+" and "+ehours+":"+eminss+eampm);
				}
			}catch(IndexOutOfBoundsException e){
				totalhoursthisweek=hoursfromlastfriday;
				for(int i2=0;i2<hoursthisweek.length;i2++){
					totalhoursthisweek=totalhoursthisweek+hoursthisweek[i2];
				}
				totalhoursleftthisweek = Math.round((goal - totalhoursthisweek) * 10.0) / 10.0;
				if(totalhoursleftthisweek > (desiredhours - hoursalreadyworked)){
					if(ehours>12){
						ehours=ehours-12;
					}
					System.out.println((Math.round((desiredhours-hoursalreadyworked) * 10.0) / 10.0)+" more hours = "+shours+":"+sminss+sampm+" -> "+ehours+":"+eminss+eampm);
				}else{
					///WIP
					ehours=0;
					emins=0;
					eminss="";
					ehours=(int)(shours+totalhoursleftthisweek);
					if(ehours>=12){
						if(ehours!=12){
							ehours=ehours-12;
						}
						if(sampm.equals("pm")){
							eampm="am";
						}else{
							eampm="pm";
						}
						if(shours==12){
							if(sampm.equals("pm")){
								sampm="am";
							}else{
								sampm="pm";
							}
						}
					}
					try{
						emins=Integer.parseInt(stoplist[i].substring(2));
						if((smins-emins)!=0){
							hoursalreadyworked=hoursalreadyworked+(-(smins-emins)/60.);
							hoursworkedthisinterval=hoursworkedthisinterval+(-(smins-emins)/60.);
						}
					}catch(IndexOutOfBoundsException e2){
						emins=(int)Math.rint((((smins/60.)+((totalhoursleftthisweek)-(int)(totalhoursleftthisweek)))*60));
					}
					if(emins>=60){
						emins=emins-60;
						ehours=ehours+1;
					}
					if(emins<10){
						eminss=eminss+"0";
					}
					eminss=eminss+emins;
					///
					if(ehours>12){
						ehours=ehours-12;
					}
					System.out.println(totalhoursleftthisweek+" more hours = "+shours+":"+sminss+sampm+" -> "+ehours+":"+eminss+eampm);
				}
			}
		}
		if(hoursinmeeting>0.0){
			System.out.println();
			System.out.println(hoursinmeeting+" hours in a meeting today");
		}
		System.out.println();
		System.out.println(hoursalreadyworked+" hours worked today");
		if(hoursalreadyworked>desiredhours){
			temp=""+(hoursalreadyworked-desiredhours);
			System.out.println(temp.substring(0,3)+" hours worked over today");
		}
		totalhoursthisweek=hoursfromlastfriday;
		if(day==1){
			for(int i=0;i<hoursthisweek.length;i++){
				totalhoursthisweek=totalhoursthisweek+hoursthisweek[i];
			}
			if(!changedthisweek){//!offfriday && !changedthisweek){
				t.gototop();
				t.findIt("hoursfromlastfriday=.*;");
				hoursfromlastfriday=totalhoursthisweek-goal;
				t.typeOnly("hoursfromlastfriday="+hoursfromlastfriday+";");
				t.gototop();
				t.findIt("changedthisweek=false;");	
				t.typeOnly("changedthisweek=true;");
				for(int i=1;i<hoursthisweek.length;i++){
					hoursthisweek[i]=0.0;
				}
				if((hoursthisweek[day]!=hoursalreadyworked||(day==1&&hoursthisweek[day]==0.0))){
					t.gototop();
					r.delay(200);
					t.findIt("double\\[\\] hoursthisweek=\\{.*,.*,.*,.*,.*\\};");
					hoursthisweek[day]=hoursalreadyworked;
					htw=""+hoursthisweek[0];
					for(int i=1;i<hoursthisweek.length;i++){
						htw=htw+","+hoursthisweek[i];
					}
					t.typeOnly("double[] hoursthisweek={0.0,0.0,0.0,0.0,0.0,0.0,0.0};");
					r.delay(200);
					t.ctrlS();
					
				}
			}else if(!changedthisweek){
				t.gototop();
				t.findIt("hoursfromlastfriday=.*;");
				t.typeOnly("hoursfromlastfriday="+hoursfromlastfriday+";");
				t.gototop();
				t.findIt("changedthisweek=false;");	
				t.typeOnly("changedthisweek=true;");
				for(int i=0;i<hoursthisweek.length;i++){
					hoursthisweek[i]=0.0;
				}
				if((hoursthisweek[day]!=hoursalreadyworked||(day==1&&hoursthisweek[day]==0.0))){
					t.gototop();
					r.delay(200);
					t.findIt("double\\[\\] hoursthisweek=\\{.*,.*,.*,.*,.*\\};");
					hoursthisweek[day]=hoursalreadyworked;
					htw=""+hoursthisweek[0];
					for(int i=1;i<hoursthisweek.length;i++){
						htw=htw+","+hoursthisweek[i];
					}
					t.typeOnly("double[] hoursthisweek={0.0,0.0,0.0,0.0,0.0,0.0,0.0};");
					r.delay(200);
					t.ctrlS();
					
				}
			}
		}
		totalhoursthisweek=0;
		if(day>=0&&(hoursthisweek[day]!=hoursalreadyworked)){//||(day==1&&hoursthisweek[day]==0.0))){
			t.gototop();
			r.delay(200);
			t.findIt("double\\[\\] hoursthisweek=\\{.*,.*,.*,.*,.*\\};");
			hoursthisweek[day]=hoursalreadyworked;
			htw=""+hoursthisweek[0];
			for(int i=1;i<hoursthisweek.length;i++){
				htw=htw+","+hoursthisweek[i];
			}
			t.typeOnly("double[] hoursthisweek={"+htw+"};");
			r.delay(200);
			t.ctrlS();
		}
		for(int i=0;i<hoursthisweek.length;i++){
			totalhoursthisweek=totalhoursthisweek+hoursthisweek[i];
		}
		totalhoursthisweek=totalhoursthisweek+hoursfromlastfriday;
		temp=""+totalhoursthisweek;
		System.out.println(temp.substring(0,temp.indexOf(".")+2)+" hours worked this week");
		if((totalhoursthisweek-goal)>0){
			temp=""+(totalhoursthisweek-goal);
			System.out.println(temp.substring(0,temp.indexOf(".")+2)+" hours worked over this week");
		}else{
			temp=""+Math.round((goal - totalhoursthisweek) * 10.0) / 10.0;
			
			System.out.println(temp.substring(0,temp.indexOf(".")+2)+" hours to go this week");
		}
		if(day>=4){//&&offfriday){
			if(changedthisweek){
				t.findIt("changedthisweek=true;");	
				t.typeOnly("changedthisweek=false;");
			}
			System.out.println("Dont Forget To Input time And Reserve Room");
		}
	}
}
