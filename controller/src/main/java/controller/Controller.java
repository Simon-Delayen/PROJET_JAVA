package controller;

/*import contract.controller.ControllerOrder;*/
import contract.controller.IController;
import contract.controller.UserOrder;
import contract.model.IModel;
import contract.view.IView;


/**
 * The Class Controller.
 */
public final class Controller implements IController {

	public static final int speed = 16;
	private UserOrder stackOrder;
	/*private IModelFacade model;*/
	
	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;
	private IModelFacade model;
	private Mobil Hero;
	
	private UserOrder lastHeroOrder;
	
	
	
	public ControllerFacade(IViewFacade view, IModelFacade model) {}
	
	public void play() {}
	
	public void orderPerform(UserOrder userOrder) {}
	
	private IViewFacade getView() {}
	
	private void setView(IViewFacade view) {}
	
	private IModelFacade getModel() {}
	
	private void setModel (IModelFacade model) {}
	
	private UserOrder getStackOrder() {/*
	return this.stackOrder;*/}
	
	/*private void setStackOrder(UserOrder stackOrder) {}*/
	
	private void clear StackOtder() {}
	
	public boolean CheckCollision(String direction) {}
	
	
	@Override
	public void orderPerform(UserOrder userOrder) throws IOExecption{/*
		this.setStackOrder(userOrder);*/}
		
	public void setStackOrder(final UserOrder stackOrder) {}/*
		this.stackOrder = stackOrder;*/
	
	switch (this.getStackOrder()) { //this case execute the method associated to the user order (move, shot, nothing)
    case UP:
        this.Hero.moveUp();
        lastHeroOrder=UserOrder.UP;
        break;
    case RIGHT:
        this.Hero.moveRight();
        lastHeroOrder=UserOrder.RIGHT;
        break;
    case DOWN:
        this.Hero.moveDown();
        lastHeroOrder=UserOrder.DOWN;
        break;
    case LEFT:
        this.Hero.moveLeft();
        lastHeroOrder=UserOrder.LEFT;
        break;
	}
    /*case NOP:
    	default:
    	this.Hero.doNothing();
    	break;*/

    
	
	

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
