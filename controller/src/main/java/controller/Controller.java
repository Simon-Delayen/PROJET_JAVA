package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import contract.controller.IOrderPerformer;
import contract.model.IElement;
import contract.model.IMobile;
import contract.model.Permeability;

import java.io.IOException;

/**
 * The Class controller.
 */
public final class Controller implements IOrderPerformer, IController {

	/** The game-thread refresh speed. */
	private static final int speed = 50;

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

	/** The stack order. */
	private ControllerOrder stackOrder;

	/** Store the lastLorannOrder */
	private ControllerOrder lastHeroOrder;

	/** The Lorann. */
	private IMobile hero;

	/** The Earth. */
	private IElement earth;


	/** The boolean to stop game if player finish the level */
	private boolean win;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
		this.clearStackOrder(); 			//set the user order to NOP so we are sure that the player do not move on spawn
	}

	/**
	 * Drive the game element movement, behavior and threading
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")

	public void play() throws InterruptedException, IOException {

		//---------------------------------------------------------------------------------------------------
		//		This part prepare the variable and element of the level depending on each level
		//---------------------------------------------------------------------------------------------------
		// when the player hero is load on the map is not alive so we set it alive after everything is load
		hero = getModel().getLevel().getHero();
		hero.alive();

		//Store the earth in the controller
		earth = getModel().getLevel().getEarth();


		while (hero.isAlive() && win == false) {

			Thread.sleep(speed); //make the thread sleep for a little time (in milliseconds)

			//if player is on the earth
			if(hero.isOnEarth()) {
				//update the earth permeability
				earth.setPermeability(Permeability.KICK);
				getView().EarthUpdate();
			}
			switch (this.getStackOrder()) { //this case execute the method associated to the user order (move, nothing)
				case RIGHT:
					this.hero.moveRight();
					lastHeroOrder = ControllerOrder.RIGHT;
					break;
				case LEFT:
					this.hero.moveLeft();
					lastHeroOrder = ControllerOrder.LEFT;
					break;
				case UP:
					this.hero.moveUp();
					lastHeroOrder = ControllerOrder.UP;
					break;
				case DOWN:
					this.hero.moveDown();
					lastHeroOrder = ControllerOrder.DOWN;
					break;
				case NOP:
				default:
					this.hero.doNothing();
					break;
			}

			this.clearStackOrder(); // this reset the controller order to NOP so it will not continue to move
		}
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
     * Order perform.
     *
     * @param controllerOrder
     *            the controller order
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) throws IOException{
			this.setStackOrder(controllerOrder);

	}

	/**
	 * Gets the stack order.
	 *
	 * @return the stack order
	 */
	private ControllerOrder getStackOrder() {
		return this.stackOrder;
	}

	/**
	 * Sets the stack order.
	 *
	 * @param stackOrder
	 *            the new stack order
	 */
	private void setStackOrder(final ControllerOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

	/**
	 * Clear stack order.
	 */
	private void clearStackOrder() {
		this.stackOrder = ControllerOrder.NOP;
	}

	/**
	 * Get the order to perform
	 */
	public IOrderPerformer getOrderPerformer() {
		return this;
	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	private IView getView() {
		return this.view;
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *            the view to set
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	private IModel getModel(){
		return this.model;
	}

}
