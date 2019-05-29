package model.element.mobile;

import contract.model.ILevel;
import contract.model.ISprite;
import contract.model.Permeability;
import model.element.Sprite;

import java.io.IOException;

public class Rock extends Mobil implements ISprite{

    /** The Constant SPRITE. */
    private static final ISprite sprite = new Sprite('R', "rock.png");

    /**
     * Instantiates a new Hero.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param level
     *            the level
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public Rock(final int x, final int y, final ILevel level) throws IOException {
        super(x, y, sprite, level, Permeability.BLOCKING);
        sprite.loadImage();
    }


    @Override
    public void doNothing() {
        super.doNothing();
        this.setSprite(sprite);
    }

    //@Override
    /*public void fall() {
        super.fall();
        this.setSprite(sprite);
    }*/

    //@Override
    public void loadImage() throws IOException {
        // TODO Auto-generated method stub

    }

    public char getImageWindows() {
        // TODO Auto-generated method stub
        return 0;
    }
}
