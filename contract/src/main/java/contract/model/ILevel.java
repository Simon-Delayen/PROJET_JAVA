package contract.model;

import contract.IModel;

import java.util.Observable;

public interface ILevel extends IModel {
    int getWidth();
    int getHeight();

    IElement getOnTheLevelXY(int x, int y);

    Observable getObservable();

}
