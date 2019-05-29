package contract.model;

import showboard.IPawn;

import java.awt.*;

public interface IMobile extends IPawn, IElement{
    /**
     * Move up.
     */
    void moveUp();

    /**
     * Move left.
     */
    void moveLeft();

    /**
     * Move down.
     */
    void moveDown();

    /**
     * Move right.
     */
    void moveRight();

    /**
     * No move.
     */
    void doNothing();

    /**
     * Checks if is alive.
     *
     * @return the alive
     */
    Boolean isAlive();

    /**
     * Kill the player
     */
    void die();

    /**
     * Set player alive
     */
    void alive();

    /**
     * Set player alive
     */
    //void fall();

    @Override
    int getX();

    /**
     * Gets the y.
     *
     * @return the y
     */
    @Override
    int getY();

    /**
     * Checks if something happened.
     *
     * @return the boolean
     */
    Boolean isOnEarth();
    Boolean isOnDiamond();
    Boolean isOnOpenDoor();

    /**
     * GetPosition
     */
    @Override
    Point getPosition();
}
