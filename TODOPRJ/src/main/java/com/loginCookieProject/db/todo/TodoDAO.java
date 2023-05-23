package com.loginCookieProject.db.todo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.loginCookieProject.db.user.DBconn;

public class TodoDAO {
	public int insertTodoList(TodoDTO TodoDTO) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
		conn = DBconn.getConnection(); 
		String sql = "INSERT INTO TODO_LIST_TABLE(TODO_TITLE, TODO_USER, TODO_LIST, TODO_END_DATE) VALUES (?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, TodoDTO.getTodoTitle());
		pstmt.setString(2, TodoDTO.getTodoUser());
		pstmt.setString(3, TodoDTO.getTodoList());
		pstmt.setDate(4, TodoDTO.getTodoEndDate());
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<TodoDTO> getTodoList(String todoUser) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		List<TodoDTO> list = new ArrayList<>();
		
		try {
		conn = DBconn.getConnection();
		String sql = "SELECT * FROM TODO_LIST_TABLE WHERE TODO_USER = ? ORDER BY TODO_END_DATE ASC";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, todoUser);
		
		ResultSet rs = pstmt.executeQuery();
		
			while(rs.next()) {
				int index = rs.getInt("TODO_INDEX");
				String title = rs.getString("TODO_TITLE");
				String user = rs.getString("TODO_USER");
				String dolist = rs.getString("TODO_LIST");
				Date endDate = rs.getDate("TODO_END_DATE");
			
				TodoDTO TodoDTO = new TodoDTO(index,title,user,dolist,endDate);
				list.add(TodoDTO);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public TodoDTO getTodo(int todoIndex) {
		TodoDTO tododto = null;
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBconn.getConnection();
			String sql = "SELECT * FROM TODO_LIST_TABLE WHERE TODO_INDEX=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, todoIndex);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int todoIndex_ = rs.getInt("TODO_INDEX");
				String todoTitle = rs.getString("TODO_TITLE");
				String todoUser = rs.getString("TODO_USER");
				String todoList = rs.getString("TODO_LIST");
				Date todoEndDate = rs.getDate("TODO_END_DATE");
				
				tododto = new TodoDTO(
						todoIndex_,
						todoTitle,
						todoUser,
						todoList,
						todoEndDate
						);
			}
			rs.close();
			pstmt.close();
			conn.close();
		}
		
		catch(SQLException e) {
		    e.printStackTrace();
		}
		return tododto;
	}
	
	public int updateTodoList(TodoDTO TodoDTO) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
		    conn = DBconn.getConnection();
		    String sql = "UPDATE TODO_LIST_TABLE SET TODO_TITLE = ?, TODO_LIST = ?, TODO_END_DATE = ? WHERE TODO_INDEX = ?";
		    pstmt = conn.prepareStatement(sql);

		    pstmt.setString(1, TodoDTO.getTodoTitle());
		    pstmt.setString(2, TodoDTO.getTodoList());
		    pstmt.setDate(3, TodoDTO.getTodoEndDate());
		    pstmt.setInt(4, TodoDTO.getTodoIndex());

		    result = pstmt.executeUpdate();

		    pstmt.close();
		    conn.close();
		    
		} catch(SQLException e) {
		    e.printStackTrace();
		}

		return result;
	}
	
	public int delTodoList(int todoIndex) throws SQLException {
		int result = 0;
	    Connection conn = null;
	    PreparedStatement pstmt = null;	    
	    
	    try {
	        conn = DBconn.getConnection();
	        String sql = "DELETE FROM TODO_LIST_TABLE WHERE TODO_INDEX=?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, todoIndex);
	        
	        result = pstmt.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return result;
	}
}
