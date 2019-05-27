package model;

import contract.model.IElement;
import contract.model.ILevel;
import model.element.motionless.MotionlessFactory;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

public class Level extends Observable implements ILevel{

    /** The width. */
    public int width = 16;

    /** The height. */
    public int height = 16;

    /** The on the level. */
    private IElement[][] onTheLevel;

    /**
     * Instantiates a new level with the content of the db.
     *
     * @param idlevel
     *            the idlevel where the map of the road is
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws SQLException
     */
    Level(final int idlevel) throws IOException, SQLException {
        super();
        this.loadLevel(idlevel);
    }

    /**
     * Loads the level stored all motion less position, instantiate all mobile element.
     *
     * @param idlevel
     *            the idlevel
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws SQLException
     */
    private void loadLevel(final int idlevel) throws IOException, SQLException {

        this.onTheLevel = new IElement[this.getWidth()][this.getHeight()]; //create a 16/14 board and set all compartement to null

        for (int n=0; n<height; n++) //now set all compartment to the default square 'background' (background)
        {
            for (int i=0; i < width;i++)
            {
                this.setOnTheLevelXY(MotionlessFactory.getFromFileSymbol(' '), i, n);
            }
        }

    ResultSet result = DAOHelloWorld.getLevelCompById(idlevel); //
        result.close();
}

    /**
     * get the width
     */
    public final int getWidth() {
        return this.width;
    }

    /**
     * get the height
     */
    public final int getHeight() {
        return this.height;
    }

    /**
     * get element by XY
     */
    public final IElement getOnTheLevelXY(final int x, final int y) {
        return this.onTheLevel[x][y];
    }


    /**
     * Get the level
     */
    @Override
    public ILevel getLevel() {
        return this;
    }

    /**
     * Get the observable
     */
    public Observable getObservable() {
        return this;
    }

    /**
     * Sets the on the level XY.
     *
     * @param element
     *            the element
     * @param x
     *            the x
     * @param y
     *            the y
     */
    private void setOnTheLevelXY(final IElement element, final int x, final int y) {
        this.onTheLevel[x][y] = element;
    }

}
