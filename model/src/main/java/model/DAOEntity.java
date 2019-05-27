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
 */
 //*/ @param <E>
 //*          the element type
 //*/
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
