package model.element.motionless;

import contract.model.ISprite;
import contract.model.Permeability;
import model.element.Sprite;
import contract.model.ISprite;

public class Door extends MotionlessElement{
    /** The Constant SPRITE. */
    private static final ISprite SPRITE = new Sprite('H', "door.png");

    /**
     * Instantiates a new tile.
     */
    Door() {
        super(SPRITE, Permeability.PENETRABLE);
    }
}
