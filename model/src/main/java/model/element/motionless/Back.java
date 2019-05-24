package model.element.motionless;

import contract.model.ISprite;
import model.element.Sprite;

public class Back extends MotionlessElement {
    private static final Sprite SPRITE = new Sprite(' ', "Background.jpg");

    Back() {
        super(SPRITE);
    }
}
