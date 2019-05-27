package model.element.motionless;

import model.element.Sprite;

public class Earth extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite(':', "earth.png");

    /**
     * Instantiates a new earth.
     */
    Earth() {
        super(SPRITE);
    }
}
