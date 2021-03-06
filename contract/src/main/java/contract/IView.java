package contract;

import contract.controller.IOrderPerformer;

/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {

	/**
	 * Prints the message.
	 *
	 * @param message
	 *          the message
	 */
	void printMessage(final String message);

	/**
	 * Interpreted order.
	 *
	 * @param orderPerformer
	 *          the order performer
	 */
	void setOrderPerformer(IOrderPerformer orderPerformer);

	void OpenDoorUpdate();
}
