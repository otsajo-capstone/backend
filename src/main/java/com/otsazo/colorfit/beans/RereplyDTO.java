package com.otsazo.colorfit.beans;

public class RereplyDTO {

	private int rereply_uid;
	private int reply_uid;
	private int mb_uid;
	private String rereply_content;
	private String rereply_regDate;
	
	public RereplyDTO() {
		super();
	}

	public RereplyDTO(int rereply_uid, int reply_uid, int mb_uid, String rereply_content, String rereply_regDate) {
		super();
		this.rereply_uid = rereply_uid;
		this.reply_uid = reply_uid;
		this.mb_uid = mb_uid;
		this.rereply_content = rereply_content;
		this.rereply_regDate = rereply_regDate;
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

	
}
