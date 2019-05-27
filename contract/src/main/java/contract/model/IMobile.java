package contract.model;

import java.awt.Point;

import fr.exia.showboard.IPawn;

public interface IMobile extends IPawn, IElement {


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
     * Move up left.
     */

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
     * Checks if somthing happened.
     *
     * @return the boolean
     */
    Boolean isCrashed();
	Boolean isKilled();
	Boolean isOnCrystall();
	Boolean isOnOpenGate();

	/**
	 * GetPosition
	 */
    @Override
    Point getPosition();


}
