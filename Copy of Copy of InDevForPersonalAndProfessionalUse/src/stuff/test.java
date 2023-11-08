package stuff;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


public class test {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
//		test1();
		test2();
	}
	public static void test2() throws ClassNotFoundException, SQLException, IOException {		
		final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
		Class.forName(DRIVER_CLASS);
		
		final String URL = "jdbc:mysql://forsythe.us.lmco.com/martin_test_service?verifyServerCertificate=false&useSSL=false";
		final String USER = "martin";
		final String PASSWORD = "martin";
		
		Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SHOW TABLES");

		ArrayList<byte[]> stateids = getBinaryResultSet("test_state_id","test_state", statement, rs);
		ArrayList<byte[]> resultstateids = getBinaryResultSet("test_state_id","test_result", statement, rs);
		ArrayList<byte[]> caseids = getBinaryResultSet("test_case_id","test_result", statement, rs);
		ArrayList<byte[]> resultids = getBinaryResultSet("test_result_id","test_result", statement, rs);
		ArrayList<String> statenames = getStringResultSet("name","test_state", statement, rs);
		ArrayList<String> usernames = getStringResultSet("username","test_result", statement, rs);
		ArrayList<String> scmrevisions = getStringResultSet("scm_revision","test_result", statement, rs);
	
		System.out.println("statenames"+statenames);
		System.out.println("stateids"+stateids);
		System.out.println("stateids"+resultstateids);
		System.out.println("usernames"+usernames);
		System.out.println("scmrevisions"+scmrevisions);
		System.out.println("caseids"+caseids);
		System.out.println("resultids"+resultids);
	    
		rs.close();
	    statement.close();
	    connection.close();
	}
	private static ArrayList<byte[]> getBinaryResultSet(String column, String table, Statement statement, ResultSet rs) throws SQLException{
		ArrayList<byte[]> data = new ArrayList<byte[]>();
		String query = "SELECT "+column+" FROM "+table;
		byte[] bytes;
		int i=0;
		BigInteger one;
		rs = statement.executeQuery(query);
		while(rs.next()){
			bytes = rs.getBytes(1);
			System.out.println(bytes);
			one = new BigInteger(bytes);
			System.out.println(one.toString());
			data.add(bytes);
		}
		return data;
	}
	private static ArrayList<String> getStringResultSet(String column, String table, Statement statement, ResultSet rs) throws SQLException{
		ArrayList<String> data = new ArrayList<String>();
		String query = "SELECT "+column+" FROM "+table;
		rs = statement.executeQuery(query);
		while(rs.next()){
			data.add(rs.getString(1));
		}
		return data;
	}
	
	
	public static void test1() throws IOException{
		String authorizationHash="ZTQxMjU0NDpTUHIxbmdkMGcxITFfU1ByMW5nZDBnMSEx";
		URL url = new URL("https://martin.us.lmco.com/api/authentication/martin-api/token/request");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Authorization", "Basic "+authorizationHash);
		//con.setRequestProperty("Cookie", "refreshToken=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJlNDEyNTQ0Iiwic2NvcGUiOlsicmVhZCIsIiB3cml0ZSJdLCJhdGkiOiIwZmQ3M2Y5Ny0yY2Y1LTQ1ODMtODQ0ZS03NGIwODQ4ZWY3YmUiLCJleHAiOjE2NjE4Nzg1ODksImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJqdGkiOiI4ZjQ3ZGI2OC01ZmUxLTRjODEtOWFjZi05YjMyNTFhNGE3YWUiLCJjbGllbnRfaWQiOiJtYXJ0aW4td2ViIn0.B7tZWHGeirjWAHabP4tiq0LSCWQpy9tVqtFl_d1SoCnqn5vU3_aN62kz5bBkUiUNx6yqixRg3Nrg6eHk30PeZ0Lmph5PyupPQRjnTRzDemHeGfK1_xaoitth4Bi992oe5EUKiokzd6e3JR95pFLA9U1_XFHuVFOERDxv2upK0KnfkLzsb6vb5C5bQgDhJ1ge6rULNdOzBZvgFibH08_ppiQFYHUzyE9KafPHzfSc6iX96dJww43rXMn-h_Ut_XzLwzt2EDGHpG_U71NLJUEQv11ZHrBj8FyX91KrJxMgAYuynkLYRNYyVITDFroLuqpTRm8iyPX8VfFhyMjPb0mkkg");
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
		
		json="";
		url = new URL("https://martin.us.lmco.com/api/test/v1/testcases");
		con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Authorization", "Bearer "+access_token);
		con.setRequestProperty("Cookie", "refreshToken="+refresh_token);
		status = con.getResponseCode();

		in = new BufferedReader(
		  new InputStreamReader(con.getInputStream()));
		inputLine="";
		jsonOutput = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
		    jsonOutput.append(inputLine);
		}
		in.close();
		con.disconnect();
		json= ""+jsonOutput;
		JSONArray array = new JSONArray(json);
		//System.out.print(json);
		String data="";//ID > TestResults
		ArrayList<String> resultsArray=new ArrayList<String>();
		for(int index=0;index<array.length();index++){
			obj=array.getJSONObject(index);
			data="testID="+obj.getString("id")+" > testResults="+obj.get("testResults");
			resultsArray.add(data);
		}
		System.out.println(resultsArray);
		
		json="";
		url = new URL("https://martin.us.lmco.com/api/test/v1/testsummaries");
		con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Authorization", "Bearer "+access_token);
		con.setRequestProperty("Cookie", "refreshToken="+refresh_token);
		status = con.getResponseCode();

		in = new BufferedReader(
		  new InputStreamReader(con.getInputStream()));
		inputLine="";
		jsonOutput = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
		    jsonOutput.append(inputLine);
		}
		in.close();
		con.disconnect();
		json= ""+jsonOutput;
		array = new JSONArray(json);
		//System.out.print(json);
		data="";//ID > TestResults
		ArrayList<String> summaryArray=new ArrayList<String>();
		for(int index=0;index<array.length();index++){
			obj=array.getJSONObject(index);
			data="testID="+obj.getString("id")+" > summary="+obj.get("summary");
			summaryArray.add(data);
		}
		System.out.println(summaryArray);
	}

}
