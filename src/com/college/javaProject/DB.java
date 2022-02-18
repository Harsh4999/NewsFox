package com.college.javaProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DB {
	public Connection getCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sys","root","Welll#");
			return con;
		}catch(Exception e) {
			return null;
		}
		
	}
	public List<User> getAll(){
		List<User> l = new ArrayList();
		try {
			Connection con = getCon();
			String select = "select * from User";
			PreparedStatement ps = con.prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getLong(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPasswordChanged(rs.getLong(5));
				l.add(u);
			}
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return l;
	}
	public User getOne(String username){
		try {
			Connection con = getCon();
			String select = "select * from User where username = ?";
			PreparedStatement ps = con.prepareStatement(select,
                    ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
			ps.setString(1,username);
			ResultSet rs = ps.executeQuery();
			int c=0;
			User u = new User();
			while(rs.next()) {
				c++;
				u.setId(rs.getLong(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPasswordChanged(rs.getLong(5));
			}
			if(c>0) {
				con.close();
				return u;
			}
			return null;
				
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public User add(User u) {
		try {
			Connection con = getCon();
			String insert = "insert into User values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insert);
			List<User> l1 = getAll();
			long id = l1.size()+1;
			ps.setLong(1,id);
			ps.setString(2,u.getUsername());
			ps.setString(3,u.getPassword());
			ps.setString(4,u.getEmail());
			ps.setLong(5, 0);
			ps.execute();
			con.close();
			u.setId(id);
			return u;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public boolean validate(String username,String password) {
		try {
			User u  = getOne(username);
			if(u!=null) {
				if(u.getPassword().equals(password)) {
					return true;
				}
			}
			return false;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	public boolean checkUsername(String username) {
		// TODO Auto-generated method stub
		try {
			User u  = getOne(username);
			if(u!=null) {
				return false;
			}
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
