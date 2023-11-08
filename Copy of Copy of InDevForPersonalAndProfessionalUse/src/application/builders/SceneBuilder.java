package application.builders;


public class SceneBuilder {
	//Do Every Builder.build() Here
	public static void buildScene(){
		EventHandlerBuilder.build();
		CommandPaneBuilder.build();
		ColumnSpanBuilder.build();
		InitializeAndStartUpPaneBuilder.build();
	}
}
