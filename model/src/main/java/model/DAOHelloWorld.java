package model;

import java.sql.CallableStatement;
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
