package model.element.motionless;

import contract.model.Permeability;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WallTest {
    private Wall wall;

    /**
     * @throws java.lang.Exception it's a Exception
     */
    @Before
    public void setUp() throws Exception {
        wall = new Wall();
    }

    /**
     * Test method for {@link model.element.motionless#WallConstructor()}.
     */
    @Test
    public void testWallConstructor(){
        assertNotNull(wall);
    }

    /**
     * Test method for {@link model.element.motionless#WallCharacter()}.
     */
    @Test
    public void testWallCharacter(){
        assertEquals(wall.getSprite().getImageWindows(), 'O');
    }

    /**
     * Test method for {@link model.element.motionless#WallImage()}.
     */
    @Test
    public void testWallImage(){
        assertEquals(wall.getImage(),wall.getSprite().getImage());
    }

    /**
     * Test method for {@link model.element.motionless#WallPermeability()}.
     */
    @Test
    public void testWallPermeability(){
        assertEquals(wall.getPermeability(), Permeability.BLOCKING);
    }
}