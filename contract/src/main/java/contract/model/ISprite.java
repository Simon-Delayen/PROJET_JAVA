package contract.model;

import java.awt.*;
import java.io.IOException;

public interface ISprite {

    /**
     * Gets the image.
     *
     * @return the image
     */
    Image getImage();

    void loadImage() throws IOException;

    /**
     * Gets the image windows.
     *
     * @return the ImagesWindows
     */
    char getImageWindows();

}
