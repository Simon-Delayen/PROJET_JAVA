package model.element.mobile;

import contract.model.ILevel;
import contract.model.IMobile;
import contract.model.ISprite;
import contract.model.Permeability;
import model.element.Sprite;


import java.io.IOException;



public class Hero extends Mobil implements ISprite{

    /** The Constant SPRITE. */
    private static final ISprite sprite = new Sprite('@', "pause.png");

    /** The Constant spriteTurnLeft. */
    private static final ISprite spriteMoveLeft  = new Sprite('@', "gauche 1.png");

    /** The Constant spriteTurnRight. */
    private static final ISprite spriteMoveRight = new Sprite('@', "droite 1.png");

    /** The Constant spriteMoveUp. */
    private static final ISprite spriteMoveUp  = new Sprite('@', "dos.png");

    /** The Constant spriteMoveDown. */
    private static final ISprite spriteMoveDown = new Sprite('@', "descend 1.png");

    /** The Constant spriteDie. */
    private static final ISprite spriteDie  = new Sprite('@', "tomber.png");

    /** Delay to change the hero picture less rapidly than the thread is executed */
    private int delay = 1;

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
    public Hero(final int x, final int y, final ILevel level) throws IOException {
        super(x, y, sprite, level, Permeability.BLOCKING);
        sprite.loadImage();
        spriteMoveLeft.loadImage();
        spriteMoveRight.loadImage();
        spriteMoveUp.loadImage();
        spriteMoveDown.loadImage();
        spriteDie.loadImage();

    }

    @Override
    public void moveLeft() {
        super.moveLeft();
        this.setSprite(spriteMoveLeft);
    }

    @Override
    public void moveRight() {
        super.moveRight();
        this.setSprite(spriteMoveRight);
    }

    @Override
    public void moveUp() {
        super.moveUp();
        this.setSprite(spriteMoveUp);
    }

    @Override
    public void moveDown() {
        super.moveDown();
        this.setSprite(spriteMoveDown);
    }

    @Override
    public final void die() {
        super.die();
        this.setSprite(spriteDie);
    }


    public final void doNothing() {
        super.doNothing();
        this.setSprite(sprite);
    }

    @Override
    public void loadImage() throws IOException {
        // TODO Auto-generated method stub

    }


    public char getImageWindows() {
        // TODO Auto-generated method stub
        return 0;
    }


}
