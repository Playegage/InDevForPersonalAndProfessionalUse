package application.builders;


public class CommandPaneBuilder {
	public static void build(){
		ComponentStorage.gpcommand.add(ComponentStorage.chcmd, 0, 0);
		ComponentStorage.gpcommand.add(ComponentStorage.b, 0, 1);
		ComponentStorage.gpcommand.add(ComponentStorage.initial, 1, 1);
		ComponentStorage.gpcommand.add(ComponentStorage.start, 2, 1);
	}
}
