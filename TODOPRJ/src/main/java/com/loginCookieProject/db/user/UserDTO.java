package com.loginCookieProject.db.user;

public class UserDTO {
	private String userId;
	private String userPwd;
	private String userName;
	private String userEmail;

	public UserDTO() {
	 // TODO Auto-generated constructor stub
	}

	public UserDTO(String userId, String userPwd, String userName, String userEmail){
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userEmail = userEmail;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	//toString()
	
	public String toString() {
		return "UserData [userId =" + userId + ", userPwd =" + userPwd + ", userName ="+userName+", userEmail =" +userEmail+"]";
	}
}
	