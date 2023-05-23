package com.loginCookieProject.db.user;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconn {
  public static Connection getConnection() {
    try {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "LOGPRJ";
        String password = "8327";
	
      return DriverManager.getConnection(url, username, password);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
		
    return null;
  }
}