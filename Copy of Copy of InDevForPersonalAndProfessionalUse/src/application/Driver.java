package application;

import application.builders.ComponentStorage;
import application.builders.SceneBuilder;
import javafx.application.*;
import javafx.stage.Stage;

public class Driver extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(final Stage primaryStage) throws Exception {
		SceneBuilder.buildScene();
		ComponentStorage.setPrimaryStage(primaryStage);
		ComponentStorage.getPrimaryStage().setTitle("Name");
		ComponentStorage.getPrimaryStage().setHeight(700);
		ComponentStorage.getPrimaryStage().setWidth(900);
		ComponentStorage.getPrimaryStage().setScene(ComponentStorage.getScene());
		ComponentStorage.getPrimaryStage().show();
	}

}
