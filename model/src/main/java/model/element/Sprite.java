package model.element;

import contract.model.ISprite;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.IOException;

public class Sprite implements ISprite {
    /** The image. */
    private Image image;
    /** The image name. */
    private String imageName;
    /** The image windows. */
    private char imageWindows;
    /** The loaded image */
    private boolean imageLoaded;

    /**
     * Instantiates a new sprite.
     *
     * @param character
     *            the character
     * @param imageName
     *            the image name
     */
    public Sprite(final char character, final String imageName) {
        this.setImageWindows(character);
        this.setImageName(imageName);
    }

    /**
     * Instantiates a new sprite.
     *
     * @param character
     *            the character
     */
    public Sprite(final char character) {
        this(character, "noimage.png");
    }

    /**
     * Gets the image.
     *
     * @return the image
     */
    public final Image getImage() {
        return this.image;
    }

    /**
     * Loads image.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public final void loadImage() throws IOException {

        this.setImage(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(this.getImageName())));
    }

    /**
     * Gets the image windows
     *
     * @return the imageWindows
     */
    public final char getImageWindows() {
        return this.imageWindows;
    }

    /**
     * Sets the image.
     *
     * @param image
     *            the new image
     */
    public void setImage(final Image image) {
        this.image = image;
    }

    /**
     * Sets the image windows.
     *
     * @param imageWindows
     *            the image Windows to set
     */
    private void setImageWindows(final char imageWindows) {
        this.imageWindows = imageWindows;
    }

    /**
     * Gets the image name.
     *
     * @return the imageName
     */
    public final String getImageName() {
        return this.imageName;
    }

    /**
     * Sets the image name.
     *
     * @param imageName
     *            the imageName to set
     */
    private void setImageName(final String imageName) {
        this.imageName = imageName;
    }

    /**
     * Checks if is image loaded.
     *
     * @return true, if is image loaded
     */
    public final boolean isImageLoaded() {
        return this.imageLoaded;
    }

    /**
     * Sets the image loaded.
     *
     * @param isImageLoaded
     *            the new image loaded
     */
    public final void setImageLoaded(final boolean isImageLoaded) {
        this.imageLoaded = isImageLoaded;
    }
}
