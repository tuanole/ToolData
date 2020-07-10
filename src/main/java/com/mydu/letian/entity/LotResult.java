package com.mydu.letian.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "LOTRESULT")
public class LotResult implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "LOT_DATE")
	private Date lotDate;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOT_ID")
	private Long lotId;
	
	@Column(name = "LOT_RANK")
	private int lotRank;
	
	@Column(name = "LOT_KEY")
	private String lotKey;
	
	@Column(name = "LOT_PRIZE")
	private int lotPrize;

	public LotResult() {
		super();
	}

	public LotResult(Date lotDate, Long lotId, int lotRank, String lotKey, int lotPrize) {
		super();
		this.lotDate = lotDate;
		this.lotId = lotId;
		this.lotRank = lotRank;
		this.lotKey = lotKey;
		this.lotPrize = lotPrize;
	}

	public Date getLotDate() {
		return lotDate;
	}

	public void setLotDate(Date lotDate) {
		this.lotDate = lotDate;
	}

	public Long getLotId() {
		return lotId;
	}

	public void setLotId(Long lotId) {
		this.lotId = lotId;
	}

	public int getLotRank() {
		return lotRank;
	}

	public void setLotRank(int lotRank) {
		this.lotRank = lotRank;
	}

	public String getLotKey() {
		return lotKey;
	}

	public void setLotKey(String lotKey) {
		this.lotKey = lotKey;
	}

	public int getLotPrize() {
		return lotPrize;
	}

	public void setLotPrize(int lotPrize) {
		this.lotPrize = lotPrize;
	}

	@Override
	public String toString() {
		return "LotResult [lotDate=" + lotDate + ", lotId=" + lotId + ", lotRank=" + lotRank + ", lotKey=" + lotKey
				+ ", lotPrize=" + lotPrize + "]";
	}
	
	
}
