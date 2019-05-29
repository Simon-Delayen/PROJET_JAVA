package contract.model;

import java.util.Observable;

public interface ILevel {

    /**
     * Gets the width.
     *
     * @return the width
     */
    int getWidth();

    /**
     * Gets the height.
     *
     * @return the height
     */
    int getHeight();

    /**
     * Gets the on the road XY.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @return the on the road XY
     */
    IElement getOnTheLevelXY(int x, int y);

    /**
     * Sets the mobile has changed.
     */
    void setMobilHasChanged();

    /**
     * Sets the mobile has fall.
     */
    //void setMobilHasFall();

    /**
     * Gets the observable.
     *
     * @return the observable
     */
    Observable getObservable();

    /**
     * Gets the lorann.
     *
     * @return the lorann
     */
    IMobile getHero();
    IMobile getRock();

    /**
     * Gets the monsters instance.
     *
     * @return the monsters
     */
    IMobile getMonster1();
    IMobile getMonster2();

    /**
     * Get if monsters are instantiate or no.
     *
     * @return the monsters instance
     */
    boolean getMonster1instance();
    boolean getMonster2instance();

    /**
     * Get Elements that need to be update during the game
     *
     * @return Elements
     */
    IElement getEarth();
    IElement getDoor();
    IElement getDiamond();

}
