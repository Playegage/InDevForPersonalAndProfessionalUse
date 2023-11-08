package application.builders;

import stuff.InputMover;
import application.backend.DriverBackEnd;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ComponentStorage {
	static String pane="command";
	static String prevpane="command";
	static int fontScale = 2;
	static int buttonFont = 12*fontScale;
	static int bodyFont = 25*fontScale;
	static int titleFont = 45*fontScale;
	
	final static InputMover im=new InputMover(); 
	final static GridPane gpcommand=ComponentFactory.drawGridPane("BEIGE");
	final static GridPane gpinitial=ComponentFactory.drawGridPane("BEIGE");
	final static GridPane gpstart=ComponentFactory.drawGridPane("BEIGE");
	final static Text chcmd=ComponentFactory.drawText("Choose A Command",titleFont,Color.BLACK);
	final static Text ps=ComponentFactory.drawText("Password",bodyFont,Color.BLACK);
	final static Text pswlns=ComponentFactory.drawText("",bodyFont,Color.BLACK);
	final static Text ln1=ComponentFactory.drawText("Number 1",bodyFont,Color.BLACK);
	final static Text ln2=ComponentFactory.drawText("Number 2",bodyFont,Color.BLACK);
	final static Text delay=ComponentFactory.drawText("Choose A Delay(s)\nBefore Typing",bodyFont,Color.BLACK);
	final static Text strupp=ComponentFactory.drawText("Enter Password",titleFont,Color.BLACK);
	final static Text strupl=ComponentFactory.drawText("Enter Line Numbers",titleFont,Color.BLACK);
	final static Text unameq=ComponentFactory.drawText("Enter Username?",bodyFont,Color.BLACK);
	final static Text psnums=ComponentFactory.drawText("Numbers Will Appear Here",bodyFont,Color.BLACK);
	final static ToggleGroup useuname=new ToggleGroup();
	final static RadioButton unamey=ComponentFactory.drawRadioButton("Yes",useuname);
	final static RadioButton unamen=ComponentFactory.drawRadioButton("No",useuname);
	final static TextField tfln1=new TextField();
	final static TextField tfln2=new TextField();
	final static TextField tfdelay=new TextField();
	final static PasswordField tfps=new PasswordField();
	final static Button b=ComponentFactory.drawButton("example",Color.ALICEBLUE,"black",buttonFont);
	final static Button initial=ComponentFactory.drawButton("Initialize",Color.ALICEBLUE,"black",buttonFont);
	final static Button start=ComponentFactory.drawButton("Sign-In",Color.ALICEBLUE,"black",buttonFont);
	final static Button exit1=ComponentFactory.drawButton("Exit",Color.ALICEBLUE,"black",buttonFont);
	final static Button exit2=ComponentFactory.drawButton("Exit",Color.ALICEBLUE,"black",buttonFont);
	final static Button submit1=ComponentFactory.drawButton("Submit",Color.ALICEBLUE,"black",buttonFont);
	final static Button submit2=ComponentFactory.drawButton("Submit",Color.ALICEBLUE,"black",buttonFont);
	final static Button back1=ComponentFactory.drawButton("Back",Color.ALICEBLUE,"black",buttonFont);
	final static Button back2=ComponentFactory.drawButton("Back",Color.ALICEBLUE,"black",buttonFont);
	final static ComboBox<String> cb=ComponentFactory.drawComboBox("type");
	
	private static Scene scene = new Scene(gpcommand);
	private static Stage primaryStage=new Stage();
	
	static DriverBackEnd dbs; 
	
	public static Scene getScene() {
		return scene;
	}
	public static void setScene(Scene scene) {
		ComponentStorage.scene = scene;
	}
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	public static void setPrimaryStage(Stage primaryStage) {
		ComponentStorage.primaryStage = primaryStage;
	}
}
