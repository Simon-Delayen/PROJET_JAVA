package model.element.motionless;

import contract.model.Permeability;
import model.element.Sprite;

public class Door extends MotionlessElement{
    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('H', "door.png");

    /**
     * Instantiates a new tile.
     */
    Door() {
        super(SPRITE, Permeability.PENETRABLE);
    }
}
