package com.otsazo.colorfit.beans;

public class DressDTO {

	private int dress_uid;
	private int mb_uid;
	private int spring;
	private int summer;
	private int autumn;
	private int winter;
	private String color;
	private String dress_link;
	private String dress_name;
	private String dress_memo;
	private String dress_regDate;
	private String dress_img_org;
	private String dress_img_sav;
	private int share_type;
	private int likes;
	private String result;
	
	public DressDTO() {
		super();
	}

	public DressDTO(int dress_uid, int mb_uid, int spring, int summer, int autumn, int winter, String color,
			String dress_link, String dress_name, String dress_memo, String dress_regDate, String dress_img_org,
			String dress_img_sav, int share_type, int likes, String result) {
		super();
		this.dress_uid = dress_uid;
		this.mb_uid = mb_uid;
		this.spring = spring;
		this.summer = summer;
		this.autumn = autumn;
		this.winter = winter;
		this.color = color;
		this.dress_link = dress_link;
		this.dress_name = dress_name;
		this.dress_memo = dress_memo;
		this.dress_regDate = dress_regDate;
		this.dress_img_org = dress_img_org;
		this.dress_img_sav = dress_img_sav;
		this.share_type = share_type;
		this.likes = likes;
		this.result = result;
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

	public int getSpring() {
		return spring;
	}

	public void setSpring(int spring) {
		this.spring = spring;
	}

	public int getSummer() {
		return summer;
	}

	public void setSummer(int summer) {
		this.summer = summer;
	}

	public int getAutumn() {
		return autumn;
	}

	public void setAutumn(int autumn) {
		this.autumn = autumn;
	}

	public int getWinter() {
		return winter;
	}

	public void setWinter(int winter) {
		this.winter = winter;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDress_name() {
		return dress_name;
	}

	public void setDress_name(String dress_name) {
		this.dress_name = dress_name;
	}

	public String getDress_memo() {
		return dress_memo;
	}

	public void setDress_memo(String dress_memo) {
		this.dress_memo = dress_memo;
	}

	public String getDress_regDate() {
		return dress_regDate;
	}

	public void setDress_regDate(String dress_regDate) {
		this.dress_regDate = dress_regDate;
	}

	public int getShare_type() {
		return share_type;
	}

	public void setShare_type(int share_type) {
		this.share_type = share_type;
	}

	public String getDress_img_org() {
		return dress_img_org;
	}

	public void setDress_img_org(String dress_img_org) {
		this.dress_img_org = dress_img_org;
	}

	public String getDress_img_sav() {
		return dress_img_sav;
	}

	public void setDress_img_sav(String dress_img_sav) {
		this.dress_img_sav = dress_img_sav;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getDress_link() {
		return dress_link;
	}

	public void setDress_link(String dress_link) {
		this.dress_link = dress_link;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}
