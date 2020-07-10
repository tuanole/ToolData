package com.mydu.letian.entity;

public class BoSoDTO {
	private String boName;
	private String boKey;
	private String boDes;
	public BoSoDTO() {
		super();
	}
	public BoSoDTO(String boName, String boKey, String boDes) {
		super();
		this.boName = boName;
		this.boKey = boKey;
		this.boDes = boDes;
	}
	public String getBoName() {
		return boName;
	}
	public void setBoName(String boName) {
		this.boName = boName;
	}
	public String getBoKey() {
		return boKey;
	}
	public void setBoKey(String boKey) {
		this.boKey = boKey;
	}
	public String getBoDes() {
		return boDes;
	}
	public void setBoDes(String boDes) {
		this.boDes = boDes;
	}
	@Override
	public String toString() {
		return "BoSoDTO [boName=" + boName + ", boKey=" + boKey + ", boDes=" + boDes + "]";
	}
	
	
}
