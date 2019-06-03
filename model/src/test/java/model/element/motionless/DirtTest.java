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

    @Test
    public void testDirtConstructor(){
        //assertNotNull(Dirt);
    }

    @Test
    public void testDirtCharacter(){
        //assertEquals(Dirt.getSprite().getImageWindows(), ':');
    }

    @Test
    public void testDirtImage(){
        //assertEquals(Dirt.getImage(),Dirt.getSprite().getImage());
    }

    @Test
    public void testDirtPermeability(){
        //assertEquals(Dirt.getPermeability(), Permeability.BREAKABLE);
    }

}