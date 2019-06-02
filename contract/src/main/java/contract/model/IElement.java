package contract.model;

import showboard.ISquare;

import java.awt.*;

public interface IElement extends ISquare {
    /**
     * Gets the sprite.
     *
     * @return the sprite
     */
    ISprite getSprite();

    /**
     * Gets the permeability.
     *
     * @return the permeability
     */
    Permeability getPermeability();

    /*
     * (non-Javadoc)
     * @see showboard.ISquare#getImage()
     */
    @Override
    Image getImage();

    /**
     * Sets the permeability
     */
    void setPermeability(Permeability permeability);
}
