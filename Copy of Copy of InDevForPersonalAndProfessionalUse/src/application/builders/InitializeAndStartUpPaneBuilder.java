package application.builders;

public class InitializeAndStartUpPaneBuilder {
	public static void build(){
		
		//////////////////Initialize Pane///////////////////////
		
		ComponentStorage.gpinitial.add(ComponentStorage.strupp, 3, 0);
		ComponentStorage.gpinitial.add(ComponentStorage.ps, 3, 2);
		ComponentStorage.gpinitial.add(ComponentStorage.tfps, 5, 2);
		ComponentStorage.gpinitial.add(ComponentStorage.psnums, 3, 3);
		ComponentStorage.gpinitial.add(ComponentStorage.pswlns, 6, 3);
		ComponentStorage.gpinitial.add(ComponentStorage.back1, 2, 4);
		ComponentStorage.gpinitial.add(ComponentStorage.exit1, 8, 4);
		ComponentStorage.gpinitial.add(ComponentStorage.submit1, 9, 4);
        
		//////////////////StartUp Pane///////////////////////

		ComponentStorage.gpstart.add(ComponentStorage.strupl, 2, 0);
		ComponentStorage.gpstart.add(ComponentStorage.ln1, 2, 1);
		ComponentStorage.gpstart.add(ComponentStorage.tfln1, 3, 1);
		ComponentStorage.gpstart.add(ComponentStorage.ln2, 2, 2);
		ComponentStorage.gpstart.add(ComponentStorage.tfln2, 3, 2);
		ComponentStorage.gpstart.add(ComponentStorage.unameq, 2, 3);
		ComponentStorage.gpstart.add(ComponentStorage.unamen, 3, 3);
		ComponentStorage.gpstart.add(ComponentStorage.unamey, 4, 3);
		ComponentStorage.gpstart.add(ComponentStorage.delay, 2, 4);
		ComponentStorage.gpstart.add(ComponentStorage.tfdelay, 3, 4);
		ComponentStorage.gpstart.add(ComponentStorage.back2, 2, 5);
		ComponentStorage.gpstart.add(ComponentStorage.exit2, 8, 5);
		ComponentStorage.gpstart.add(ComponentStorage.submit2, 9, 5);
		ComponentStorage.tfdelay.setText(".5");
		ComponentStorage.unamey.setSelected(true);
	}
}
