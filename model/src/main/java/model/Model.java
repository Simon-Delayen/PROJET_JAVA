package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import contract.model.ILevel;
import entity.HelloWorld;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	/** The helloWorld. */
	private HelloWorld helloWorld;

	/** The level. */
	private ILevel level;

	/**
	 * Instantiates a new model.
	 * this load and stored the level from the DB
	 * this load the player and monsters
	 *
	 * @param idlevel
	 *            the idlevel to know the level to load
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
	 *
	 */
	private void setLevel(final ILevel level) {
		this.level = level;
	}

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.helloWorld = new HelloWorld();
	}

	/**
     * Gets the hello world.
     *
     * @return the hello world
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public HelloWorld getHelloWorld() {
		return this.helloWorld;
	}

	/**
     * Sets the hello world.
     *
     * @param helloWorld
     *            the new hello world
     */
	private void setHelloWorld(final HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
		this.setChanged();
		this.notifyObservers();
	}

	/**
     * Load hello world.
     *
     * @param code
     *            the code
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadHelloWorld(final String code) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setHelloWorld(daoHelloWorld.find(code));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
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
