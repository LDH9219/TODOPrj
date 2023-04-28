package com.loginCookieProject.db.todo;

import java.sql.Date;

public class TodoDTO {
	private int todoIndex;
	private String todoTitle;
	private String todoUser;
	private String todoList;
	private Date todoEndDate;
	
	public TodoDTO() {

	}
		
	public TodoDTO(int todoIndex, String todoTitle, String todoUser, String todoList, Date todoEndDate) {
		this.todoIndex = todoIndex;
		this.todoTitle = todoTitle;
		this.todoUser = todoUser;
		this.todoList = todoList;
		this.todoEndDate = todoEndDate;
	}
	public int getTodoIndex() {
		return todoIndex;
	}
	public void setTodoIndex(int todoIndex) {
		this.todoIndex = todoIndex;
	}
	
	public String getTodoTitle() {
		return todoTitle;
	}
	public void setTodoTitle(String todoTitle) {
		this.todoTitle = todoTitle;
	}
	public String getTodoUser() {
		return todoUser;
	}
	public void setTodoUser(String todoUser) {
		this.todoUser = todoUser;
	}
	public String getTodoList() {
		return todoList;
	}
	public void setTodoList(String todoList) {
		this.todoList = todoList;
	}
	public Date getTodoEndDate() {
		return todoEndDate;
	}
	public void setTodoEndDate(Date todoEndDate) {
		this.todoEndDate = todoEndDate;
	}
	@Override
	public String toString() {
		return "TodoDTO [todoIndex=" + todoIndex + ", todoTitle=" + todoTitle + ", todoUser=" + todoUser + ", todoList="
				+ todoList + ", todoEndDate=" + todoEndDate + "]";
	}
}

