package com.otsazo.colorfit.beans;

public class ReplyDTO {

	private int reply_uid;
	private int dress_uid;
	private int mb_uid;
	private String reply_content;
	private String reply_regDate;
	
	public ReplyDTO() {
		super();
	}

	public ReplyDTO(int reply_uid, int dress_uid, int mb_uid, String reply_content, String reply_regDate) {
		super();
		this.reply_uid = reply_uid;
		this.dress_uid = dress_uid;
		this.mb_uid = mb_uid;
		this.reply_content = reply_content;
		this.reply_regDate = reply_regDate;
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

}
