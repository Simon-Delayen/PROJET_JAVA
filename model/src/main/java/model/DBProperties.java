package model;

import java.sql.*;

/**
 * The Class DBProperties.
 *
 * @author Jean-Aymeric Diet
 */
class DBProperties {

	/** The instance. */
	private static DBProperties instance;

	/** The login. */
	private static String user = "root";

	/** The password. */
	private static String password = "";

	/** The url. */
	private static String url = "jdbc:mysql://localhost:3306/jpublankproject?useSSL=false";

	/** The connection. */
	private Connection connection;

	/** The statement. */
	private Statement statement;

	/**
	 * Instantiates a new DBProperties.
	 */
	private DBProperties() {
		this.open();
	}

	/**
	 * Gets the single instance of DBProperties.
	 *
	 * @return single instance of DBProperties
	 */
	public static DBProperties getInstance() {
		if (instance == null) {
			setInstance(new DBProperties());
		}
		return instance;
	}

	/**
	 * Sets the instance.
	 *
	 * @param instance
	 *            the new instance
	 */
	private static void setInstance(final DBProperties instance) {
		DBProperties.instance = instance;
	}

	/**
	 * Open.
	 *
	 * @return true, if successful
	 */
	private boolean open() {
		try {
			this.connection = DriverManager.getConnection(DBProperties.url, DBProperties.user,DBProperties.password);
			this.statement = this.connection.createStatement();
			return true;
		} catch (final SQLException exception) {
			exception.printStackTrace();
		}
		return false;
	}

	/**
	 * Execute query.
	 *
	 * @param query
	 *            the query
	 * @return the result set
	 */
	public ResultSet executeQuery(final String query) {
		try {
			return this.getStatement().executeQuery(query);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Prepare call.
	 *
	 * @param query
	 *            the query
	 * @return the java.sql. callable statement
	 */
	public CallableStatement prepareCall(final String query) {
		try {
			return this.getConnection().prepareCall(query);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Execute update.
	 *
	 * @param query
	 *            the query
	 * @return the int
	 */
	public int executeUpdate(final String query) {
		try {
			return this.statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		return this.connection;
	}

	/**
	 * Sets the connection.
	 *
	 * @param connection
	 *            the new connection
	 */
	public void setConnection(final Connection connection) {
		this.connection = connection;
	}

	/**
	 * Gets the statement.
	 *
	 * @return the statement
	 */
	public Statement getStatement() {
		return this.statement;
	}

	/**
	 * Sets the statement.
	 *
	 * @param statement
	 *            the new statement
	 */
	public void setStatement(final Statement statement) {
		this.statement = statement;
	}
}
