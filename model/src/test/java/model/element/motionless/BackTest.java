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

    @Test
    public void testBackConstructor(){
        assertNotNull(Back);
    }

    @Test
    public void testBackCharacter(){
        assertEquals(Back.getSprite().getImageWindows(), ' ');
    }

    @Test
    public void testBackImage(){
        assertEquals(Back.getImage(),Back.getSprite().getImage());
    }

    @Test
    public void testBackPermeability(){
        assertEquals(Back.getPermeability(), Permeability.PENETRABLE);
    }
}