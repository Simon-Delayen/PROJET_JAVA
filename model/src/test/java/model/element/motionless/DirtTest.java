package model.element.motionless;

import contract.model.Permeability;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DirtTest {

   private Dirt dirt;

    /**
     * @throws java.lang.Exception it's a Exception
     */
    @Before
    public void setUp() throws Exception {
        dirt = new Dirt();
    }

    /**
     * Test method for {@link model.element.motionless#DirtConstructor()}.
     */
    @Test
    public void testDirtConstructor(){
        //assertNotNull(Dirt);
    }

    /**
     * Test method for {@link model.element.motionless#DirtCharacter()}.
     */
    @Test
    public void testDirtCharacter(){
        //assertEquals(Dirt.getSprite().getImageWindows(), ':');
    }

    /**
     * Test method for {@link model.element.motionless#DirtImage()}.
     */
    @Test
    public void testDirtImage(){
        //assertEquals(Dirt.getImage(),Dirt.getSprite().getImage());
    }

    /**
     * Test method for {@link model.element.motionless#DirtPermeability()}.
     */
    @Test
    public void testDirtPermeability(){
        //assertEquals(Dirt.getPermeability(), Permeability.BREAKABLE);
    }

}