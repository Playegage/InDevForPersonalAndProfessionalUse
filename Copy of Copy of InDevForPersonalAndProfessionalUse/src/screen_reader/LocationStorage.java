package screen_reader;

public class LocationStorage {
	public static int charactertostartwith=1;//starts at 1
	public static int linetostartwith=1;//starts at 1
	public static int lengthofinput=0;
	public static int hoffset=0;
	public static int voffset=0;
	public static int font=12;

	public static boolean isOffByNoPixels(){
		if(hoffset==0&voffset==0){
			return true;
		}else{
			return false;
		}	
	}
	public static boolean both1DownAnd1Left(){
		if(hoffset==-1&voffset==-1){
			return true;
		}else{
			return false;
		}	
	}
	public static boolean both1UpAnd1Right(){
		if(hoffset==1&voffset==1){
			return true;
		}else{
			return false;
		}	
	}//EXAMPLE THAT CAN BE EXPANDED AD-INFINITEM
	public static int getCharactertostartwith() {
		return charactertostartwith;
	}
	public static void setCharactertostartwith(int charactertostartwith) {
		LocationStorage.charactertostartwith = charactertostartwith;
	}
	public static int getLinetostartwith() {
		return linetostartwith;
	}
	public static void setLinetostartwith(int linetostartwith) {
		LocationStorage.linetostartwith = linetostartwith;
	}
	public static int getLengthofinput() {
		return lengthofinput;
	}
	public static void setLengthofinput(int lengthofinput) {
		LocationStorage.lengthofinput = lengthofinput;
	}
	public static int getHoffset() {
		return hoffset;
	}
	public static void setHoffset(int hoffset) {
		LocationStorage.hoffset = hoffset;
	}
	public static int getVoffset() {
		return voffset;
	}
	public static void setVoffset(int voffset) {
		LocationStorage.voffset = voffset;
	}
	public static int getFont() {
		return font;
	}
	public static void setFont(int font) {
		LocationStorage.font = font;
	}
	
}
