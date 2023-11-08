package application.builders;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ComponentFactory {

	public static GridPane drawGridPane(String color) {
		GridPane gp=new GridPane();
		gp.setPadding(new Insets(10,10,10,10));
		gp.setVgap(50);
		gp.setHgap(5);
		gp.setAlignment(Pos.CENTER);
		gp.setStyle("-fx-background-color: "+color+";");
		return gp;
	}

	public static Text drawText(String string, int font, Color c) {
		Text t=new Text();
		t.setFill(c);
		t.setFont(new Font(font));
		t.setText(string);
		return t;
	}

	public static RadioButton drawRadioButton(String label, ToggleGroup tg) {
		RadioButton rb= new RadioButton(label);
		rb.setToggleGroup(tg);
		return rb;
	}

	public static Button drawButton(String string, Color aliceblue, String fill, int font) {
		Button b=new Button();
		b.setText(string);
		b.setTextFill(aliceblue);
		b.setFont(new Font(font));
		b.setStyle("-fx-background-color: "+fill+";");
		b.setAlignment(Pos.CENTER);
		return b;
	}

	public static ComboBox<String> drawComboBox(String type) {
		ComboBox<String> cb =new ComboBox<String>();
		switch(type){
			case"type":
				cb.getItems().addAll("Many","Choices","For","The","Case");
				break;
		}
		return cb;
	}

}
