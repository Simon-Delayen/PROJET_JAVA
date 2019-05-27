package model.element.mobile;

import contract.model.ILevel;
import contract.model.Permeability;
import fr.exia.showboard.IBoard;
import model.element.Element;
import model.element.Sprite;

import java.awt.*;

public class Mobil extends Element {

    /**
     * The x.
     */
    private Point position;

    /** The alive. */
    protected Boolean alive;

    /** The level. */
    private ILevel  level;

    /** The board. */
    private IBoard  board;

    public Mobil(Sprite sprite, Permeability permeability) {
        super(sprite, permeability);
        this.setLevel(level);
        this.position = new Point();
    }

    public Mobil(int x, int y, Sprite sprite, Permeability permeability) {
        this(sprite, permeability);
        this.setX(x);
        this.setY(y);
    }

    public void moveUp() {
        this.setY(getY() - 1);
        this.setHasMoved();
    }


    public void moveDown() {
        this.setY(getY() + 1);
        this.setHasMoved();
    }


    public void moveLeft() {
        this.setX(this.getX() - 1);
        this.setHasMoved();

    }


    public void moveRight() {
        this.setX(getX() + 1);
        this.setHasMoved();
    }

    public void doNothing() {
        this.setHasMoved();
    }

    /*
     * Sets the has moved.
     */
    protected void setHasMoved() {
        this.getLevel().setMobilHasChanged();
    }

    public int getX() {
        return this.getPosition().x;
    }

    public void setX(int x) {
        this.getPosition().x = x;
    }



    public int getY() {
        return this.getPosition().y;
    }

    public void setY(int y) {
        this.getPosition().y = y;
    }

    /**
     * Gets the level.
     *
     * @return the level
     */
    public ILevel getLevel() {
        return this.level;
    }

    /**
     * Sets the level.
     *
     * @param level
     *            the new level
     */
    private void setLevel(final ILevel level) {
        this.level = level;
    }

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(final Point position) {
        this.position = position;
    }

    /**
     * Gets the board.
     *
     * @return the board
     */
    protected IBoard getBoard() {
        return this.board;
    }

    /**
     * Return the state of mobile element
     */
    public Boolean isAlive() {
        return this.alive;
    }

    /**
     * Alive.
     */
    public void alive() {
        this.alive = true;
    }
}