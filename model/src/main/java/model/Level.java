package model;

import contract.model.IElement;
import contract.model.ILevel;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

public class Level extends Observable implements ILevel {

    public int width = 16;
    public int height = 14;
    private IElement wall;
    private IElement[][] onTheLevel;

    Level(final int idlevel) throws IOException, SQLException {
        super();
        this.loadLevel(idlevel);
    }

    private void loadLevel(final int idlevel) throws IOException, SQLException {

        this.onTheLevel = new IElement[this.getWidth()][this.getHeight()]; //create a 24/12 board and set all compartement to null

        for (int n=0; n<height; n++) //now set all compartment to the default square 'blacktile' (background)
        {
            for (int i=0; i < width;i++)
            {
                this.setOnTheLevelXY(MotionlessElementFactory.getFromFileSymbol(' '), i, n);
            }
        }

    ResultSet result = DAOEntity.getLevelCompById(idlevel); //

        while(result.next()) { //while there is element for this level then we overwrite the default background

        switch (result.getString(DAOEntity.getColumnSprite()).charAt(0)) {

            case 'O'://if character correspond to the crystal we put it in the variable crystall
                this.setOnTheLevelXY(MotionlessElementFactory.getFromFileSymbol(
                        result.getString(DAOEntity.getColumnSprite()).charAt(0)),result.getInt(DAOEntity.getColumnX()),result.getInt(DAOEntity.getColumnY()));
                setWall(this.getOnTheLevelXY(result.getInt(DAOEntity.getColumnX()),result.getInt(DAOEntity.getColumnY())));
                break;
            default:
                this.setOnTheLevelXY(MotionlessElementFactory.getFromFileSymbol(
                        result.getString(DAOEntity.getColumnSprite()).charAt(0)),result.getInt(DAOEntity.getColumnX()),result.getInt(DAOEntity.getColumnY()));
                break;
        }
    }
        result.close();
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

    @Override
    public Observable getObservable() {
        return this;
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
