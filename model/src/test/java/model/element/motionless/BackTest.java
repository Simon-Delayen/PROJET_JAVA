package model.element.motionless;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BackTest {

    private Back  Back;

    @Before
    public void setUp() throws Exception {
        Back = new Back();
    }

    @Test
    public void testBackConstructor() {
        assertNotNull(Back);
    }

    @Test
    public void testBackCharacter() {
        assertEquals(Back.getSprite().getImageWindows(),' ');
    }

    @Test
    public void testBackImage() {
        assertEquals(Back.getImage(),Back.getSprite().getImage());
    }
}