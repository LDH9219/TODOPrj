package com.loginCookieProject.db.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	public String loginCheck(String userId, String userPwd) {
		String userName = null;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
			
	    try {
	      conn = DBconn.getConnection(); 
	      String sql = "SELECT USER_NAME FROM USERS WHERE USER_ID = ? and USER_PWD=?";
	      pstmt = conn.prepareStatement(sql);
	      
	      pstmt.setString(1, userId);
	      pstmt.setString(2, userPwd);
				
	      rs = pstmt.executeQuery();
	      if(rs.next()) {
	        userName = rs.getString("USER_NAME");
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    }			
	    return userName;
	  }
	  
	public int regiCheck(UserDTO UserDTO) {
		  int result = 0;
		  Connection conn = null;
		  
		try {
			 conn = DBconn.getConnection();
			 String sql = "INSERT INTO USERS(ID_NUM, USER_ID, USER_PWD, USER_NAME, USER_EMAIL) VALUES(NUM_SEQ.nextval,?,?,?,?)";
			 PreparedStatement pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, UserDTO.getUserId());
			 pstmt.setString(2, UserDTO.getUserPwd());
			 pstmt.setString(3, UserDTO.getUserName());
			 pstmt.setString(4, UserDTO.getUserEmail());
			 
			 result = pstmt.executeUpdate();
			 
		  } catch(Exception e){
			  e.printStackTrace();
		  }
		return result;
	  }
	
	public boolean duplicateCheck(String userId) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    boolean result = false;

	    try {
	        conn = DBconn.getConnection();
	        String sql = "SELECT COUNT(*) FROM USERS WHERE USER_ID = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, userId);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            int count = rs.getInt(1);
	            if (count > 0) {
	                result = true; // true가 반환되면 유저 ID가 이미 존재하는 것
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return result;
	}
	
	public String getUserName(String userId) {
	    Connection conn = null;
	    String userName = null;
	    ResultSet rs = null;
	    PreparedStatement pstmt = null;
	    
	    try {
	        conn = DBconn.getConnection();
	        String sql = "SELECT USER_NAME FROM USERS WHERE USER_ID = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, userId);

	        rs = pstmt.executeQuery(); // execute the query and assign the result set

	        if (rs.next()) {
	            userName = rs.getString("USER_NAME"); // use correct column name
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pstmt != null) {
	                pstmt.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return userName;
	}
}