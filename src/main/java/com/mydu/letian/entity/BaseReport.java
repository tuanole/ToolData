package com.mydu.letian.entity;

public class BaseReport {

	private String id;
	private String sumDiemLo;
	private String sumDiemWinLo;
	private String sumTienLo;
	private String sunTienWinLo;
	private String chotLo;
	private String sumTienDe;
	private String sumTienWinDe;
	private String chotDe;
	private String total;
	private String hh;
	public BaseReport() {
		super();
	}
	public BaseReport(String id, String sumDiemLo, String sumDiemWinLo, String sumTienLo, String sunTienWinLo,
			String chotLo, String sumTienDe, String sumTienWinDe, String chotDe, String total, String hh) {
		super();
		this.id = id;
		this.sumDiemLo = sumDiemLo;
		this.sumDiemWinLo = sumDiemWinLo;
		this.sumTienLo = sumTienLo;
		this.sunTienWinLo = sunTienWinLo;
		this.chotLo = chotLo;
		this.sumTienDe = sumTienDe;
		this.sumTienWinDe = sumTienWinDe;
		this.chotDe = chotDe;
		this.total = total;
		this.hh = hh;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSumDiemLo() {
		return sumDiemLo;
	}
	public void setSumDiemLo(String sumDiemLo) {
		this.sumDiemLo = sumDiemLo;
	}
	public String getSumDiemWinLo() {
		return sumDiemWinLo;
	}
	public void setSumDiemWinLo(String sumDiemWinLo) {
		this.sumDiemWinLo = sumDiemWinLo;
	}
	public String getSumTienLo() {
		return sumTienLo;
	}
	public void setSumTienLo(String sumTienLo) {
		this.sumTienLo = sumTienLo;
	}
	public String getSunTienWinLo() {
		return sunTienWinLo;
	}
	public void setSunTienWinLo(String sunTienWinLo) {
		this.sunTienWinLo = sunTienWinLo;
	}
	public String getChotLo() {
		return chotLo;
	}
	public void setChotLo(String chotLo) {
		this.chotLo = chotLo;
	}
	public String getSumTienDe() {
		return sumTienDe;
	}
	public void setSumTienDe(String sumTienDe) {
		this.sumTienDe = sumTienDe;
	}
	public String getSumTienWinDe() {
		return sumTienWinDe;
	}
	public void setSumTienWinDe(String sumTienWinDe) {
		this.sumTienWinDe = sumTienWinDe;
	}
	public String getChotDe() {
		return chotDe;
	}
	public void setChotDe(String chotDe) {
		this.chotDe = chotDe;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getHh() {
		return hh;
	}
	public void setHh(String hh) {
		this.hh = hh;
	}
	@Override
	public String toString() {
		return "BaseReport [id=" + id + ", sumDiemLo=" + sumDiemLo + ", sumDiemWinLo=" + sumDiemWinLo + ", sumTienLo="
				+ sumTienLo + ", sunTienWinLo=" + sunTienWinLo + ", chotLo=" + chotLo + ", sumTienDe=" + sumTienDe
				+ ", sumTienWinDe=" + sumTienWinDe + ", chotDe=" + chotDe + ", total=" + total + ", hh=" + hh + "]";
	}
	
	
}
