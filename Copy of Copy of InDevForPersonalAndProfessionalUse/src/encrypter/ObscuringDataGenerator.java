package encrypter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;

public class ObscuringDataGenerator {
	private static int[] randomStrings(String[] s){
		int[] numbers={0,0};
		File me=new File("");
		try{
			String srand="";
			int max=16;
			int min=8;
			int z=0;
			FileWriter f=new FileWriter(me.getAbsolutePath()+"/src/encrypter/StringComboData.txt");
			File fl=new File(me.getAbsolutePath()+"/src/encrypter/StringComboData.txt");
			fl.delete();
			SecureRandom r0 = new SecureRandom();
			SecureRandom r1 = new SecureRandom();
			SecureRandom r2 = new SecureRandom();
			
			numbers[0]=(r0.nextInt((250 - 0)+1)+0)/2;
			numbers[1]=(r0.nextInt((250 - numbers[0])+1)+numbers[0])/2;
			
			String alphabet = "abcdefghijklmnopqrstuvwxyz123456789!@#$%&()_-?0";
			for(int x=0;x<250;x++){
				srand="";
				if(x==numbers[0]){
					srand=s[0];
					srand=srand+"\n";
					f.write(srand);
					srand="";
				}else if(x==numbers[1]){
					srand=s[1];
					srand=srand+"\n";
					f.write(srand);
					srand="";
				}else{
					z=r1.nextInt((max-min)+1)+min;
					for(int y=0;y<z;y++){
						srand=srand+alphabet.charAt(r2.nextInt(alphabet.length()));
					}
					srand=srand+"\n";
					f.write(srand);
					srand="";
				}
			}
			f.close();
		}catch(IOException e){
		}		
		return numbers;
	}
	public static String initialize(String s){
		String output="";
		int[] numbers=randomStrings(StringSplitter.split(s));
		s="";
		output=numbers[0]+" "+numbers[1];
		return output;
	}
}
