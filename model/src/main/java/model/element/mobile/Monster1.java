package model.element.mobile;

import contract.model.ILevel;
import contract.model.ISprite;
import contract.model.Permeability;
import model.element.Sprite;

import java.io.IOException;

public class Monster1 extends Mobil {
    /** The Constant SPRITE. */
    private static final ISprite sprite = new Sprite('1', "monstre 1.png");

    /** The Constant spriteDie. */
    private static final ISprite spriteDie  = new Sprite('1', "noimage.png");

    /**
     * Instantiates a new Monster1.
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
    public Monster1(final int x, final int y, final ILevel level) throws IOException {
        super(x, y, sprite, level, Permeability.DEAD);
        sprite.loadImage();
        spriteDie.loadImage();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveLeft()
     */
    @Override
    public final void moveLeft() {
        super.moveLeft();
        this.setSprite(sprite);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
     */
    @Override
    public final void moveRight() {
        super.moveRight();
        this.setSprite(sprite);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveLeft()
     */
    @Override
    public final void moveUp() {
        super.moveUp();
        this.setSprite(sprite);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
     */
    @Override
    public final void moveDown() {
        super.moveDown();
        this.setSprite(sprite);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#die()
     */
    @Override
    public final void die() {
        super.die();
        this.setSprite(spriteDie);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#doNothing()
     */
    //@Override
    public final void doNothing() {
        super.doNothing();
        this.setSprite(sprite);


    }
}
