package model.element.motionless;

import contract.model.ISprite;
import model.element.Sprite;

public class Back extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite(' ', "Background.jpg");

    /**
     * Instantiates a new tile.
     */
    Back() {
        super(SPRITE);
    }
}
