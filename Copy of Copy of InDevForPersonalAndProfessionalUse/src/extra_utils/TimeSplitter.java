package extra_utils;

public class TimeSplitter {

	public static void main(String[] args) {
		double hoursworked=3.3;
		System.out.println(splitHours(hoursworked));
	}
	
	public static String splitHours(double hoursworked){
		double t1=hoursworked/7;
		double t2=t1;
		hoursworked=hoursworked-(2*t1);
		double t10=.05*hoursworked;
		double t11=t10;
		hoursworked=hoursworked-(2*t10);
		double t3a=hoursworked/5;
		double t3=t3a/2;
		double t4=t3;
		double t5=t3;
		double t6=t3;
		double t7=t3a;
		double t8=t3a;
		double t9=t3a;
		double total=t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11;

		double t1rounded=Math.round(t1*10)/10.0;
		double t2rounded=Math.round(t2*10)/10.0;
		double t3rounded=Math.round(t3*10)/10.0;
		double t4rounded=Math.round(t4*10)/10.0;
		double t5rounded=Math.round(t5*10)/10.0;
		double t6rounded=Math.round(t6*10)/10.0;
		double t7rounded=Math.round(t7*10)/10.0;
		double t8rounded=Math.round(t8*10)/10.0;
		double t9rounded=Math.round(t9*10)/10.0;
		double t10rounded=Math.round(t10*10)/10.0;
		double t11rounded=Math.round(t11*10)/10.0;
		double totalafterrounding=t1rounded+t2rounded+t3rounded+t4rounded+t5rounded+t6rounded+t7rounded+t8rounded+t9rounded+t10rounded+t11rounded;
		String spaces="\n                                                                                                                                      ";
		return spaces+"total="+totalafterrounding+spaces+"1="+t1rounded+spaces+"2="+t2rounded+spaces+"3="+t3rounded+spaces+"4="+t4rounded+spaces+"5="+t5rounded+spaces+"6="+t6rounded+spaces+"7="+t7rounded+spaces+"8="+t8rounded+spaces+"9="+t9rounded+spaces+"10="+t10rounded+spaces+"11="+t11rounded;
	}
}
