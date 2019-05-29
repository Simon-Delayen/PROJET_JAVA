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

	/** Store the lastHeroOrder */
	private ControllerOrder lastHeroOrder;

	/** The hero. */
	private IMobile hero;

	/** The Earth. */
	private IElement earth;

	/** The rock. */
	private IMobile rock;

	/** The diamond. */
	private IElement diamond;

	/** The gate. */
	private IElement door;


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
		rock = (IMobile) getModel().getLevel().getRock();


		//Store the earth, door and diamond in the controller
		earth = getModel().getLevel().getEarth();
		door = getModel().getLevel().getDoor();
		diamond = getModel().getLevel().getDiamond();

		//if the level didn't get a diamond then we open the door on level start
		if(getModel().getLevel().getDiamond() == null) {
			getModel().getLevel().getDoor().setPermeability(Permeability.OPENDOOR);
			getView().OpenDoorUpdate();
		}

		while (hero.isAlive() && win == false) {

			Thread.sleep(speed); //make the thread sleep for a little time (in milliseconds)

			//if player is on the diamond the we open the door
			if(hero.isOnDiamond()) {
				//update the gate permeability from KILLING to OPENDOOR
				door.setPermeability(Permeability.OPENDOOR);
				diamond.setPermeability(Permeability.PENETRABLE);
				getView().OpenDoorUpdate();
			}

			//if the hero is on the gate when it's open then we stop the game and say you win
			if(hero.isOnOpenDoor()) win = true;

			//if player is on the earth
			if(hero.isOnEarth()) {
				//update the earth permeability
				earth.setPermeability(Permeability.KICK);
				getView().EarthUpdate();
			}

			//if the level didn't get a crystal then we open the gate on level start
			if(getModel().getLevel().getDiamond() == null) {
				getModel().getLevel().getDoor().setPermeability(Permeability.OPENDOOR);
				getView().OpenDoorUpdate();
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
		if (win != true) {
			hero.die();

			this.getView().printMessage("You loose"); //when the main loop is break this display the message you loose on a popup
		}
		else {
			this.getView().printMessage("You win");
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
