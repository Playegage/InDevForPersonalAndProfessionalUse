package encrypter;

public class StringMixer {
	public static String mix(String s1, String s2) {
		String mixedString ="";
		try{
			if(s1.length()>=s2.length()){
				for(int i=0;i<s1.length();i++){
					mixedString=mixedString+s1.charAt(i);
					mixedString=mixedString+s2.charAt(i);
				}
			}else{
				for(int i=0;i<s2.length();i++){
					mixedString=mixedString+s2.charAt(i);
					mixedString=mixedString+s1.charAt(i);
				}
			}
		}catch(IndexOutOfBoundsException e){
		}
		return mixedString;
	}
}
