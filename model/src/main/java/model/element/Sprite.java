package model.element;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Sprite {
    private Image image;
    private String imageName;
    private char imageWindows;
    private boolean imageLoaded;

    public Sprite(final char character, final String imageName) {
        this.setImageWindows(character);
        this.setImageName(imageName);
    }

    public Sprite(final char character) {
        this(character, "noimage.jpg");
    }

    public final Image getImage() {
        return this.image;
    }

    public final void loadImage() throws IOException {

        this.setImage(ImageIO.read(new File("C:\\Users\\KAWAK\\OneDrive - Association Cesi Viacesi mail\\CESI EXIA\\A1 2018 - 2019\\UE 5 - JAVA -\\PROJET 5\\SPRITES\\sprites" + this.getImageName())));
    }

    public final char getImageWindows() {
        return this.imageWindows;
    }

    public void setImage(final Image image) {
        this.image = image;
    }

    private void setImageWindows(final char imageWindows) {
        this.imageWindows = imageWindows;
    }

    public final String getImageName() {
        return this.imageName;
    }

    private void setImageName(final String imageName) {
        this.imageName = imageName;
    }

    public final boolean isImageLoaded() {
        return this.imageLoaded;
    }

    public final void setImageLoaded(final boolean isImageLoaded) {
        this.imageLoaded = isImageLoaded;
    }
}
