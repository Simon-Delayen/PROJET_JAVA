package model.element.mobil;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.model.Permeability;
import model.element.Sprite;

public class MobilTest {
	
	private Mobil mobil;
	private Sprite sprite;
	private Permeability permeability;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.mobil = new Mobil (10, 10, sprite, permeability);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMobilSpritePermeability() {
		fail("Not yet implemented");
	}

	@Test
	public void testMobilIntIntSpritePermeability() {
		fail("Not yet implemented");
	}

	@Test
	public void testMoveUp() {
		Mobil expected = new Mobil (10, 9, sprite, permeability);
		testMoveUp();
		assertSame(expected, mobil);
	}

	@Test
	public void testMoveDown() {
		fail("Not yet implemented");
	}

	@Test
	public void testMoveLeft() {
		fail("Not yet implemented");
	}

	@Test
	public void testMoveRight() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetX() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetX() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetY() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetY() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPosition() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPosition() {
		fail("Not yet implemented");
	}

}
