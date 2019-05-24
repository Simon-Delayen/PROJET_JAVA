package model.element.montionless;

public abstract class MontionlessElementFactory {
    private static final Wall wall = new Wall();
    private static final Tile tile = new Tile();

    private static MotionlessElement[]       motionlessElements  = {
            wall,
            tile,
    };

    public static MotionlessElement createWall() {
        return wall;
    }

    public static MotionlessElement getFromFileSymbol(final char fileSymbol) {

        for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessElement;
            }
        }
        return tile;
    }
}
