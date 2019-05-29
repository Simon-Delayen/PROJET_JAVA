package model.element.motionless;

import contract.model.ISprite;
import contract.model.Permeability;
import model.element.Sprite;

public class Back extends MotionlessElement {

    /** The Constant SPRITE. */

    private static final ISprite SPRITE = new Sprite(' ', "Background.jpg");

    /**
     * Instantiates a new back.
     */
    Back() {
        super(SPRITE, Permeability.PENETRABLE);
    }
}
