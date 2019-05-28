package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ControllerTest {
	private static Model model;
	private static View view;
	private Controller controller;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		model = new Model(2);
		view = new View(model.getLevel());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		view = null;
		model = null;
	}

	@Before
	public void setUp() throws Exception {
		setController(new Controller(view, model));
	}

	@After
	public void tearDown() throws Exception {
		setController(null);
	}

	@Test
	public void testController() {
		fail("Not yet implemented");
	}

	@Test
	public void testPlay() {
		fail("Not yet implemented");
	}

	@Test
	public void testOrderPerform() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOrderPerformer() {
		fail("Not yet implemented");
	}

}
