package com.mydu.letian.entity.de;

public class De {
	private String soDanh;
	private String tien;
	private String baseIn;
	private String baseOut;
	private String user;
	
	public De() {
		super();
	}

	public De(String soDanh, String tien, String baseIn, String baseOut, String user) {
		super();
		this.soDanh = soDanh;
		this.tien = tien;
		this.baseIn = baseIn;
		this.baseOut = baseOut;
		this.user = user;
	}

	public String getSoDanh() {
		return soDanh;
	}

	public void setSoDanh(String soDanh) {
		this.soDanh = soDanh;
	}

	public String getTien() {
		return tien;
	}

	public void setTien(String tien) {
		this.tien = tien;
	}

	public String getBaseIn() {
		return baseIn;
	}

	public void setBaseIn(String baseIn) {
		this.baseIn = baseIn;
	}

	public String getBaseOut() {
		return baseOut;
	}

	public void setBaseOut(String baseOut) {
		this.baseOut = baseOut;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "De [soDanh=" + soDanh + ", tien=" + tien + ", baseIn=" + baseIn + ", baseOut=" + baseOut + ", user="
				+ user + "]";
	}

	

}
