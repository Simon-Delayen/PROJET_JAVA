package model.element.motionless;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoorTest {
    private Door door;

    @Before
    public void setUp() throws Exception {
        door = new Door();
    }


    @Test
    public void testWallConstructor() {
        assertNotNull(door);
    }

    @Test
    public void testWallCharacter() {
        assertEquals(door.getSprite().getImageWindows(),'H');
    }

    @Test
    public void testWallImage() {
        assertEquals(door.getImage(),door.getSprite().getImage());
    }


}