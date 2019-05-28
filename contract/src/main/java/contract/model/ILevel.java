package contract.model;

import contract.IModel;

import java.util.Observable;

public interface ILevel extends IModel {

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


    /**
     * Get Elements that need to be update during the game
     *
     * @return Elements
     */
    IElement getEarth();
}
