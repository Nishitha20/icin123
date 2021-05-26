package org.capstone.model;

public class Transaction 
{
	private String cid;
	private String from;
	private String to;
	private String date;
	private String time;
	private int pbal;
	private int amt;
	private String tid;
	private String typetid;
	private String type;
	private int cbal;
	
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTypetid() {
		return typetid;
	}
	public void setTypetid(String typetid) {
		this.typetid = typetid;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPbal() {
		return pbal;
	}
	public void setPbal(int pbal) {
		this.pbal = pbal;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCbal() {
		return cbal;
	}
	public void setCbal(int cbal) {
		this.cbal = cbal;
	}
	@Override
	public String toString() {
		return "Transaction [to=" + to + ", date=" + date + ", pbal=" + pbal + ", amt=" + amt + ", tid=" + tid
				+ ", type=" + type + ", cbal=" + cbal + "]";
	}
	
	
}
