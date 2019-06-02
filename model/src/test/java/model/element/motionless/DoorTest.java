package model.element.motionless;

import contract.model.Permeability;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoorTest {
    private Door door;

    /**
     * @throws java.lang.Exception it's a Exception
     */
    @Before
    public void setUp() throws Exception {
        door = new Door();
    }

    @Test
    public void testDoorConstructor(){
        assertNotNull(door);
    }

    @Test
    public void testDoorCharacter(){
        assertEquals(door.getSprite().getImageWindows(), 'H');
    }

    @Test
    public void testDoorImage(){
        assertEquals(door.getImage(),door.getSprite().getImage());
    }

    @Test
    public void testDoorPermeabilityWhenNotTaken(){
        assertEquals(door.getPermeability(), Permeability.PENETRABLE);
    }

    @Test
    public void testDoorPermeabilityWhenAlreadyTaken(){
        door.setPermeability(Permeability.OPENDOOR);
        assertEquals(door.getPermeability(), Permeability.OPENDOOR);
    }



}