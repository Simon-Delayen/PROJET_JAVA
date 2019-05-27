package contract.controller;

import java.io.IOException;

public interface IController {

/*	
	public void control();

	public void orderPerform(ControllerOrder controllerOrder);
}
*/
	
	public void play() throws InterruptedException, IOException;

	IOrderPerformer getOrderPerformer();
}
