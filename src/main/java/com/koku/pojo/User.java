package com.koku.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class User {
	
	private String username;
	private String password;
	private String auth;
	private String registerdate;
	
	public User() {
		super();
	}
	public User(String username, String password, String auth, String registerdate) {
		super();
		this.username = username;
		this.password = password;
		this.auth = auth;
		this.registerdate = registerdate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(String registerdate) {
		this.registerdate = registerdate;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", auth=" + auth + ", registerdate="
				+ registerdate + "]";
	}
	
	
	
}
