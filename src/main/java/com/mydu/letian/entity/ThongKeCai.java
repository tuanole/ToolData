package com.mydu.letian.entity;

public class ThongKeCai {
	private String loai;
	private String sumDiem;
	private String sumTien;
	private String sumDiemTrung;
	private String sumTienTrung;
	private String sumLai;
	public ThongKeCai() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ThongKeCai(String loai, String sumDiem, String sumTien, String sumDiemTrung, String sumTienTrung,
			String sumLai) {
		super();
		this.loai = loai;
		this.sumDiem = sumDiem;
		this.sumTien = sumTien;
		this.sumDiemTrung = sumDiemTrung;
		this.sumTienTrung = sumTienTrung;
		this.sumLai = sumLai;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	public String getSumDiem() {
		return sumDiem;
	}
	public void setSumDiem(String sumDiem) {
		this.sumDiem = sumDiem;
	}
	public String getSumTien() {
		return sumTien;
	}
	public void setSumTien(String sumTien) {
		this.sumTien = sumTien;
	}
	public String getSumDiemTrung() {
		return sumDiemTrung;
	}
	public void setSumDiemTrung(String sumDiemTrung) {
		this.sumDiemTrung = sumDiemTrung;
	}
	public String getSumTienTrung() {
		return sumTienTrung;
	}
	public void setSumTienTrung(String sumTienTrung) {
		this.sumTienTrung = sumTienTrung;
	}
	public String getSumLai() {
		return sumLai;
	}
	public void setSumLai(String sumLai) {
		this.sumLai = sumLai;
	}
	@Override
	public String toString() {
		return "ThongKeCai [loai=" + loai + ", sumDiem=" + sumDiem + ", sumTien=" + sumTien + ", sumDiemTrung="
				+ sumDiemTrung + ", sumTienTrung=" + sumTienTrung + ", sumLai=" + sumLai + "]";
	}
	
	
}
