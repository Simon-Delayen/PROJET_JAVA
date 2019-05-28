package model.element.motionless;


import contract.model.ISprite;
import contract.model.Permeability;
import model.element.Element;
import model.element.Sprite;

public abstract class MotionlessElement extends Element {

    /**
     * Instantiates a new motionless element.
     *
     * @param sprite
     *            the sprite
     */

    MotionlessElement(final Sprite sprite, final Permeability permeability) {
        super(sprite, permeability);
    }
}
