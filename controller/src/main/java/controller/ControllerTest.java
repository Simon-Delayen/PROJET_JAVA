package controller;

import contract.IModel;
import contract.IView;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

public class ControllerTest {

    /** The model */
    private static IModel model;
    /** The view */
    private static IView view;
    /** The controller */
    private static Controller controller;

    /**
     * Sets the up before class.
     *
     * @throws Exception
     *          the exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
       // model = new Model(2);
       // view = new View(model.getLevel());
    }

    /**
     * Sets the up after class.
     *
     * @throws Exception
     *          the exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        view = null;
        model = null;
    }

    /**
     * Sets the up.
     *
     * @throws Exception
     *          the exception
     */
    @Before
    public void setUp() throws Exception {
        setController(new Controller(view, model));
    }

    /**
     * Tear down.
     *
     * @throws Exception
     *          the exception
     */
    @After
    public void tearDown() throws Exception {
        setController(null);
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller){
        this.controller = controller;
    }
}