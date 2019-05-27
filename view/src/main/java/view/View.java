package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.*;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import contract.controller.IOrderPerformer;
import contract.model.ILevel;
import fr.exia.showboard.BoardFrame;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public final class View implements IView, Runnable {

	/** The frame. */
//	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
//	public View(final ILevel level) throws IOException {
//		this.viewFrame = new ViewFrame(level);
//		SwingUtilities.invokeLater(this);
//	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
//	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
//		switch (keyCode) {
//			case KeyEvent.VK_G:
//				return ControllerOrder.English;
//			case KeyEvent.VK_F:
//				return ControllerOrder.Francais;
//			case KeyEvent.VK_D:
//				return ControllerOrder.Deutsch;
//			case KeyEvent.VK_I:
//				return ControllerOrder.Indonesia;
//			default:
//				return ControllerOrder.English;
//		}
//	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
//	public void printMessage(final String message) {
//		this.viewFrame.printMessage(message);
//	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
//	public void run() {
//		this.viewFrame.setVisible(true);
//	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
//	public void setController(final IController controller) {
//		this.viewFrame.setController(controller);
//	}


	/** The Constant width square number of the levels. */
	private static final int squareNumberWidth = 16;

	/** The Constant height square number of the levels. */
	private static final int squareNumberHeight = 16;

	/** The Constant squareSize to make the window bigger or smaller but keeping the proportions . */
	private static final int squareSize = 50;

	/** The Constant closeView its the window launch by the thread. */
	private Rectangle closeView;

	/** The level. */
	private ILevel           level;

	/** The order performer. */
	private IOrderPerformer orderPerformer;

	BoardFrame boardFrame;

	/**
	 * Instantiates a new View.
	 * It will create the window, a frame and a kind of plate with square to place element of the level
	 * All of this his load and shown by the thread
	 *
	 * @param level
	 *            the level
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public View(final ILevel level) throws IOException {
		this.setLevel(level); //create in memory the level (x,y,picture)
		//this defines a Rectangle in the closing view that begins at the coordinates 0,0 and whose width and height are those of the level (square unity)
		this.setCloseView(new Rectangle(0, 0, squareNumberWidth, squareNumberHeight));
		//this launch the thread it launch the method run(), apart the all game

		SwingUtilities.invokeLater(this);
	}

	/**
	 * Display a message in a popup
	 */
	@Override
	public final void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	/**
	 * Thread that run the window
	 */
	public final void run() { //this create a new BoardFrame its simply a panel in the window named Boulderdash
		boardFrame = new BoardFrame("Boulderdash");
		boardFrame.setDimension(new Dimension(squareNumberWidth, squareNumberHeight)); // set the dimension of the panel to the level (square unity)
		boardFrame.setDisplayFrame(this.getCloseView()); //say what to display in the frame
		boardFrame.setSize(squareNumberWidth * squareSize, squareNumberHeight * squareSize); //set the size of there frame (pixel unity)

		for (int x = 0; x < squareNumberWidth; x++) { //this double for set each square to his sprite picture
			for (int y = 0; y < squareNumberHeight; y++) {
				boardFrame.addSquare(this.level.getOnTheLevelXY(x, y), x, y);
			}
		}

		this.getLevel().getObservable().addObserver(boardFrame.getObserver()); //the view is registered to be observed by the level
		boardFrame.setVisible(true); //make the game appear in first plan
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	private ILevel getLevel() {
		return this.level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level
	 *            the new level
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void setLevel(final ILevel level) throws IOException {
		this.level = level;
		for (int x = 0; x < View.squareNumberWidth; x++) { //this double for made the level
			for (int y = 0; y < View.squareNumberHeight; y++) {
				this.getLevel().getOnTheLevelXY(x, y).getSprite().loadImage(); //it place in memory the picture corresponding to a postion X Y
			}
		}
	}

	/**
	 * Gets the close view.
	 *
	 * @return the close view
	 */
	private Rectangle getCloseView() {
		return this.closeView;
	}

	/**
	 * Sets the close view.
	 *
	 * @param closeView
	 *            the new close view
	 */
	private void setCloseView(final Rectangle closeView) {
		this.closeView = closeView;
	}

	/**
	 * Gets the order performer.
	 *
	 * @return the order performer
	 */
	private IOrderPerformer getOrderPerformer() {
		return this.orderPerformer;
	}

	/**
	 * Sets the order performer.
	 *
	 * @param orderPerformer
	 *            the new order performer
	 */
	public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}

}
