package model.element.motionless;


import contract.model.ISprite;
import contract.model.Permeability;
import model.element.Element;
import model.element.Sprite;

import java.awt.*;

public abstract class MotionlessElement extends Element {
    private Point position;


    public Point getPosition() {
        return this.position;
    }

    public void setPosition(final Point position) {
        this.position = position;
    }


    /**
     * Instantiates a new motionless element.
     *
     * @param sprite
     *            the sprite
     * @param permeability
     *            the permeability
     */

    MotionlessElement(final ISprite sprite, final Permeability permeability) {
        super(sprite, permeability);
    }
}
