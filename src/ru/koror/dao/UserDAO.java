package ru.koror.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.koror.model.User;
import ru.koror.util.Database;

public class UserDAO {

	private Connection con;
	
	public UserDAO () {
		con = Database.getConnection();
	}
	
	public void addUser(User user)
	{
		try {
			PreparedStatement stmt = con.prepareStatement("insert into users(nickname, password, email, datereg) values(?,?,?,?)");
			stmt.setString(1, user.getNickname());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			stmt.setDate(4, User.getDateRegNow());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addUser(String nick, String pass, String email)
	{
		try {
			PreparedStatement stmt = con.prepareStatement("insert into users(nickname, password, email, datereg) values(?,?,?,?)");
			stmt.setString(1, nick);
			stmt.setString(2, pass);
			stmt.setString(3, email);
			stmt.setDate(4, User.getDateRegNow());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int userId)
	{
		try {
			PreparedStatement stmt = con.prepareStatement("delete from users where id=?");
			stmt.setInt(1, userId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void updateUser(String nickname, String pass, int id)
	{
		try {
			PreparedStatement stmt = con.prepareStatement("update users set nickname=?, password=? where id=?");
			stmt.setString(1, nickname);
			stmt.setString(2, pass);
			stmt.setInt(3, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<User> getAllUsers()
	{
		List<User> users = new ArrayList<>();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("select * from users");
			ResultSet result = stmt.executeQuery();
			while(result.next())
			{
				User user = new User();
				user.setId(result.getInt(1));
				user.setNickname(result.getString(2));
				user.setPassword(result.getString(3));
				user.setEmail(result.getString(4));
				user.setDateReg(result.getDate(5));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	public User getUserById(int id)
	{
		PreparedStatement stmt;
		
		User user = new User();
		try {
			stmt = con.prepareStatement("select * from users where id=?");
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			while(result.next())
			{
			user.setId(result.getInt(1));
			user.setNickname(result.getString(2));
			user.setPassword(result.getString(3));
			user.setEmail(result.getString(4));
			user.setDateReg(result.getDate(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return user;
	}
}
