package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * The Class DAOHelloWorld.
 *
 * @author Jean-Aymeric Diet
 */
class DAOHelloWorld extends DAOEntity {

	/** The sql procedure to get all the level. */
	private static String sqlLevelById   = "{call getLevelCompById(?)}";

	/** The id column index. */
	private static int    ColumnX  = 1;

	/** The name column index. */
	private static int    ColumnY  = 2;

	/** The name column index. */
	private static int    ColumnSprite  = 3;

	private static ResultSet result;

	/**
	 * Gets each sprite of the choosen level.
	 *
	 * @param idlevel
	 *            the level id
	 * @return the result of sql request
	 * @throws SQLException
	 *             the SQL exception
	 */
	public static ResultSet getLevelCompById(final int idlevel) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlLevelById);
		callStatement.setInt(1, idlevel); //define the first variable of the stored procedure to idlevel to choose the level to load

		if (callStatement.execute()) {
			result = callStatement.getResultSet();
		}
		return result;
	}

	/**
	 * Getter for position X
	 */
	public static int getColumnX() {
		return ColumnX;
	}

	/**
	 * Setter for position X
	 *
	 * @param x
	 * 	the x position
	 */
	public static void setColumnX(int columnX) {
		ColumnX = columnX;
	}

	/**
	 * Getter for position Y
	 */
	public static int getColumnY() {
		return ColumnY;
	}

	/**
	 * Setter for position Y
	 *
	 * @param y
	 * 	the y position
	 */
	public static void setColumnY(int columnY) {
		ColumnY = columnY;
	}

	/**
	 * Getter for sprite
	 */
	public static int getColumnSprite() {
		return ColumnSprite;
	}

	/**
	 * Setter for sprite
	 *
	 * @param sprite
	 * 	the sprite
	 */
	public static void setColumnSprite(int columnSprite) {
		ColumnSprite = columnSprite;
	}

}
