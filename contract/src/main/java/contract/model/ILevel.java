package contract.model;

import java.util.Observable;

public interface ILevel {
    int getWidth();
    int getHeight();

    IElement getOnTheLevelXY(int x, int y);

    Observable getObservable();

    IElement getWall();
}
