package contract;

import contract.controller.IOrderPerformer;

import java.io.IOException;

/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 */
public interface IController {

	/**
	 * Control.
	 */
	public void control();

	/**
	 * Play.
	 *
	 * @throws InterruptedException
	 *             the interrupted exception
	 * @throws IOException
	 */
	void play() throws InterruptedException, IOException;

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	public void orderPerform(ControllerOrder controllerOrder);

	/**
	 * Gets the order peformer.
	 *
	 * @return the order peformer
	 */
	IOrderPerformer getOrderPeformer();
}
