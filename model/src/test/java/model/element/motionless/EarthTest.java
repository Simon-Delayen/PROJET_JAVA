package model.element.motionless;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EarthTest {
    private Earth earth;

    @Before
    public void setUp() throws Exception {
        earth = new Earth();
    }


    @Test
    public void testWallConstructor() {
        assertNotNull(earth);
    }

    @Test
    public void testWallCharacter() {
        assertEquals(earth.getSprite().getImageWindows(),':');
    }

    @Test
    public void testWallImage() {
        assertEquals(earth.getImage(),earth.getSprite().getImage());
    }


}