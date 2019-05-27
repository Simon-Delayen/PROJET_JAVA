package model.element.motionless;

import model.element.Sprite;

public class Door extends MotionlessElement{
    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite(' ', "door.png");

    /**
     * Instantiates a new tile.
     */
    Door() {
        super(SPRITE);
    }
}
