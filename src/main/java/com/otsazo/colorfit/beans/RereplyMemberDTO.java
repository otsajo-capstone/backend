package com.otsazo.colorfit.beans;

public class RereplyMemberDTO {

	private int rereply_uid;
	private int reply_uid;
	private int mb_uid;
	private String rereply_content;
	private String rereply_regDate;
	private String mb_id;
	private String mb_name;
	private int mb_type;
	private int dress_uid;
	
	
	public RereplyMemberDTO() {
		super();
	}

	public RereplyMemberDTO(int rereply_uid, int reply_uid, int mb_uid, String rereply_content, String rereply_regDate,
			String mb_id, String mb_name, int mb_type, int dress_uid) {
		super();
		this.rereply_uid = rereply_uid;
		this.reply_uid = reply_uid;
		this.mb_uid = mb_uid;
		this.rereply_content = rereply_content;
		this.rereply_regDate = rereply_regDate;
		this.mb_id = mb_id;
		this.mb_name = mb_name;
		this.mb_type = mb_type;
		this.dress_uid = dress_uid;
	}

	public int getRereply_uid() {
		return rereply_uid;
	}

	public void setRereply_uid(int rereply_uid) {
		this.rereply_uid = rereply_uid;
	}

	public int getReply_uid() {
		return reply_uid;
	}

	public void setReply_uid(int reply_uid) {
		this.reply_uid = reply_uid;
	}

	public int getMb_uid() {
		return mb_uid;
	}

	public void setMb_uid(int mb_uid) {
		this.mb_uid = mb_uid;
	}

	public String getRereply_content() {
		return rereply_content;
	}

	public void setRereply_content(String rereply_content) {
		this.rereply_content = rereply_content;
	}

	public String getRereply_regDate() {
		return rereply_regDate;
	}

	public void setRereply_regDate(String rereply_regDate) {
		this.rereply_regDate = rereply_regDate;
	}

	public String getMb_id() {
		return mb_id;
	}

	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}

	public String getMb_name() {
		return mb_name;
	}

	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}

	public int getMb_type() {
		return mb_type;
	}

	public void setMb_type(int mb_type) {
		this.mb_type = mb_type;
	}

	public int getDress_uid() {
		return dress_uid;
	}

	public void setDress_uid(int dress_uid) {
		this.dress_uid = dress_uid;
	}

}
