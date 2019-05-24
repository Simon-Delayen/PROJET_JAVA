package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Entity;

/**
 * The Class DAOEntity.
 *
 * @author Jean-Aymeric Diet
 *
 * @param <E>
 *          the element type
 */
abstract class DAOEntity<E extends Entity> {

	/**
	 * The connection.
	 */
	private final Connection connection;
	private static String sqlLevelById   = "{call getLevelCompById(?)}";
	private static int    ColumnX  = 1;
	private static int    ColumnY  = 2;
	private static int    ColumnSprite  = 3;
	private static ResultSet result;

	/**
	 * Instantiates a new DAO entity.
	 *
	 * @param connection the connection
	 * @throws SQLException the SQL exception
	 */
	public DAOEntity(final Connection connection) throws SQLException {
		this.connection = connection;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	protected Connection getConnection() {
		return this.connection;
	}

	/**
	 * Creates the.
	 *
	 * @param entity the entity
	 * @return true, if successful
	 */
	public abstract boolean create(E entity);

	/**
	 * Delete.
	 *
	 * @param entity the entity
	 * @return true, if successful
	 */
	public abstract boolean delete(E entity);

	/**
	 * Update.
	 *
	 * @param entity the entity
	 * @return true, if successful
	 */
	public abstract boolean update(E entity);

	/**
	 * Find.
	 *
	 * @param id the id
	 * @return the e
	 */
	public abstract E find(int id);

	/**
	 * Find.
	 *
	 * @param code the code
	 * @return the e
	 */
	public abstract E find(String code);

	protected static ResultSet executeQuery(final String query) {
		return DBConnection.getInstance().executeQuery(query);
	}

	protected static int executeUpdate(final String query) {
		return DBConnection.getInstance().executeUpdate(query);
	}

	protected static CallableStatement prepareCall(final String query) {
		return DBConnection.getInstance().prepareCall(query);
	}

	public static ResultSet getLevelCompById(final int idlevel) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlLevelById);
		callStatement.setInt(1, idlevel); //define the first variable of the stored procedure to idlevel to choose the level to load

		if (callStatement.execute()) {
			result = callStatement.getResultSet();
		}
		return result;
	}

	public static int getColumnX() {
		return ColumnX;
	}

	public static void setColumnX(int columnX) {
		ColumnX = columnX;
	}

	public static int getColumnY() {
		return ColumnY;
	}

	public static void setColumnY(int columnY) {
		ColumnY = columnY;
	}

	public static int getColumnSprite() {
		return ColumnSprite;
	}

	public static void setColumnSprite(int columnSprite) {
		ColumnSprite = columnSprite;
	}
}
