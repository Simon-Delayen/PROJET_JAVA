package contract.model;

import showboard.IPawn;

import java.awt.*;
import java.io.IOException;

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
     * Fall.
     */
    void fall();

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
     * Kill the hero
     */
    void die();

    /**
     * Set hero alive
     */
    void alive();

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
    Boolean isBlocked();
    Boolean isDead();
    Boolean isOnDiamond();
    Boolean isOnOpenDoor();
    Boolean isBreakable();

    /**
     * GetPosition
     */
    @Override
    Point getPosition();
}
