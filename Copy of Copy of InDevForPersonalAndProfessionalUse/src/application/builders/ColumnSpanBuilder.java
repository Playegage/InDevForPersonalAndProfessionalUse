package application.builders;

import javafx.scene.layout.GridPane;

public class ColumnSpanBuilder {
	public static void build(){ 
		GridPane.setColumnSpan(ComponentStorage.chcmd, 7);
		GridPane.setColumnSpan(ComponentStorage.strupl, 7);
		GridPane.setColumnSpan(ComponentStorage.strupp, 7);
		GridPane.setColumnSpan(ComponentStorage.tfln1, 3);
		GridPane.setColumnSpan(ComponentStorage.tfln2, 3);
		GridPane.setColumnSpan(ComponentStorage.tfps, 3);
		GridPane.setColumnSpan(ComponentStorage.tfdelay, 3);
	}
}
