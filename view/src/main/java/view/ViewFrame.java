package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.*;

import contract.IController;
import contract.IModel;
import contract.controller.IOrderPerformer;
import contract.model.ILevel;
import fr.exia.showboard.BoardFrame;

/**
 * The Class ViewFrame.
 *
 * @author Jean-Aymeric Diet
 */
class ViewFrame extends JFrame implements KeyListener {

	/** The model. */
	private IModel						model;
	private ILevel 						level;
	private static final int squareNumberWidth = 16;
	private static final int squareNumberHeight = 14;
	private IOrderPerformer orderPerformer;

	private Rectangle        closeView;
	private static final int squareSize = 50;
	BoardFrame boardFrame;

	/** The controller. */
	private IController				controller;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -697358409737458175L;

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IModel model) throws HeadlessException {
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
		super(gc);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model);
	}

	public ViewFrame(final ILevel level) throws IOException {
		this.setLevel(level); //create in memory the level (x,y,picture)
		//this defines a Rectangle in the closing view that begins at the coordinates 0,0 and whose width and height are those of the level (square unity)
		this.setCloseView(new Rectangle(0, 0, squareNumberWidth, squareNumberHeight));
		//this launch the thread it launch the method run(), apart the all game

		SwingUtilities.invokeLater((Runnable) this);
	}

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	private IController getController() {
		return this.controller;
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	protected void setController(final IController controller) {
		this.controller = controller;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	protected IModel getModel() {
		return this.model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Builds the view frame.
	 *
	 * @param model
	 *          the model
	 */
	private void buildViewFrame(final IModel model) {
		this.setModel(model);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);
		this.setContentPane(new ViewPanel(this));
		//32 Sprites de larges et 28 de long
		this.setSize(256 + this.getInsets().left + this.getInsets().right, 224 + this.getInsets().top + this.getInsets().bottom);
		this.setLocationRelativeTo(null);
	}

	/**
	 * Prints the message.
	 *
	 * @param message
	 *          the message
	 */
	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(final KeyEvent e) {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(final KeyEvent e) {
		this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(final KeyEvent e) {

	}


	public final void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}


	public final void run() { //this create a new BoardFrame its simply a panel in the window named Lorann
		boardFrame = new BoardFrame("Boulderdash");
		boardFrame.setDimension(new Dimension(squareNumberWidth, squareNumberHeight)); // set the dimension of the panel to the level (square unity)
		boardFrame.setDisplayFrame(this.getCloseView()); //say what to display in the frame
		boardFrame.setSize(squareNumberWidth * squareSize, squareNumberHeight * squareSize); //set the size of thre frame (pixel unity)
		boardFrame.addKeyListener(this); //the window can listen to keyboard entry

		for (int x = 0; x < squareNumberWidth; x++) { //this double for set each square to his sprite picture
			for (int y = 0; y < squareNumberHeight; y++) {
				boardFrame.addSquare(this.level.getOnTheLevelXY(x, y), x, y);
			}
		}

		this.getLevel().getObservable().addObserver(boardFrame.getObserver()); //the view is registred to be observed by the level
		boardFrame.setVisible(true); //make the game appear in first plan
	}

	private ILevel getLevel() {
		return this.level;
	}

	private void setLevel(final ILevel level) throws IOException {
		this.level = level;
		for (int x = 0; x < ViewFrame.squareNumberWidth; x++) { //this double for made the level
			for (int y = 0; y < ViewFrame.squareNumberHeight; y++) {
				this.getLevel().getOnTheLevelXY(x, y).getSprite().loadImage(); //it place in memory the picture corresponding to a postion X Y
			}
		}
	}

	private Rectangle getCloseView() {
		return this.closeView;
	}

	private void setCloseView(final Rectangle closeView) {
		this.closeView = closeView;
	}

	private IOrderPerformer getOrderPerformer() {
		return this.orderPerformer;
	}

	public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}
}
