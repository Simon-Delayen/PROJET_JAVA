package model;

import java.sql.CallableStatement;
import java.sql.ResultSet;

/**
 * The Class DAOEntity.
 *
 * @author Jean-Aymeric Diet
 */
abstract class DAOEntity {

	/**
	 * Execute query.
	 *
	 * @param query
	 *            the query
	 * @return the result set
	 */
	protected static ResultSet executeQuery(final String query) {
		return DBProperties.getInstance().executeQuery(query);
	}

	/**
	 * Execute update.
	 *
	 * @param query
	 *            the query
	 * @return the int
	 */
	protected static int executeUpdate(final String query) {
		return DBProperties.getInstance().executeUpdate(query);
	}

	/**
	 * Prepare call.
	 *
	 * @param query
	 *            the query
	 * @return the callable statement
	 */
	protected static CallableStatement prepareCall(final String query) {
		return DBProperties.getInstance().prepareCall(query);
	}

}
