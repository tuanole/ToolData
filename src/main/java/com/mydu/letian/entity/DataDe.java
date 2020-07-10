package com.mydu.letian.entity;

import java.util.Comparator;

public class DataDe implements Comparator<DataDe>{
	private String so;
	private int tienD;
	private int tienT;
	private int hang;
	public DataDe() {
		super();
	}
	public DataDe(String so, int tienD, int tienT, int hang) {
		super();
		this.so = so;
		this.tienD = tienD;
		this.tienT = tienT;
		this.hang = hang;
	}
	public String getSo() {
		return so;
	}
	public void setSo(String so) {
		this.so = so;
	}
	public int getTienD() {
		return tienD;
	}
	public void setTienD(int tienD) {
		this.tienD = tienD;
	}
	public int getTienT() {
		return tienT;
	}
	public void setTienT(int tienT) {
		this.tienT = tienT;
	}
	public int getHang() {
		return hang;
	}
	public void setHang(int hang) {
		this.hang = hang;
	}
	@Override
	public String toString() {
		return "DataDe [so=" + so + ", tienD=" + tienD + ", tienT=" + tienT + ", hang=" + hang + "]";
	}
	@Override
	public int compare(DataDe s1, DataDe s2) {
		if (s1.tienD == s2.tienD)
			return 0;
		else if (s1.tienD < s2.tienD)
			return 1;
		else
			return -1;
	}
}
