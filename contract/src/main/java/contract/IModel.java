package contract;

import java.util.Observable;

import contract.model.ILevel;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	ILevel getLevel();
	Observable getObservable();
}
