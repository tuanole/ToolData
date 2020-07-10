package com.mydu.letian.entity;

import java.util.Comparator;

public class DataLo implements Comparator<DataLo>{

	private String so;
	private String diem;
	private String soLuot;
	private String tong;
	private int hang;
	public DataLo() {
		super();
	}
	public DataLo(String so, String diem, String soLuot, String tong, int hang) {
		super();
		this.so = so;
		this.diem = diem;
		this.soLuot = soLuot;
		this.tong = tong;
		this.hang = hang;
	}
	public String getSo() {
		return so;
	}
	public void setSo(String so) {
		this.so = so;
	}
	public String getDiem() {
		return diem;
	}
	public void setDiem(String diem) {
		this.diem = diem;
	}
	public String getSoLuot() {
		return soLuot;
	}
	public void setSoLuot(String soLuot) {
		this.soLuot = soLuot;
	}
	public String getTong() {
		return tong;
	}
	public void setTong(String tong) {
		this.tong = tong;
	}
	public int getHang() {
		return hang;
	}
	public void setHang(int hang) {
		this.hang = hang;
	}
	@Override
	public String toString() {
		return "DataLo [so=" + so + ", diem=" + diem + ", soLuot=" + soLuot + ", tong=" + tong + ", hang=" + hang + "]";
	}
	@Override
	public int compare(DataLo s1, DataLo s2) {
		if (Integer.parseInt(s1.diem) == Integer.parseInt(s2.diem))
			return 0;
		else if (Integer.parseInt(s1.diem) < Integer.parseInt(s2.diem))
			return 1;
		else
			return -1;
	}
	
	
}
