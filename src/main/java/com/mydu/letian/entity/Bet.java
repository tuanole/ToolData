package com.mydu.letian.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BET")
public class Bet implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BET_ID")
	private int betId;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BASE_ID_IN")
	private Base baseIn;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BASE_ID_OUT")
	private Base baseOut;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
	private User user;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TYPE_ID")
	private BetType betType;
	
	@Column(name = "BET_STATUS")
	private int betStatus;
	
	@Column(name = "BET_KEY")
	private String betKey;
	
	@Column(name = "AMOUNT")
	private int amount;
	
	@Column(name = "BET_DATE")
	private Date betDate;
	
	@Column(name = "DELETE_FLAG")
	private int deleteFlag;
	
	public Bet() {
		super();
	}

	public Bet(int betId, Base baseIn, Base baseOut, User user, BetType betType, int betStatus, String betKey,
			int amount, Date betDate, int deleteFlag) {
		super();
		this.betId = betId;
		this.baseIn = baseIn;
		this.baseOut = baseOut;
		this.user = user;
		this.betType = betType;
		this.betStatus = betStatus;
		this.betKey = betKey;
		this.amount = amount;
		this.betDate = betDate;
		this.deleteFlag = deleteFlag;
	}

	public int getBetId() {
		return betId;
	}

	public void setBetId(int betId) {
		this.betId = betId;
	}

	public Base getBaseIn() {
		return baseIn;
	}

	public void setBaseIn(Base baseIn) {
		this.baseIn = baseIn;
	}

	public Base getBaseOut() {
		return baseOut;
	}

	public void setBaseOut(Base baseOut) {
		this.baseOut = baseOut;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BetType getBetType() {
		return betType;
	}

	public void setBetType(BetType betType) {
		this.betType = betType;
	}

	public int getBetStatus() {
		return betStatus;
	}

	public void setBetStatus(int betStatus) {
		this.betStatus = betStatus;
	}

	public String getBetKey() {
		return betKey;
	}

	public void setBetKey(String betKey) {
		this.betKey = betKey;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getBetDate() {
		return betDate;
	}

	public void setBetDate(Date betDate) {
		this.betDate = betDate;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Override
	public String toString() {
		return "Bet [betId=" + betId + ", baseIn=" + baseIn + ", baseOut=" + baseOut + ", user=" + user + ", betType="
				+ betType + ", betStatus=" + betStatus + ", betKey=" + betKey + ", amount=" + amount + ", betDate="
				+ betDate + ", deleteFlag=" + deleteFlag + "]";
	}
	
	
	
}
