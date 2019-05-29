package model.element.motionless;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DirtTest {
    private Dirt dirt;

    @Before
    public void setUp() throws Exception {
        dirt = new Dirt();
    }


    @Test
    public void testWallConstructor() {
        assertNotNull(dirt);
    }

    @Test
    public void testWallCharacter() {
        assertEquals(dirt.getSprite().getImageWindows(),':');
    }

    @Test
    public void testWallImage() {
        assertEquals(dirt.getImage(),dirt.getSprite().getImage());
    }


}