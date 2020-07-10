package com.mydu.letian.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BASES")
public class Base implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "base_id")
	private Long baseId;
	
	@Column(name = "BASE_NAME")
	private String baseName;
	
	@Column(name = "BASE_DES")
	private String baseDes;
	
	@Column(name = "RATE_L_IN")
	private double rateLIn;
	
	@Column(name = "RATE_L_OUT")
	private double rateLOut;
	
	@Column(name = "RATE_D")
	private double rateD;
	
	@Column(name = "RATE_X2")
	private double rateX2;
	
	@Column(name = "RATE_X3")
	private double rateX3;
	
	@Column(name = "RATE_X4")
	private double rateX4;
	
	@Column(name = "RATE_3C")
	private double rate3c;
	
	public Base() {
		super();
	}

	
	
	public Base(Long baseId) {
		super();
		this.baseId = baseId;
	}



	public Base(Long baseId, String baseName, String baseDes, double rateLIn, double rateLOut, double rateD, double rateX2,
			double rateX3, double rateX4, double rate3c) {
		super();
		this.baseId = baseId;
		this.baseName = baseName;
		this.baseDes = baseDes;
		this.rateLIn = rateLIn;
		this.rateLOut = rateLOut;
		this.rateD = rateD;
		this.rateX2 = rateX2;
		this.rateX3 = rateX3;
		this.rateX4 = rateX4;
		this.rate3c = rate3c;
	}



	public Long getBaseId() {
		return baseId;
	}



	public void setBaseId(Long baseId) {
		this.baseId = baseId;
	}



	public String getBaseName() {
		return baseName;
	}



	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}



	public String getBaseDes() {
		return baseDes;
	}



	public void setBaseDes(String baseDes) {
		this.baseDes = baseDes;
	}



	public double getRateLIn() {
		return rateLIn;
	}



	public void setRateLIn(double rateLD) {
		this.rateLIn = rateLD;
	}



	public double getRateLOut() {
		return rateLOut;
	}



	public void setRateLOut(double rateLF) {
		this.rateLOut = rateLF;
	}



	public double getRateD() {
		return rateD;
	}



	public void setRateD(double rateD) {
		this.rateD = rateD;
	}



	public double getRateX2() {
		return rateX2;
	}



	public void setRateX2(double rateX2) {
		this.rateX2 = rateX2;
	}



	public double getRateX3() {
		return rateX3;
	}



	public void setRateX3(double rateX3) {
		this.rateX3 = rateX3;
	}



	public double getRateX4() {
		return rateX4;
	}



	public void setRateX4(double rateX4) {
		this.rateX4 = rateX4;
	}



	public double getRate3c() {
		return rate3c;
	}



	public void setRate3c(double rate3c) {
		this.rate3c = rate3c;
	}



	@Override
	public String toString() {
		return "Base [baseId=" + baseId + ", baseName=" + baseName + ", baseDes=" + baseDes + ", rateLIn=" + rateLIn
				+ ", rateLOut=" + rateLOut + ", rateD=" + rateD + ", rateX2=" + rateX2 + ", rateX3=" + rateX3 + ", rateX4="
				+ rateX4 + ", rate3c=" + rate3c + "]";
	}

	
	
	
}
