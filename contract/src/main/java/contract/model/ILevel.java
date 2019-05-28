package contract.model;

import java.util.Observable;

public interface ILevel {

	public int getWidth();

	public int getHeight();
	
	public IElement getOnLevel(int x, int y);
	
	public Observable getObservable();
}
