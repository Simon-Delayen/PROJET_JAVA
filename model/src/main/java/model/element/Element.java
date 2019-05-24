package model.element;

import contract.model.IElement;
import contract.model.ISprite;

import java.awt.*;

public class Element implements IElement {
    private Sprite       sprite;


    public Element(final Sprite sprite) {
        this.setSprite(sprite);
    }

    @Override
    public final Sprite getSprite() {
        return this.sprite;
    }

    protected final void setSprite(final Sprite sprite2) {
        this.sprite = sprite2;
    }

    public final Image getImage() {
        return this.getSprite().getImage();
    }
}
