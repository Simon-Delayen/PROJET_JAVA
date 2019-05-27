package model.element;

import contract.model.IElement;
import contract.model.ISprite;
import contract.model.Permeability;

import java.awt.*;

public class Element implements IElement {

    /** The sprite. */
    private Sprite       sprite;

    private Permeability permeability;

    /**
     * Instantiates a new element.
     *
     * @param sprite
     *            the sprite
     */
    public Element(final Sprite sprite, Permeability permeability) {
        this.setSprite(sprite);
        this.setPermeability(permeability);
    }

    /**
     * Get the sprite
     */
    @Override
    public final Sprite getSprite() {
        return this.sprite;
    }

    /**
     * Sets the sprite.
     *
     * @param sprite2
     *            the new sprite
     */
    protected final void setSprite(final Sprite sprite2) {
        this.sprite = sprite2;
    }

    /**
     * get the image of the sprite
     */
    public final Image getImage() {
        return this.getSprite().getImage();
    }

    public Permeability getPermeability() {
        return this.permeability;
    }

    public void setPermeability(Permeability permeability) {
        this.permeability = permeability;
    }
}
