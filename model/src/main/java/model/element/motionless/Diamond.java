package model.element.motionless;

import contract.model.ISprite;
import contract.model.Permeability;
import model.element.Sprite;

public class Diamond extends MotionlessElement{

    /** The Constant SPRITE. */
    private static final ISprite SPRITE = new Sprite('D', "diamond.png");

    /**
     * Instantiates a new diamond.
     */
    Diamond() {
        super(SPRITE, Permeability.OPENNING);
    }
}
