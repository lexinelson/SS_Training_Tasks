/**
 * 
 */
package com.ss.firstwk.fri.proj;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author lexne
 *
 */
public class SingletonFixed {
	private static Connection conn = null;
	
	volatile private static SingletonFixed instance = null;
	
	private SingletonFixed() { }
	
	public static SingletonFixed getInstance() {
		if (instance == null) {
			synchronized(SingletonFixed.class) {
				if (instance == null)
					instance = new SingletonFixed();
			}
		}
		return instance;
	}
	
	public static void databaseQuery(BigDecimal input) throws SQLException {
		conn = DriverManager.getConnection("url of database");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select id from table");
		BigDecimal x;
		while (rs.next()) {
			x = input.multiply(new BigDecimal(rs.getInt(1)));
		}

	}
}
