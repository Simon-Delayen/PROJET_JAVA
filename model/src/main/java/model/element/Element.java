package model.element;

import contract.model.IElement;
import contract.model.ISprite;

import java.awt.*;

public class Element implements IElement {

    /** The sprite. */
    private Sprite       sprite;

    /**
     * Instantiates a new element.
     *
     * @param sprite
     *            the sprite
     */
    public Element(final Sprite sprite) {
        this.setSprite(sprite);
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
}
