package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class Controller.
 */
public final class Controller implements IController {

	/*public static int speed = 16;*/
	private UserOrder stackOrder;
	
	private UserOrder getStackOrder() {
		return this.stackOrder;}
	@Override
	public void orderPerform(UserOrder userOrder) throws IOExecption{
		this.setStackOrder(userOrder);}
		
	public void setStackOrder(final UserOrder stackOrder) {
		this.stackOrder = stackOrder;}
	
	/*switch (this.getStackOrder()) { //this case execute the method associated to the user order (move, shot, nothing)
    case RIGHT:
        this.heros.moveRight();
        lastHerosOrder=UserOrder.RIGHT;
        break;
    case LEFT:
        this.heros.moveLeft();
        lastHerosOrder=UserOrder.LEFT;
        break;
    case UP:
        this.heros.moveUp();
        lastHerosOrder=UserOrder.UP;
        break;
    case DOWN:
        this.heros.moveDown();
        lastHerosOrder=UserOrder.DOWN;
        break;
    case NOP:
    	default:
    	this.heros.doNothing();
    	break;
}*/
    
	
	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

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
	public void control() {
		this.view.printMessage("Appuyer sur les touches 'E', 'F', 'D' ou 'I', pour afficher Hello world dans la langue d votre choix.");
	}

	/**
     * Sets the view.
     *
     * @param pview
     *            the new view
     */
	private void setView(final IView pview) {
		this.view = pview;
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
	
	/*public void keyPressed(KeyEvent e) {
	int keyCode = e.getKeyCode();
		
	switch (keyCode)
	{
	case KeyEvent.VK_UP:
		break;
		
	case KeyEvent.VK_DOWN:
		break;
		
	case KeyEvent.VK_LEFT:
		break;
		
	case KeyEvent.VK_RIGHT:
		break;
		
		default:
		}
	}*/
		
	}

}
