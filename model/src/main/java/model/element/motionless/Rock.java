package model.element.motionless;

import contract.model.ISprite;
import contract.model.Permeability;
import model.element.Sprite;


import java.io.IOException;

public class Rock extends MotionlessElement implements ISprite{
    int x;
    int y;

    /** The Constant SPRITE. */
    private static final ISprite SPRITE = new Sprite('R', "rock.png");

    /**
     * Instantiates a new Rock.
     */
    Rock() {
        super(SPRITE, Permeability.BLOCKING);
    }

    //@Override
    public void loadImage() throws IOException {
        // TODO Auto-generated method stub

    }

    public char getImageWindows() {
        // TODO Auto-generated method stub
        return 0;
    }
}
