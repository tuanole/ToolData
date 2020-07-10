package com.mydu.letian.entity.lo;

public class Lo {
	private String soDanh;
	private String diem;
	private String baseIn;
	private String baseOut;
	private String user;
	
	public Lo() {
		super();
	}

	public Lo(String soDanh, String diem, String baseIn, String baseOut, String user) {
		super();
		this.soDanh = soDanh;
		this.diem = diem;
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

	public String getDiem() {
		return diem;
	}

	public void setDiem(String diem) {
		this.diem = diem;
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
		return "Lo [soDanh=" + soDanh + ", diem=" + diem + ", baseIn=" + baseIn + ", baseOut=" + baseOut + ", user="
				+ user + "]";
	}

	
}
