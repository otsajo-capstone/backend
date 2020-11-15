package com.otsazo.colorfit.beans;

public class ReplyMemberDTO {

	private int reply_uid;
	private int dress_uid;
	private int mb_uid;
	private String reply_content;
	private String reply_regDate;
	private String mb_id;
	private String mb_name;
	private int mb_type;
	
	public ReplyMemberDTO() {
		super();
	}

	public ReplyMemberDTO(int reply_uid, int dress_uid, int mb_uid, String reply_content, String reply_regDate,
			String mb_id, String mb_name, int mb_type) {
		super();
		this.reply_uid = reply_uid;
		this.dress_uid = dress_uid;
		this.mb_uid = mb_uid;
		this.reply_content = reply_content;
		this.reply_regDate = reply_regDate;
		this.mb_id = mb_id;
		this.mb_name = mb_name;
		this.mb_type = mb_type;
	}

	public int getReply_uid() {
		return reply_uid;
	}

	public void setReply_uid(int reply_uid) {
		this.reply_uid = reply_uid;
	}

	public int getDress_uid() {
		return dress_uid;
	}

	public void setDress_uid(int dress_uid) {
		this.dress_uid = dress_uid;
	}

	public int getMb_uid() {
		return mb_uid;
	}

	public void setMb_uid(int mb_uid) {
		this.mb_uid = mb_uid;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public String getReply_regDate() {
		return reply_regDate;
	}

	public void setReply_regDate(String reply_regDate) {
		this.reply_regDate = reply_regDate;
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

}
