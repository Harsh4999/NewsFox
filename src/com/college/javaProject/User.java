package com.college.javaProject;

public class User {
	private Long id;
	private String username;
	private String password;
	private String email;
	private Long passwordChanged;
	
	public User() {}

	public User(String username, String password, String email, Long passwordChanged) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.passwordChanged = passwordChanged;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPasswordChanged() {
		return passwordChanged;
	}

	public void setPasswordChanged(Long passwordChanged) {
		this.passwordChanged = passwordChanged;
	}
	
}
