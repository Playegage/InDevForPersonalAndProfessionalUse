package application.builders;

import java.awt.AWTException;
import java.awt.Robot;

import application.backend.DriverBackEnd;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;

public class EventHandlerFactory {

	static EventHandler<MouseEvent> buttonEventHandler =new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			ComponentStorage.pane="start";
			ComponentStorage.getScene().setRoot(ComponentStorage.gpstart);
			System.out.println(ComponentStorage.pane);
		}
	};static EventHandler<MouseEvent> initialEventHandler =new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			ComponentStorage.pane="initial";
			ComponentStorage.getScene().setRoot(ComponentStorage.gpinitial);
			System.out.println(ComponentStorage.pane);
		}
	};static EventHandler<MouseEvent> startEventHandler =new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			ComponentStorage.pane="start";
			ComponentStorage.getScene().setRoot(ComponentStorage.gpstart);
			System.out.println(ComponentStorage.pane);
		}
	};
	static EventHandler<MouseEvent> exitEventHandler =new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			ComponentStorage.getPrimaryStage().close();
		}
	};
	static EventHandler<MouseEvent> backEventHandler =new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			switch(ComponentStorage.pane){
			case"initial":
				ComponentStorage.tfps.setText("");
				ComponentStorage.pane="command";
				ComponentStorage.getScene().setRoot(ComponentStorage.gpcommand);
				System.out.println(ComponentStorage.pane);
				break;
			case"start":
				ComponentStorage.pane="command";
				ComponentStorage.getScene().setRoot(ComponentStorage.gpcommand);
				System.out.println(ComponentStorage.pane);
				break;
			}
		}
	};
	static EventHandler<MouseEvent> submitEventHandler =new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			Robot r=null;
			try {
				r=new Robot();
			} catch (AWTException e) {
				e.printStackTrace();
			}
			switch(ComponentStorage.pane){
				case"initial":
					ComponentStorage.im.setIn0("initial");
					ComponentStorage.im.getIn()[1]=ComponentStorage.tfps.getText();
					ComponentStorage.pswlns.setText(DriverBackEnd.initialize(ComponentStorage.im.getIn()));
					ComponentStorage.im.getIn()[1]="";
					System.out.println("Line Numbers Generated");
					break;
				case"start":
					ComponentStorage.im.setIn0("start");
					ComponentStorage.im.getIn()[1]=ComponentStorage.tfln1.getText();
					ComponentStorage.im.getIn()[2]=ComponentStorage.tfln2.getText();
					RadioButton u=(RadioButton) ComponentStorage.useuname.getSelectedToggle();
					ComponentStorage.im.getIn()[3]=u.getText().toLowerCase();
					ComponentStorage.im.getIn()[4]=ComponentStorage.tfdelay.getText();
					ComponentStorage.dbs=new DriverBackEnd(ComponentStorage.im.getIn0(), ComponentStorage.im.getIn(), r);
					ComponentStorage.dbs.start();
					break;
					
			}
		}
	};
	
	public static EventHandler<MouseEvent> getButtonEventHandler() {
		return buttonEventHandler;
	}
	public static void setButtonEventHandler(
		EventHandler<MouseEvent> buttonEventHandler) {
		EventHandlerFactory.buttonEventHandler = buttonEventHandler;
	}
	public static EventHandler<MouseEvent> getInitialEventHandler() {
		return initialEventHandler;
	}
	public static void setInitialEventHandler(
			EventHandler<MouseEvent> initialEventHandler) {
		EventHandlerFactory.initialEventHandler = initialEventHandler;
	}
	public static EventHandler<MouseEvent> getStartEventHandler() {
		return startEventHandler;
	}
	public static void setStartEventHandler(
			EventHandler<MouseEvent> startEventHandler) {
		EventHandlerFactory.startEventHandler = startEventHandler;
	}
	public static EventHandler<MouseEvent> getExitEventHandler() {
		return exitEventHandler;
	}
	public static void setExitEventHandler(EventHandler<MouseEvent> exitEventHandler) {
		EventHandlerFactory.exitEventHandler = exitEventHandler;
	}
	public static EventHandler<MouseEvent> getBackEventHandler() {
		return backEventHandler;
	}
	public static void setBackEventHandler(EventHandler<MouseEvent> backEventHandler) {
		EventHandlerFactory.backEventHandler = backEventHandler;
	}
	public static EventHandler<MouseEvent> getSubmitEventHandler() {
		return submitEventHandler;
	}
	public static void setSubmitEventHandler(
			EventHandler<MouseEvent> submitEventHandler) {
		EventHandlerFactory.submitEventHandler = submitEventHandler;
	}

}
