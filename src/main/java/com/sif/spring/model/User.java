package com.sif.spring.model;


import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class User {
	@Id
	private String username;
	private String password;
	private String email;
	private String profession;

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

    public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

}
