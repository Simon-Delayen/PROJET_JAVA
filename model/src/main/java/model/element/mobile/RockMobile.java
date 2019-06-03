package model.element.mobile;

import contract.model.ILevel;
import contract.model.ISprite;
import contract.model.Permeability;
import model.element.Sprite;

import java.io.IOException;

public class RockMobile extends Mobil{
    int x;
    int y;

    /** The Constant SPRITE. */
    private static final ISprite sprite = new Sprite('J', "rock.png");

    /**
     * Instantiates a new RockMobile.
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
    public RockMobile(final int x, final int y, final ILevel level) throws IOException {
        super(x, y, sprite, level, Permeability.BLOCKING);
        sprite.loadImage();
    }

    public void fall(){
        super.fall();
        this.setSprite(sprite);
    }
}
