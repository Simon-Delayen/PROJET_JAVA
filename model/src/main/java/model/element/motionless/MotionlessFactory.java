package model.element.motionless;

public abstract class MotionlessFactory {
    private static final Wall wall = new Wall();
    private static final Back back = new Back();

    private static MotionlessElement[]       motionlessElements  = {
            wall,
            back,
    };

    public static MotionlessElement createWall() {
        return wall;
    }

    public static MotionlessElement getFromFileSymbol(final char fileSymbol) {

        for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getSprite().getImageWindows()== fileSymbol) {
                return motionlessElement;
            }
        }
        return back;
    }
}
