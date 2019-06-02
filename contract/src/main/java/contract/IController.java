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
	 * Play.
	 *
	 * @throws InterruptedException
	 *             the interrupted exception
	 * @throws IOException
	 * 				it's a Exception
	 */
	void play() throws InterruptedException, IOException;

	/**
	 * Gets the order performer.
	 *
	 * @return the order performer
	 */
	IOrderPerformer getOrderPerformer();
}
