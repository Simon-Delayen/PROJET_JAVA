package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import contract.model.ILevel;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	/** The level. */
	private ILevel level;

	/**
	 * Instantiates a new model.
	 * this load and stored the level from the DB
	 * this load the player and monsters
	 *
	 * @param fileName
	 *            the fileName to know the level to load
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws SQLException
	 * 			the SQL exception
	 */
	public Model(final int idlevel) throws IOException, SQLException {
		this.setLevel(new Level(idlevel));
	}

	/**
	 * get level
	 * @return level
	 */
	public final ILevel getLevel() {
		return this.level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level
	 * 			the level
	 *
	 */
	private void setLevel(final ILevel level) {
		this.level = level;
	}

	/**
     * Gets the observable.
     *
     * @return the observable
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
}
