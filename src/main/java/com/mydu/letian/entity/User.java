package com.mydu.letian.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "USER_PHONE")
	private String userPhone;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "USER_DES")
	private String userDes;
	
	@Column(name = "RANK")
	private int rank;
	
	public User() {
		super();
	}

	public User(String user_id, String user_phone, String user_name, String user_des, int rank) {
		super();
		this.userId = user_id;
		this.userPhone = user_phone;
		this.userName = user_name;
		this.userDes = user_des;
		this.rank = rank;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String user_id) {
		this.userId = user_id;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String user_phone) {
		this.userPhone = user_phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String user_name) {
		this.userName = user_name;
	}

	public String getUserDes() {
		return userDes;
	}

	public void setUserDes(String user_des) {
		this.userDes = user_des;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "User [user_id=" + userId + ", user_phone=" + userPhone + ", user_name=" + userName + ", user_des="
				+ userDes + ", rank=" + rank + "]";
	}
	
	
}
