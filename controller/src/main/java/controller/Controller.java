package controller;

import java.io.IOException;

/*import contract.controller.ControllerOrder;*/
import contract.controller.*;
import contract.model.IModel;
import contract.model.IModelFacade;
import contract.view.IView;
import contract.model.IMobile;

/**
 * The Class Controller.
 */
public final class Controller implements IController, IOrderPerformer {

	public static final int speed = 16;
	private UserOrder stackOrder;
	private IView view;

	/** The model. */
	//private IModelFacade model;

	private IMobile Hero;
	private UserOrder lastHeroOrder;
	
	
	/**
	 * 
	 * @param view
	 * 			  the view
	 * @param model
	 * 			  the model
	 */
	public void ControllerFacade(final IView view, final IModelFacade model) {
		this.setView(view);
		this.setModel(model);
		this.clearStackOrder();
	}
	
	/*public void ControllerFacade(IView view, IModelFacade model) {
		
	}*/
	
	public void orderPerform(UserOrder userOrder) throws IOException {
		this.setStackOrder(userOrder);
		}
	
	private IView getView() {
		
	}
	
	private void setView(IView view) {
		
	}
	
	private IModelFacade getModel() {
		
	}
	
	private void setModel (IModelFacade model) {
		
	}
	
	private UserOrder getStackOrder() {
		return this.stackOrder;
	}
	
	public boolean CheckCollision(String direction) {
		return false;
		
	}
			
	public void setStackOrder(final UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}
	
	private void clearStackOrder() {
		/*this.stackOrder = UserOrder.NOP;*/
	}
	
	public void play() throws InterruptedException, IOException{
		switch (this.getStackOrder()) {
		case UP:
			this.Hero.moveUp();
			lastHeroOrder = UserOrder.UP;
			break;
		case RIGHT:
			this.Hero.moveRight();
			lastHeroOrder = UserOrder.RIGHT;
			break;
		case DOWN:
			this.Hero.moveDown();
			lastHeroOrder = UserOrder.DOWN;
			break;
		case LEFT:
			this.Hero.moveLeft();
			lastHeroOrder = UserOrder.LEFT;
			break;
		 /*case NOP:
         default:
         	this.Hero.doNothing();
         	break;*/
		}
	}

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
	}

	/**
     * Control.
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	/*public void control() {
		this.view.printMessage("Appuyer sur les touches 'E', 'F', 'D' ou 'I', pour afficher Hello world dans la langue d votre choix.");
	}*/

	/**
     * Sets the view.
     *
     * @param pview
     *            the new view
     */
	/*private void setView(final IView pview) {
		this.view = pview;
	}*/

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	@Override
	public IOrderPerformer getOrderPerformer() {
		// TODO Auto-generated method stub
		return null;
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
	/*public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case English:
				this.model.loadHelloWorld("GB");
				break;
			case Francais:
				this.model.loadHelloWorld("FR");
				break;
			case Deutsch:
				this.model.loadHelloWorld("DE");
				break;
			case Indonesia:
				this.model.loadHelloWorld("ID");
				break;
			default:
				break;
		}*/
		
}
