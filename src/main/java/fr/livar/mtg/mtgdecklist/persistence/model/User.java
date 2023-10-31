package fr.livar.mtg.mtgdecklist.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mtg_user")
public class User {
	@Id @GeneratedValue private int userId;
	private String userName;
	private String userPassword;
	private String defaultLangage;
	private String userRole;
	
	public User() {}
	public User(String userName, String userPassword, String defaultLangage) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.defaultLangage = defaultLangage;
		this.userRole = "USER";
	}

	public int getUserId() {
		return userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getDefaultLangage() {
		return defaultLangage;
	}
	
	public void setDefaultLangage(String defaultLangage) {
		this.defaultLangage = defaultLangage;
	}
	
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
