package com.otsazo.colorfit.beans;

public class MemberDTO {

	private int mb_uid;
	private String mb_id;
	private String mb_pw;
	private String mb_name;
	private String mb_email;
	private String mb_regDate;
	private int mb_type;
	
	public MemberDTO() {
		super();
	}
	
	public MemberDTO(int mb_uid, String mb_id, String mb_pw, String mb_name, String mb_email, String mb_regDate,
			int mb_type) {
		super();
		this.mb_uid = mb_uid;
		this.mb_id = mb_id;
		this.mb_pw = mb_pw;
		this.mb_name = mb_name;
		this.mb_email = mb_email;
		this.mb_regDate = mb_regDate;
		this.mb_type = mb_type;
	}
	public int getMb_uid() {
		return mb_uid;
	}
	public void setMb_uid(int mb_uid) {
		this.mb_uid = mb_uid;
	}
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public String getMb_pw() {
		return mb_pw;
	}
	public void setMb_pw(String mb_pw) {
		this.mb_pw = mb_pw;
	}
	public String getMb_name() {
		return mb_name;
	}
	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}
	public String getMb_email() {
		return mb_email;
	}
	public void setMb_email(String mb_email) {
		this.mb_email = mb_email;
	}
	public String getMb_regDate() {
		return mb_regDate;
	}
	public void setMb_regDate(String mb_regDate) {
		this.mb_regDate = mb_regDate;
	}
	public int getMb_type() {
		return mb_type;
	}
	public void setMb_type(int mb_type) {
		this.mb_type = mb_type;
	}

}
