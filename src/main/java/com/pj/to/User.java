package com.pj.to;

public class User {
	
	int user_id;
	String userName;
	String password;
	String loginStatus;
	public User(int user_id, String userName,String password,String loginStatus) {
		this.userName=userName;
		this.password=password;
		this.user_id=user_id;
		this.loginStatus=loginStatus;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	
	

}
