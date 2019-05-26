package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.HelloWorld;

/**
 * The Class DAOHelloWorld.
 *
 * @author Jean-Aymeric Diet
 */
class DAOHelloWorld extends DAOEntity<HelloWorld> {

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
	 * Instantiates a new DAO hello world.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAOHelloWorld(final Connection connection) throws SQLException {
		super(connection);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#create(model.Entity)
	 */
	@Override
	public boolean create(final HelloWorld entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#delete(model.Entity)
	 */
	@Override
	public boolean delete(final HelloWorld entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#update(model.Entity)
	 */
	@Override
	public boolean update(final HelloWorld entity) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(int)
	 */
	@Override
	public HelloWorld find(final int id) {
		HelloWorld helloWorld = new HelloWorld();

		try {
			final String sql = "{call helloworldById(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				helloWorld = new HelloWorld(id, resultSet.getString("code"), resultSet.getString("message"));
			}
			return helloWorld;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(java.lang.String)
	 */
	@Override
	public HelloWorld find(final String code) {
		HelloWorld helloWorld = new HelloWorld();

		try {
			final String sql = "{call helloworldByCode(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setString(1, code);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				helloWorld = new HelloWorld(resultSet.getInt("id"), code, resultSet.getString("message"));
			}
			return helloWorld;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

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
		callStatement.execute();
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
