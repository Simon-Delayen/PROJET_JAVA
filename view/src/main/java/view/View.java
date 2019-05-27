package view;

import java.awt.event.KeyEvent;
import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public final class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
static UserOrder keyCodeToUserOrder(final int keyCode) {
	UserOrder userOrder;
		switch (keyCode) {
			case KeyEvent.VK_UP:
				userOrder = UserOrder.UP;
				/*return ControllerOrder.English;*/
				break;
			case KeyEvent.VK_DOWN:
				userOrder = UserOrder.DOWN;
				/*return ControllerOrder.Francais;*/
				break;
			case KeyEvent.VK_LEFT:
				userOrder = UserOrder.LEFT;
				/*return ControllerOrder.Deutsch;*/
				break;
			case KeyEvent.VK_RIGHT:
				userOrder = UserOrder.RIGHT;
				/*return ControllerOrder.Indonesia;*/
				break;
			/*default:
				return ControllerOrder.English;*/
		}
	}

	
	
	public void keyRealeased(KeyEvent e) {
		
	}
	
	public void keyTyped(KeyEvent e) {}
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
