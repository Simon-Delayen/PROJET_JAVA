package contract.model;

import fr.exia.showboard.IPawn;

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

    @Override
    int getX();

    /**
     * Gets the y.
     *
     * @return the y
     */
    @Override
    int getY();

    //Boolean isOnEarth();

    /**
     * GetPosition
     */
    @Override
    Point getPosition();
}
