package stuff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;

public class authtest {

	public static void main(String[] args) throws IOException {
		/*
		Scanner u= new Scanner(System.in);
		System.out.println("Enter Username:");
		String username= u.nextLine();
		Scanner p= new Scanner(System.in);
		System.out.println("Enter Password:");
		String password= u.nextLine();
		String authcode= getBasicAuthenticationHeader(username, password);
		password= "";
		System.out.println(authcode);
		*/
		URL url = new URL("https://martin.us.lmco.com/api/authentication/martin-api/token/request");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Authorization", "Basic ZTQxMjU0NDpTUHIxbmdkMGcxITFfU1ByMW5nZDBnMSEx");
		con.setRequestProperty("Cookie", "refreshToken=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJlNDEyNTQ0Iiwic2NvcGUiOlsicmVhZCIsIiB3cml0ZSJdLCJhdGkiOiIwZmQ3M2Y5Ny0yY2Y1LTQ1ODMtODQ0ZS03NGIwODQ4ZWY3YmUiLCJleHAiOjE2NjE4Nzg1ODksImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJqdGkiOiI4ZjQ3ZGI2OC01ZmUxLTRjODEtOWFjZi05YjMyNTFhNGE3YWUiLCJjbGllbnRfaWQiOiJtYXJ0aW4td2ViIn0.B7tZWHGeirjWAHabP4tiq0LSCWQpy9tVqtFl_d1SoCnqn5vU3_aN62kz5bBkUiUNx6yqixRg3Nrg6eHk30PeZ0Lmph5PyupPQRjnTRzDemHeGfK1_xaoitth4Bi992oe5EUKiokzd6e3JR95pFLA9U1_XFHuVFOERDxv2upK0KnfkLzsb6vb5C5bQgDhJ1ge6rULNdOzBZvgFibH08_ppiQFYHUzyE9KafPHzfSc6iX96dJww43rXMn-h_Ut_XzLwzt2EDGHpG_U71NLJUEQv11ZHrBj8FyX91KrJxMgAYuynkLYRNYyVITDFroLuqpTRm8iyPX8VfFhyMjPb0mkkg");
		int status = con.getResponseCode();

		BufferedReader in = new BufferedReader(
		  new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer jsonOutput = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
		    jsonOutput.append(inputLine);
		}
		in.close();
		con.disconnect();
		String json= ""+jsonOutput;
		JSONObject obj = new JSONObject(json);
		String access_token=(String) obj.get("access_token");
		String refresh_token=(String) obj.get("refresh_token");
		System.out.println("access_token="+access_token+"\nrefresh_token="+refresh_token);//matcher.group(1));
	}
	public static final String getBasicAuthenticationHeader(String username, String password) {
	    String valueToEncode = username + ":" + password;
	    return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
	}

}
