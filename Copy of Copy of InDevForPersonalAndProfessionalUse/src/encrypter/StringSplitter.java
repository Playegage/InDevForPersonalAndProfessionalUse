package encrypter;

public class StringSplitter {
	public static String[] split(String original){
		String s1="";
		String s2="";
		String[] splitString={"",""};
		try{
			for(int i=0;i<original.length();i++){
				s1=s1+original.charAt(i);
				i++;
				s2=s2+original.charAt(i);
			}
		}catch(IndexOutOfBoundsException e){
		}
		splitString[0]=s1;
		splitString[1]=s2;
		return splitString;
	}
}
