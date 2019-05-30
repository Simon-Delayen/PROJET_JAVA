package model.element.motionless;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MotionlessFactoryTest {

    /**
     * @throws java.lang.Exception it's a Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Test method for {@link model.element.motionless#FactoryAlwaysReturnSomething()}.
     */
    @Test
    public void testFactoryAlwaysReturnSomething() {
        assertNotNull(MotionlessFactory.getFromFileSymbol('H'));
        assertNotNull(MotionlessFactory.getFromFileSymbol(' '));
        assertNotNull(MotionlessFactory.getFromFileSymbol('@'));
        assertNotNull(MotionlessFactory.getFromFileSymbol('1'));
        assertNotNull(MotionlessFactory.getFromFileSymbol('~'));
    }

    /**
     * Test method for {@link model.element.motionless#FactoryReturnBackForNotKnownSprite()}.
     */
    @Test
    public void testFactoryReturnBackForNotKnownSprite() {
        //the sprite for back is space ' '
        assertEquals(MotionlessFactory.getFromFileSymbol('~'),MotionlessFactory.getFromFileSymbol(' '));
        assertEquals(MotionlessFactory.getFromFileSymbol('A'),MotionlessFactory.getFromFileSymbol(' '));
        assertEquals(MotionlessFactory.getFromFileSymbol('.'),MotionlessFactory.getFromFileSymbol(' '));
        assertEquals(MotionlessFactory.getFromFileSymbol('à'),MotionlessFactory.getFromFileSymbol(' '));
    }

}