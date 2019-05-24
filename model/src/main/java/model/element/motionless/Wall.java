package model.element.motionless;

import contract.model.ISprite;
import model.element.Sprite;

public class Wall extends MotionlessElement{
    private static final Sprite SPRITE = new Sprite('O', "wall.png");

    Wall() {
        super(SPRITE);
    }
}
