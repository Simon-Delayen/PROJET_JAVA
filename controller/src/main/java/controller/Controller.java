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

	/** The monster of type 1. */
	private IMobile monster1;

	/** The monster of type 2. */
	private IMobile monster2;

	/** The Monsters speed counter */
	private int monsterDelay = 1;

	/** The Monster speed */
	private int monsterSpeed = 16;

	/** Store the lastHeroOrder */
	private ControllerOrder lastHeroOrder;

	/** The hero. */
	private IMobile hero;

	/** The Earth. */
	private IElement dirt;

	/** The rock. */
	private IElement rock;

	/** The diamond. */
	private IElement diamond;

	/** The gate. */
	private IElement door;


	/** The boolean to stop game if hero finish the level */
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


		//Store the earth, door and diamond in the controller
		dirt = getModel().getLevel().getDirt();
		door = getModel().getLevel().getDoor();
		diamond = getModel().getLevel().getDiamond();
		rock = getModel().getLevel().getRock();

		//if a monster 1,2,3,4 from level exist then we stored it in monster 1,2,3,4
		if(getModel().getLevel().getMonster1instance() != false) {
			monster1 = getModel().getLevel().getMonster1();
			monster1.alive();
			monster1.doNothing();
		}
		if(getModel().getLevel().getMonster2instance() != false) {
			monster2 = getModel().getLevel().getMonster2();
			monster2.alive();
			monster2.doNothing();
		}

		//if the level didn't get a diamond then we open the door on level start
		if(getModel().getLevel().getDiamond() == null) {
			getModel().getLevel().getDoor().setPermeability(Permeability.OPENDOOR);
			getView().OpenDoorUpdate();
		}

		//if the level didn't get a diamond then we open the door on level start
		if(getModel().getLevel().getDiamond() == null) {
			getModel().getLevel().getDoor().setPermeability(Permeability.OPENDOOR);
			getView().OpenDoorUpdate();
		}

		while (hero.isAlive() && win == false) {

			Thread.sleep(speed); //make the thread sleep for a little time (in milliseconds)

			//if player is on the diamond the we open the door
			if(hero.isOnDiamond()) {
				//update the gate permeability from DEAD to OPENDOOR
				door.setPermeability(Permeability.OPENDOOR);
				diamond.setPermeability(Permeability.PENETRABLE);
				getView().OpenDoorUpdate();

			}

			//if the hero is on the gate when it's open then we stop the game and say you win
			if(hero.isOnOpenDoor()) win = true;

			//if the hero is on something that kill him then we stop the game and say you loose
			if(hero.isDead()) hero.die();

			//if hero is on the earth
			if(hero.isBreakable()) {
				//update the earth permeability
				dirt.setPermeability(Permeability.BREAKABLE);
				getView().DirtUpdate();
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

			if(monster1!=null && monster1.isAlive()) MonsterIA(monster1);
			if(monster2!=null && monster2.isAlive()) MonsterIA(monster2);

			this.clearStackOrder(); // this reset the controller order to NOP so it will not continue to move

		}

		if (win != true) {
			hero.die();

			this.getView().printMessage("Looser"); //when the main loop is break this display the message you loose on a popup
		}
		else {
			this.getView().printMessage("You win");
		}
	}

	/**
	 * This function is a kind of IA for monster to go on Lorann
	 */
	private void MonsterIA(IMobile monster) {
		//if the counter of delay match the monster wanted speed then we enter this if to move monster to the hero
		if(monsterDelay == monsterSpeed) {
			monsterDelay=0;
			//if(monster != null) {
			//move the monster to the hero
			if(hero.getX() > monster.getX()) {
				monster.moveRight();
			}
			if(hero.getX() < monster.getX()) {
				monster.moveLeft();
			}
			if(hero.getY() < monster.getY()) {
				monster.moveUp();
			}
			if(hero.getY() > monster.getY()) {
				monster.moveDown();
			}
			//}
		}
		//if the counter doesn't match speed then we increment the counter
		else monsterDelay++;

		//go to the function that check if hero is on a monster so he has to be killed
		MobKillChecker(monster);
	}

	public void MobKillChecker(IMobile monster) {
		if(hero.getX()==monster.getX() && hero.getY()==monster.getY()) {hero.die();}
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
