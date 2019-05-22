package model;

import contract.model.IElement;

import java.io.IOException;
import java.sql.SQLException;

public class Level Implements ILevel {

    public int width = 16;
    public int height = 14;
    private IElement wall;

    Level(final int idlevel) throws IOException, SQLException {
        super();
    }


    @Override
    public final int getWidth() {
        return this.width;
    }

    @Override
    public final int getHeight() {
        return this.height;
    }

    @Override
    public final IElement getOnTheLevelXY(final int x, final int y) {
        return this.onTheLevel[x][y];
    }

    private void setOnTheLevelXY(final IElement element, final int x, final int y) {
        this.onTheLevel[x][y] = element;
    }

    public IElement getWall() {
        return wall;
    }

    public void setWall(IElement wall) {
        this.wall = wall;
    }
}
