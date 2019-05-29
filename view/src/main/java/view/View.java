package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import contract.ControllerOrder;
import contract.IView;
import contract.controller.IOrderPerformer;
import contract.model.ILevel;
import showboard.BoardFrame;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public final class View implements IView, Runnable, KeyListener {

	/** The Constant width square number of the levels. */
	private static final int squareNumberWidth = 16;

	/** The Constant height square number of the levels. */
	private static final int squareNumberHeight = 16;

	/** The Constant squareSize to make the window bigger or smaller but keeping the proportions . */
	private static final int squareSize = 40;

	/** The Constant closeView its the window launch by the thread. */
	private Rectangle closeView;

	/** The level. */
	private ILevel level;

	/** The order performer. */
	private IOrderPerformer orderPerformer;

	BoardFrame boardFrame;

	Image Door;
	ImageIcon iDoor;

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
		boardFrame.addKeyListener(this); //the window can listen to keyboard entry

		for (int x = 0; x < squareNumberWidth; x++) { //this double for set each square to his sprite picture
			for (int y = 0; y < squareNumberHeight; y++) {
				boardFrame.addSquare(this.level.getOnTheLevelXY(x, y), x, y);
			}
		}

		if(getLevel().getMonster1instance() != false) {boardFrame.addPawn(getLevel().getMonster1());} //if instance of monster1 is not false then spawn it on level
		if(getLevel().getMonster2instance() != false) {boardFrame.addPawn(getLevel().getMonster2());} //if instance of monster2 is not false then spawn it on level

		boardFrame.addPawn(getLevel().getHero()); //this place ('spawn') the mobile element Hero over a square

		this.getLevel().getObservable().addObserver(boardFrame.getObserver()); //the view is registered to be observed by the level
		boardFrame.setVisible(true); //make the game appear in first plan
	}

	/**
	 * Function to change the picture of the door and diamond when the hero take the diamond
	 */
	public void OpenDoorUpdate() {
		try {
			//getLevel().getDoor().getImage().getGraphics().drawImage(ImageIO.read(new File("C:\\Users\\KAWAK\\Documents\\GitHub\\PROJET_JAVA\\model\\src\\main\\resources\\door_open.png")),0,0, null);
			getLevel().getDoor().getImage().getGraphics().drawImage(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("door_open.png")),0,0, null); //this update the picture of the door from close to open
			if (getLevel().getDiamond() != null) //if the level get a crystal then we set it to black, else we didn't do anything
				getLevel().getDiamond().getImage().getGraphics().drawImage(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("Background.jpg")),0,0, null);//this update the picture of the diamond to black
				//getLevel().getDoor().getImage().getGraphics().drawImage(ImageIO.read(new File("C:\\Users\\KAWAK\\Documents\\GitHub\\PROJET_JAVA\\model\\src\\main\\resources\\Background.jpg")),0,0, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void EarthUpdate() {
		try {
			if (getLevel().getEarth() != null) //if the level get a earth then we set it to black, else we didn't do anything
				getLevel().getEarth().getImage().getGraphics().drawImage(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("Background.jpg")),0,0, null);//this update the picture of the earth to background
				//getLevel().getDoor().getImage().getGraphics().drawImage(ImageIO.read(new File("C:\\Users\\KAWAK\\Documents\\GitHub\\PROJET_JAVA\\model\\src\\main\\resources\\Background.jpg")),0,0, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Key code to user order.
	 * It choose the right user order in function of the keycode
	 *
	 * @param keyCode
	 *            the key code
	 * @return the user order
	 */
	static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		ControllerOrder controllerOrder;

		switch (keyCode) {
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_D:
				controllerOrder = ControllerOrder.RIGHT;
				break;
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_Q:
				controllerOrder = ControllerOrder.LEFT;
				break;
			case KeyEvent.VK_UP:
			case KeyEvent.VK_Z:
				controllerOrder = ControllerOrder.UP;
				break;
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_S:
				controllerOrder = ControllerOrder.DOWN;
				break;
			default:
				controllerOrder = ControllerOrder.NOP;
				break;
		}
		return controllerOrder;
	}

	/**
	 * Not used
	 */
	public void keyTyped(final KeyEvent keyEvent) {
		// Not used
	}

	/**
	 * Catch the user keyPressed, convert it and send it to the controller
	 */
	public final void keyPressed(final KeyEvent keyEvent) {
		try {
			//we get the keycode and send it to keycodeControllerOrder to transform it into a ControllerOrder
			//then we send the controllerOrder to orderPerform who will stack the order in stackOrder
			this.getOrderPerformer().orderPerform(keyCodeToControllerOrder(keyEvent.getKeyCode()));
		} catch (final IOException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Not used
	 */
	public void keyReleased(final KeyEvent keyEvent) {
		// Not used
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
