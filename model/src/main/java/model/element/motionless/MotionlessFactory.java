package model.element.motionless;

public abstract class MotionlessFactory {

    /** The Constant Wall. */
    private static final Wall wall = new Wall();

    /** The Constant Back(black background). */
    private static final Back back = new Back();

    /** The Constant Back(black background). */
    private static final Earth earth = new Earth();

    private static MotionlessElement[] motionlessElements  = {
            wall,
            back,
            earth
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
 * Creates a new wall MotionlessElements object.
 *
 * @return the motionless element
 */
public static MotionlessElement createEarth() {
        return earth;
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
