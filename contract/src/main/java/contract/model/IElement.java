package contract.model;

import fr.exia.showboard.ISquare;
import model.element.Sprite;

public interface IElement extends ISquare {
    Sprite getSprite();
}
