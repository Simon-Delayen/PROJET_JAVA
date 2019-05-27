package model.element.mobile;

import contract.model.ILevel;
import contract.model.IMobile;
import contract.model.ISprite;
import contract.model.Permeability;
import model.element.Sprite;


import java.io.IOException;



public class Hero extends Mobil implements ISprite, IMobile {

    /** The Constant SPRITE. */
    private static final Sprite sprite = new Sprite('@', "pause.png");

    /** The Constant spriteTurnLeft. */
    private static final Sprite spriteMoveLeft  = new Sprite('@', "gauche 1.png");

    /** The Constant spriteTurnRight. */
    private static final Sprite spriteMoveRight = new Sprite('@', "droite 1.png");

    /** The Constant spriteMoveUp. */
    private static final Sprite spriteMoveUp  = new Sprite('@', "dos.png");

    /** The Constant spriteMoveDown. */
    private static final Sprite spriteMoveDown = new Sprite('@', "descend 1.png");

    /** The Constant spriteDie. */
    private static final Sprite spriteDie  = new Sprite('@', "tomber.png");

    /** Counter for Hero picture state */
    private int counter = 1;

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

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#doNothing()
     */
    public final void doNothing() {
        super.doNothing();
        if(delay == 6) {
            delay=0;
            switch ( getCounter() ) { //this switch is used to change the player picture when he didn't move
                case 1:
                    this.setSprite(spriteMoveLeft); //first picture load, next time we do the while the second will be load
                    setCounter(2);
                    break;
                case 2:
                    this.setSprite(spriteMoveUp); //third picture load, next time we do the while the fourth will be load
                    setCounter(3);
                    break;
                case 3:
                    this.setSprite(spriteMoveRight); //first picture load, next time we do the while the second will be load
                    setCounter(4);
                    break;
                case 4:
                    this.setSprite(spriteMoveDown); //third picture load, next time we do the while the fourth will be load
                    setCounter(1);
                    break;
            }
        }
        else{
            delay++;
        }
    }

    @Override
    public void loadImage() throws IOException {
        // TODO Auto-generated method stub

    }


    public char getImageWindows() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }


}
