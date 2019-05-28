package model.element.motionless;

import contract.model.ISprite;
import contract.model.Permeability;
import model.element.Sprite;

public class Wall extends MotionlessElement{

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('O', "wall.png");

    /**
     * Instantiates a new wall.
     */
    Wall() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
