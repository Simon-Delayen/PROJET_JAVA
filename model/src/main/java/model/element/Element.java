package model;

import contract.model.IElement;
import contract.model.ISprite;

import java.awt.*;

public class Element implements IElement {
    private ISprite       sprite;


    public Element(final ISprite sprite) {
        this.setSprite(sprite);
    }

    @Override
    public final ISprite getSprite() {
        return this.sprite;
    }

    protected final void setSprite(final ISprite sprite2) {
        this.sprite = sprite2;
    }

    public final Image getImage() {
        return this.getSprite().getImage();
    }
}
