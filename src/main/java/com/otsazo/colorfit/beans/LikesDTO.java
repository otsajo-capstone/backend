package com.otsazo.colorfit.beans;

public class LikesDTO {

	private int dress_uid;
	private int mb_uid;
	private int likes_type;
	
	public LikesDTO() {
		super();
	}

	public LikesDTO(int dress_uid, int mb_uid, int likes_type) {
		super();
		this.dress_uid = dress_uid;
		this.mb_uid = mb_uid;
		this.likes_type = likes_type;
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

	public int getLikes_type() {
		return likes_type;
	}

	public void setLikes_type(int likes_type) {
		this.likes_type = likes_type;
	}

}
