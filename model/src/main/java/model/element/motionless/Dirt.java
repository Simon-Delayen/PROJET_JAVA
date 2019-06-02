package model.element.motionless;

import contract.model.ISprite;
import contract.model.Permeability;
import model.element.Sprite;

public class Dirt extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final ISprite SPRITE = new Sprite(':', "dirt.png");

    /**
     * Instantiates a new dirt.
     */
    Dirt() {
        super(SPRITE, Permeability.BREAKABLE);
    }
}
