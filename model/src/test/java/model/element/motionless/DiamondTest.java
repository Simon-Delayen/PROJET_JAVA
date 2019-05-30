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

    /**
     * Test method for {@link model.element.motionless#DiamondConstructor()}.
     */
    @Test
    public void testDiamondConstructor(){
        assertNotNull(diamond);
    }

    /**
     * Test method for {@link model.element.motionless#DiamondCharacter()}.
     */
    @Test
    public void testDiamondCharacter(){
        assertEquals(diamond.getSprite().getImageWindows(), 'X');
    }

    /**
     * Test method for {@link model.element.motionless#DiamondImage()}.
     */
    @Test
    public void testDiamondImage(){
        assertEquals(diamond.getImage(),diamond.getSprite().getImage());
    }

    /**
     * Test method for {@link model.element.motionless#DiamondPermeabilityWhenNotTaken()}.
     */
    @Test
    public void testDiamondPermeabilityWhenNotTaken(){
        assertEquals(diamond.getPermeability(), Permeability.OPENNING);
    }

    /**
     * Test method for {@link model.element.motionless#DiamondPermeabilityWhenAlreadyTaken()}.
     */
    @Test
    public void testDiamondPermeabilityWhenAlreadyTaken(){
        diamond.setPermeability(Permeability.PENETRABLE);
        assertEquals(diamond.getPermeability(), Permeability.PENETRABLE);
    }


}