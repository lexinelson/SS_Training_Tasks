/**
 * Week 1 Evaluation Project
 */
package com.ss.firstwk.fri.proj;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Repaired Singleton for assignment 6 of project
 * @author Lexi Nelson
 *
 */
public class SingletonFixed {
	/**
	 * Volatile because multiple access of same instance
	 */
	private static Connection conn = null;
	
	/**
	 * Volatile because multiple access
	 */
	volatile private static SingletonFixed instance = null;
	
	/**
	 * Private constructor so can't be made
	 */
	private SingletonFixed() { }
	
	/**
	 * Double checked locking to ensure ONLY ONE instance
	 * @return
	 */
	public static SingletonFixed getInstance() {
		if (instance == null) {
			synchronized(SingletonFixed.class) {
				if (instance == null)
					instance = new SingletonFixed();
			}
		}
		return instance;
	}
	
	/**
	 * No idea what this is supposed to do - but the only thing it can is throw exception
	 * @param input
	 * @throws SQLException
	 */
	public static void databaseQuery(BigDecimal input) throws SQLException {
		
		//Shared connection - shouldn't be getting assigned + used simultaneously
		if (conn == null) {
			synchronized (SingletonFixed.class) {
				if (conn == null)
					conn = DriverManager.getConnection("url of database");
			}
		}
		//I suspect accessing the connection should also be synchronized
		//But idk this data type and I'm not going to destroy performance for a hunch
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select id from table");
		BigDecimal x;
		while (rs.next()) {
			x = input.multiply(new BigDecimal(rs.getInt(1)));
		}
	}
}
