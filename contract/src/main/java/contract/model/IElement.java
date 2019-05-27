package contract.model;

import fr.exia.showboard.ISquare;
import model.element.Sprite;

import java.awt.*;

public interface IElement extends ISquare {
    /**
     * Gets the sprite.
     *
     * @return the sprite
     */
    Sprite getSprite();

    /**
     * Gets the permeability.
     *
     * @return the permeability
     */
    Permeability getPermeability();

    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.ISquare#getImage()
     */
    @Override
    Image getImage();

    void setPermeability(Permeability permeability);
}
