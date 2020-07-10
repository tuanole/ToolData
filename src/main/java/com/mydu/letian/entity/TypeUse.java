package com.mydu.letian.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TYPES")
public class TypeUse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TYPE_ID")
	private BetType betType;
	
	@Column(name = "TYPE_NAME")
	private String typeName;
	
	@Column(name = "TYPE_DES")
	private String typeDes;
	
	@Column(name = "TYPE_VALUE")
	private String typeValue;

	public TypeUse() {
		super();
	}

	public TypeUse(int id, BetType betType, String typeName, String typeDes, String typeValue) {
		super();
		this.id = id;
		this.betType = betType;
		this.typeName = typeName;
		this.typeDes = typeDes;
		this.typeValue = typeValue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BetType getBetType() {
		return betType;
	}

	public void setBetType(BetType betType) {
		this.betType = betType;
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

	public String getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Type [id=" + id + ", betType=" + betType + ", typeName=" + typeName + ", typeDes=" + typeDes
				+ ", typeValue=" + typeValue + "]";
	}
	
	

}
