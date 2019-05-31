package model.element.motionless;

import contract.model.Permeability;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiamondTest {

    private Diamond diamond;

    /**
     * @throws java.lang.Exception it's a Exception
     */
    @Before
    public void setUp() throws Exception {
        diamond = new Diamond();
    }

    @Test
    public void testDiamondConstructor(){
        assertNotNull(diamond);
    }

    @Test
    public void testDiamondCharacter(){
        assertEquals(diamond.getSprite().getImageWindows(), 'X');
    }

    @Test
    public void testDiamondImage(){
        assertEquals(diamond.getImage(),diamond.getSprite().getImage());
    }

    @Test
    public void testDiamondPermeabilityWhenNotTaken(){
        assertEquals(diamond.getPermeability(), Permeability.OPENNING);
    }

    @Test
    public void testDiamondPermeabilityWhenAlreadyTaken(){
        diamond.setPermeability(Permeability.PENETRABLE);
        assertEquals(diamond.getPermeability(), Permeability.PENETRABLE);
    }


}