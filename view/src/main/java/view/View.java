package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.SwingUtilities;

//import contract.controller.ControllerOrder;
import contract.controller.IController;
import contract.model.IModel;
import contract.view.IView;
import contract.controller.UserOrder;
import contract.controller.IOrderPerformer;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public final class View implements IView, Runnable, KeyListener {
	
	private IOrderPerformer orderPerformer;

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
	 * @return the user order
	 */
	static UserOrder keyCodeToUserOrder(final int keyCode) {
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
		return userOrder;
	}

	
	
	@Override
    public final void keyPressed(final KeyEvent keyEvent) {
        try { 
        	//we get the keycode and send it to keycodeUserOrder to transform it into a userOrder
        	//then we send the userOrder to orderPerfrom who will stack the order in stackOrder
            this.getOrderPerformer().orderPerformer(keyCodeToUserOrder(keyEvent.getKeyCode()));
        } catch (final IOException exception) {
            exception.printStackTrace();
        }
    }
	
	@Override
    public void keyReleased(final KeyEvent keyEvent) {
        // Not used
    }
	
	@Override
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
	
	private IOrderPerformer getOrderPerformer() {
        return this.orderPerformer;
    }
	/**
	 * 
	 * @param orderPerformer
	 * 						the new order performer
	 */
	public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
        this.orderPerformer = orderPerformer;
    }
}
