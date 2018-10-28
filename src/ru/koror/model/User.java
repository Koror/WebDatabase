package ru.koror.model;

import java.util.Date;

public class User {
	private int id;
	private String nickname,password,email;
	private Date dateReg;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateReg()
	{
		return dateReg;
	}
	public static java.sql.Date getDateRegNow() {
		return new java.sql.Date(System.currentTimeMillis());
	}
	public void setDateReg(Date dateReg) {
		this.dateReg = dateReg;
	}
}
