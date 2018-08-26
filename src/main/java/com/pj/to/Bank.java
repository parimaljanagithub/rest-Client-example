package com.pj.to;

public class Bank {

	String bank_id;
	String bank_name;
	String account_type;
	String account_no;
	String corp_id;

	public Bank(String bank_id, String bank_name, String account_type, String account_no, String corp_id) {
		this.bank_id = bank_id;
		this.bank_name = bank_name;
		this.account_type = account_type;
		this.account_no = account_no;
		this.corp_id = corp_id;
	}

	public String getBank_id() {
		return bank_id;
	}

	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public String getCorp_id() {
		return corp_id;
	}

	public void setCorp_id(String corp_id) {
		this.corp_id = corp_id;
	}

}
