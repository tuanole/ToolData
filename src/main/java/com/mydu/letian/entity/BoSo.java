package com.mydu.letian.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "boso")
public class BoSo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "BO_NAME")
	private String boName;
	
	@Column(name = "BO_KEY")
	private String boKey;
	
	@Column(name = "BO_DES")
	private String boDes;

	public BoSo() {
		super();
	}

	public BoSo(Long id, String boName, String boKey, String boDes) {
		super();
		this.id = id;
		this.boName = boName;
		this.boKey = boKey;
		this.boDes = boDes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBoName() {
		return boName;
	}

	public void setBoName(String boName) {
		this.boName = boName;
	}

	public String getBoKey() {
		return boKey;
	}

	public void setBoKey(String boKey) {
		this.boKey = boKey;
	}

	public String getBoDes() {
		return boDes;
	}

	public void setBoDes(String boDes) {
		this.boDes = boDes;
	}

	@Override
	public String toString() {
		return "BoSo [id=" + id + ", boName=" + boName + ", boKey=" + boKey + ", boDes=" + boDes + "]";
	}
	
	

}
