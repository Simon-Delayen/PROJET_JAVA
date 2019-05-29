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
     * Get Elements that need to be update during the game
     *
     * @return Elements
     */
    IElement getEarth();
    IElement getDoor();
    IElement getDiamond();

}
