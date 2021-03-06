package model;

import contract.model.IElement;
import contract.model.ILevel;
import contract.model.IMobile;
import contract.model.Permeability;
import model.element.mobile.Hero;
import model.element.mobile.Monster1;
import model.element.mobile.Monster2;
import model.element.mobile.RockMobile;
import model.element.motionless.MotionlessFactory;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

public class Level extends Observable implements ILevel{

    /** The width. */
    public int width = 36;

    /** The height. */
    public int height = 26;

    /** The on the level. */
    private IElement[][] onTheLevel;

    /** The hero. */
    private IMobile hero;

    /** The monster of type 1. */
    private IMobile monster1;
    private boolean monster1instance;

    /** The monster of type 2. */
    private IMobile monster2;
    private boolean monster2instance;

    /** The dirt */
    private IElement dirt;

    /** The door */
    private IElement door;

    /** The back */
    private IElement back;

    /** The rock */
    private IElement rock;

    /** The diamond */
    private IElement diamond;

    /** The RockMobile */
    private IMobile rockMobile;

    /**
     * Instantiates a new level with the content of the db.
     *
     * @param idlevel
     *            the idlevel where the map of the road is
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws SQLException
     *              it's a SQLException
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
     *              it's a SQLException
     */
    private void loadLevel(final int idlevel) throws IOException, SQLException {

        this.onTheLevel = new IElement[this.getWidth()][this.getHeight()]; //create a 35/25 board and set all compartment to null

        for (int n=0; n<height; n++) //now set all compartment to the default square 'background' (background)
        {
            for (int i=0; i < width;i++)
            {
                this.setOnTheLevelXY(MotionlessFactory.getFromFileSymbol(' '), i, n);
            }
        }

    ResultSet result = DAOHelloWorld.getLevelCompById(idlevel);     //this will stored the result return by the stored procedure

        while(result.next()) { //while there is element for this level then we overwrite the default background

            switch (result.getString(DAOHelloWorld.getColumnSprite()).charAt(0)) {
                case '@'://if character correspond to hero (@) then we create hero
                    setHero(new Hero(result.getInt(DAOHelloWorld.getColumnX()),result.getInt(DAOHelloWorld.getColumnY()),this));
                    break;
                case '1'://if character correspond to monster1 (1) then we create monster1
                    setMonster1(new Monster1(result.getInt(DAOHelloWorld.getColumnX()), result.getInt(DAOHelloWorld.getColumnY()), this));
                    setMonster1instance(true);
                    break;
                case '2'://if character correspond to monster2 (2) then we create monster2
                    setMonster2(new Monster2(result.getInt(DAOHelloWorld.getColumnX()), result.getInt(DAOHelloWorld.getColumnY()), this));
                    setMonster2instance(true);
                    break;
                case 'J'://if character correspond to rockMobile (J) then we create RockMobile
                    setRockMobile(new RockMobile(result.getInt(DAOHelloWorld.getColumnX()), result.getInt(DAOHelloWorld.getColumnY()), this));
                    break;
                case 'H'://if character correspond to the door we put the door in the variable door
                    this.setOnTheLevelXY(MotionlessFactory.getFromFileSymbol(
                            result.getString(DAOHelloWorld.getColumnSprite()).charAt(0)),result.getInt(DAOHelloWorld.getColumnX()),result.getInt(DAOHelloWorld.getColumnY()));
                    setDoor(this.getOnTheLevelXY(result.getInt(DAOHelloWorld.getColumnX()),result.getInt(DAOHelloWorld.getColumnY())));
                    break;
                case 'R'://if character correspond to the rock we put the door in the variable rock
                    this.setOnTheLevelXY(MotionlessFactory.getFromFileSymbol(
                            result.getString(DAOHelloWorld.getColumnSprite()).charAt(0)),result.getInt(DAOHelloWorld.getColumnX()),result.getInt(DAOHelloWorld.getColumnY()));
                    setRock(this.getOnTheLevelXY(result.getInt(DAOHelloWorld.getColumnX()),result.getInt(DAOHelloWorld.getColumnY())));
                    break;
                case 'D'://if character correspond to the diamond we put it in the variable diamond
                    this.setOnTheLevelXY(MotionlessFactory.getFromFileSymbol(
                            result.getString(DAOHelloWorld.getColumnSprite()).charAt(0)),result.getInt(DAOHelloWorld.getColumnX()),result.getInt(DAOHelloWorld.getColumnY()));
                    setDiamond(this.getOnTheLevelXY(result.getInt(DAOHelloWorld.getColumnX()),result.getInt(DAOHelloWorld.getColumnY())));
                    break;
                case ':'://if character correspond to the dirt we put it in the variable dirt
                    this.setOnTheLevelXY(MotionlessFactory.getFromFileSymbol(
                            result.getString(DAOHelloWorld.getColumnSprite()).charAt(0)),result.getInt(DAOHelloWorld.getColumnX()),result.getInt(DAOHelloWorld.getColumnY()));
                    setDirt(this.getOnTheLevelXY(result.getInt(DAOHelloWorld.getColumnX()),result.getInt(DAOHelloWorld.getColumnY())));
                    break;
                default:
                    this.setOnTheLevelXY(MotionlessFactory.getFromFileSymbol(
                            result.getString(DAOHelloWorld.getColumnSprite()).charAt(0)), result.getInt(DAOHelloWorld.getColumnX()), result.getInt(DAOHelloWorld.getColumnY()));
                    break;
            }
        }
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

    @Override
    public void removeOnTheLevelXY(int x, int y) {
        this.onTheLevel[x][y].setPermeability(Permeability.PENETRABLE);
        this.onTheLevel[x][y].getSprite().setImageName("Background.png");
        try {
            this.onTheLevel[x][y].getSprite().loadImage();
            System.out.println("coucou");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("removed: x=" + x + ", y=" + y);
    }

    /**
     * Notify view of change
     */
    @Override
    public void setMobilHasChanged() {
        this.setChanged();
        this.notifyObservers();
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

    /**
     * Get the level
     *
     * @return the level
     */
    public ILevel getLevel() {
        return this;
    }

    /**
     * Get the observable
     *
     * @return the observable
     */
    public Observable getObservable() {
        return this;
    }


    /**
     * All getters and setter for element of the map that need to be update during the game
     */
    public IMobile getHero() {
        return hero;
    }

    public void setHero(IMobile hero) {
        this.hero = hero;
    }

    public IMobile getRockMobile() {
        return rockMobile;
    }

    public void setRockMobile(IMobile rockMobile) {
        this.rockMobile = rockMobile;
    }

    public IElement getRock() {
        return rock;
    }

    public void setRock(IElement rock) {
        this.rock = rock;
    }

    public IMobile getMonster1() {
        return monster1;
    }

    public void setMonster1(IMobile monster1) {
        this.monster1 = monster1;
    }

    public IMobile getMonster2() {
        return monster2;
    }

    public void setMonster2(IMobile monster2) {
        this.monster2 = monster2;
    }

    public boolean getMonster1instance() {
        return monster1instance;
    }

    public void setMonster1instance(boolean monster1instance) {
        this.monster1instance = monster1instance;
    }

    public boolean getMonster2instance() {
        return monster2instance;
    }

    public void setMonster2instance(boolean monster2instance) {
        this.monster2instance = monster2instance;
    }

    public IElement getDirt() {
        return dirt;
    }

    public void setDirt(IElement dirt) {
        this.dirt = dirt;
    }

    public IElement getDoor() {
        return door;
    }

    public void setDoor(IElement door) {
        this.door = door;
    }

    public IElement getBack() {
        return back;
    }

    public void setBack(IElement back) {
        this.back = back;
    }

    public IElement getDiamond() {
        return diamond;
    }

    public void setDiamond(IElement diamond) {
        this.diamond = diamond;
    }

}
