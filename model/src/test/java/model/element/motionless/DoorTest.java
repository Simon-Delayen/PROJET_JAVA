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

    /**
     * Test method for {@link model.element.motionless#DoorConstructor()}.
     */
    @Test
    public void testDoorConstructor(){
        assertNotNull(door);
    }

    /**
     * Test method for {@link model.element.motionless#DoorCharacter()}.
     */
    @Test
    public void testDoorCharacter(){
        assertEquals(door.getSprite().getImageWindows(), 'H');
    }

    /**
     * Test method for {@link model.element.motionless#DoorImage()}.
     */
    @Test
    public void testDoorImage(){
        assertEquals(door.getImage(),door.getSprite().getImage());
    }

    /**
     * Test method for {@link model.element.motionless#DoorPermeabilityWhenNotTaken()}.
     */
    @Test
    public void testDoorPermeabilityWhenNotTaken(){
        assertEquals(door.getPermeability(), Permeability.DEAD);
    }

    /**
     * Test method for {@link model.element.motionless#DoorPermeabilityWhenAlreadyTaken()}.
     */
    @Test
    public void testDoorPermeabilityWhenAlreadyTaken(){
        door.setPermeability(Permeability.OPENDOOR);
        assertEquals(door.getPermeability(), Permeability.OPENDOOR);
    }



}