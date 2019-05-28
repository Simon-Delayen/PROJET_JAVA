package model.element.motionless;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MotionlessFactoryTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testFactoryAlwaysReturnSomething() {
        assertNotNull(MotionlessFactory.getFromFileSymbol('O'));
    }

    @Test
    public void testFactoryReturnBackForNotKnownSprite() {
        //the sprite for back is space ' '
        assertEquals(MotionlessFactory.getFromFileSymbol('~'),MotionlessFactory.getFromFileSymbol(' '));
        assertEquals(MotionlessFactory.getFromFileSymbol('A'),MotionlessFactory.getFromFileSymbol(' '));
        assertEquals(MotionlessFactory.getFromFileSymbol('.'),MotionlessFactory.getFromFileSymbol(' '));
        assertEquals(MotionlessFactory.getFromFileSymbol('à'),MotionlessFactory.getFromFileSymbol(' '));
    }

}