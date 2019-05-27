package model.element.motionless;

import contract.model.ISprite;
import model.element.Sprite;

public class Back extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite(' ', "Diamond.png");

    /**
     * Instantiates a new back.
     */
    Back() {
        super(SPRITE);
    }
}
