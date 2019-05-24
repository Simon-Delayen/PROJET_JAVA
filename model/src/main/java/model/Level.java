package model;

import contract.model.IElement;
import contract.model.ILevel;
import model.element.motionless.MotionlessFactory;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

public class Level extends Observable implements ILevel{

    public int width = 16;
    public int height = 16;
    private IElement wall;
    private IElement[][] onTheLevel;

    Level(final int idlevel) throws IOException, SQLException {
        super();
        this.loadLevel(idlevel);
    }

    private void loadLevel(final int idlevel) throws IOException, SQLException {

        this.onTheLevel = new IElement[this.getWidth()][this.getHeight()]; //create a 16/14 board and set all compartement to null

        for (int n=0; n<height; n++) //now set all compartment to the default square 'blacktile' (background)
        {
            for (int i=0; i < width;i++)
            {
                this.setOnTheLevelXY(MotionlessFactory.getFromFileSymbol(' '), i, n);
            }
        }

    ResultSet result = DAOEntity.getLevelCompById(idlevel); //

}

    public final int getWidth() {
        return this.width;
    }


    public final int getHeight() {
        return this.height;
    }


    public final IElement getOnTheLevelXY(final int x, final int y) {
        return this.onTheLevel[x][y];
    }


    @Override
    public ILevel getLevel() {
        return null;
    }

    public Observable getObservable() {
        return this;
    }

    private void setOnTheLevelXY(final IElement element, final int x, final int y) {
        this.onTheLevel[x][y] = element;
    }

}
