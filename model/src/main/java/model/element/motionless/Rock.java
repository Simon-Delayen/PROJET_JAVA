package model.element.motionless;

import contract.model.ISprite;
import contract.model.Permeability;
import model.element.Sprite;

public class Rock extends MotionlessElement{


    /** The Constant SPRITE. */
    private static final ISprite sprite = new Sprite('R', "rock.png");

    /**
     * Instantiates a new Rock.
     */
    Rock() {
        super(sprite, Permeability.BLOCKING);
    }

}

