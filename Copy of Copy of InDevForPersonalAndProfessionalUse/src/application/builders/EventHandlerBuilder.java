package application.builders;

import javafx.scene.input.MouseEvent;

public class EventHandlerBuilder {
	public static void build(){
		ComponentStorage.b.addEventHandler(MouseEvent.MOUSE_CLICKED, EventHandlerFactory.getButtonEventHandler());
		ComponentStorage.initial.addEventHandler(MouseEvent.MOUSE_CLICKED, EventHandlerFactory.getInitialEventHandler());
		ComponentStorage.start.addEventHandler(MouseEvent.MOUSE_CLICKED, EventHandlerFactory.getStartEventHandler());
		ComponentStorage.exit1.addEventHandler(MouseEvent.MOUSE_CLICKED, EventHandlerFactory.getExitEventHandler());
		ComponentStorage.exit2.addEventHandler(MouseEvent.MOUSE_CLICKED, EventHandlerFactory.getExitEventHandler());
		ComponentStorage.submit1.addEventHandler(MouseEvent.MOUSE_CLICKED, EventHandlerFactory.getSubmitEventHandler());
		ComponentStorage.submit2.addEventHandler(MouseEvent.MOUSE_CLICKED, EventHandlerFactory.getSubmitEventHandler());
		ComponentStorage.back1.addEventHandler(MouseEvent.MOUSE_CLICKED, EventHandlerFactory.getBackEventHandler());
		ComponentStorage.back2.addEventHandler(MouseEvent.MOUSE_CLICKED, EventHandlerFactory.getBackEventHandler());
	}
}
