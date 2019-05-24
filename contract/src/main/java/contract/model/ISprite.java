package contract.model;

import java.awt.*;
import java.io.IOException;

public interface ISprite {
    Image getImage();
    void loadImage() throws IOException;
    char getConsoleImage();

}
