package model.element.motionless;

public abstract class MotionlessFactory {

    /** The Constant Wall. */
    private static final Wall wall = new Wall();

    /** The Constant Back(black background). */
    private static final Back back = new Back();

    /** The Constant Earth. */
    private static final Dirt dirt = new Dirt();

    /** The Constant Door. */
    private static final Door door = new Door();

    /** The Constant Door. */
    private static final Rock rock = new Rock();

    /** The Constant Diamond. */
    private static final Diamond diamond = new Diamond();

    private static MotionlessElement[] motionlessElements  = {
            wall,
            back,
            door,
            rock,
            dirt,
            diamond,
    };

    /**
     * Creates a new wall MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createWall() {
        return wall;
    }

    /**
     * Creates a new rock MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createRock() {
        return rock;
    }

    /**
     * Creates a new door MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDoor() {
        return door;
    }

/**
 * Creates a new earth MotionlessElements object.
 *
 * @return the motionless element
 */
public static MotionlessElement createDirt() {
        return dirt;
        }

/**
 * Creates a new diamond MotionlessElements object.
 *
 * @return the motionless element
 */
public static MotionlessElement createDiamond() {
        return diamond;
        }

    /**
     * Gets the good MotionlessElement from file symbol.
     *
     * @param fileSymbol
     *            the file symbol
     * @return the from file symbol
     */
    public static MotionlessElement getFromFileSymbol(final char fileSymbol) {

        for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getSprite().getImageWindows()== fileSymbol) {
                return motionlessElement;
            }
        }
        return back;
    }
}
