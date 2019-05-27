package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.SwingUtilities;

import contract.controller.ControllerOrder;
import contract.controller.IController;
import contract.model.IModel;
import contract.view.IView;
import contract.controller.UserOrder;
/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public final class View implements IView, Runnable, KeyListener {

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
	 * Key code to user order.
	 *
	 * @param keyCode
	 *          the key code
	 */
	public static void keyCodeToUserOrder(final int keyCode) {
		UserOrder userOrder;
			switch (keyCode) {
				case KeyEvent.VK_UP:
					userOrder = UserOrder.UP;
					break;
			case KeyEvent.VK_DOWN:
				userOrder = UserOrder.DOWN;
				break;
			case KeyEvent.VK_LEFT:
				userOrder = UserOrder.LEFT;
				break;
			case KeyEvent.VK_RIGHT:
				userOrder = UserOrder.RIGHT;
				break;
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
