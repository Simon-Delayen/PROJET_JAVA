package model.element.motionless;

import contract.model.Permeability;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BackTest {

    private Back  Back;

    /**
     * @throws java.lang.Exception it's a Exception
     */
    @Before
    public void setUp() throws Exception {
        Back = new Back();
    }

    /**
     * Test method for {@link model.element.motionless#BackConstructor()}.
     */
    @Test
    public void testBackConstructor(){
        assertNotNull(Back);
    }

    /**
     * Test method for {@link model.element.motionless#BackCharacter()}.
     */
    @Test
    public void testBackCharacter(){
        assertEquals(Back.getSprite().getImageWindows(), ' ');
    }

    /**
     * Test method for {@link model.element.motionless#BackImage()}.
     */
    @Test
    public void testBackImage(){
        assertEquals(Back.getImage(),Back.getSprite().getImage());
    }

    /**
     * Test method for {@link model.element.motionless#BackPermeability()}.
     */
    @Test
    public void testBackPermeability(){
        assertEquals(Back.getPermeability(), Permeability.PENETRABLE);
    }
}