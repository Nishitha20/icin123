package org.capstone.model;

public class Request 
{
	private String cid;
	private String acname;
	private String type;
	private String acnum;
	private String address;
	private String mobile;
	private String rblock;
	
	public String getRblock() {
		return rblock;
	}
	public void setRblock(String rblock) {
		this.rblock = rblock;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getAcname() {
		return acname;
	}
	public void setAcname(String acname) {
		this.acname = acname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAcnum() {
		return acnum;
	}
	public void setAcnum(String acnum) {
		this.acnum = acnum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Request [cid=" + cid + ", acname=" + acname + ", type=" + type + ", acnum=" + acnum + ", address="
				+ address + ", mobile=" + mobile + ", rblock=" + rblock + "]";
	}
	
}
