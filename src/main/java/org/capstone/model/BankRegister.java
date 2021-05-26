package org.capstone.model;

public class BankRegister 
{
	private String fname;
	private String lname;
	private String uname;
	private String psswd;
	private String dob;
	private String gender;
	private String email;
	private String mobile;
	private String address;
	private String type;
	private String acnum;
	private String cid;
	private int balance;
	private String block;
	private String wblock;
	private String dblock;
	private String tblock;
	
	public String getWblock() {
		return wblock;
	}
	public void setWblock(String wblock) {
		this.wblock = wblock;
	}
	public String getDblock() {
		return dblock;
	}
	public void setDblock(String dblock) {
		this.dblock = dblock;
	}
	public String getTblock() {
		return tblock;
	}
	public void setTblock(String tblock) {
		this.tblock = tblock;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getAcnum() {
		return acnum;
	}
	public void setAcnum(String acnum) {
		this.acnum = acnum;
	}
	public String getPsswd() {
		return psswd;
	}
	public void setPsswd(String psswd) {
		this.psswd = psswd;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "BankRegister [fname=" + fname + ", lname=" + lname + ", uname=" + uname + ", psswd=" + psswd + ", dob="
				+ dob + ", gender=" + gender + ", email=" + email + ", mobile=" + mobile + ", address=" + address
				+ ", type=" + type + ", acnum=" + acnum + ", cid=" + cid + ", balance=" + balance + "]";
	}
	
}
