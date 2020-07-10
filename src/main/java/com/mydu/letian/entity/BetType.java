package com.mydu.letian.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BETTYPE")
public class BetType implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "TYPE_ID")
	private int typeId;
	
	@Column(name = "TYPE_NAME")
	private String typeName;
	
	@Column(name = "TYPE_DES")
	private String typeDes;
	
	@Column(name = "WIN_RATE")
	private double winRate;
	
	@Column(name = "KIND")
	private int kind;
	
	public BetType() {
		super();
	}
	
	

	public BetType(int typeId) {
		super();
		this.typeId = typeId;
	}



	public BetType(int typeId, String typeName, String typeDes, double winRate, int kind) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.typeDes = typeDes;
		this.winRate = winRate;
		this.kind = kind;
	}



	public int getTypeId() {
		return typeId;
	}



	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}



	public String getTypeName() {
		return typeName;
	}



	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}



	public String getTypeDes() {
		return typeDes;
	}



	public void setTypeDes(String typeDes) {
		this.typeDes = typeDes;
	}



	public double getWinRate() {
		return winRate;
	}



	public void setWinRate(double winRate) {
		this.winRate = winRate;
	}



	public int getKind() {
		return kind;
	}



	public void setKind(int kind) {
		this.kind = kind;
	}



	@Override
	public String toString() {
		return "BetType [typeId=" + typeId + ", typeName=" + typeName + ", typeDes=" + typeDes + ", winRate=" + winRate
				+ ", kind=" + kind + "]";
	}

	
	
}
