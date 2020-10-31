package com.otsazo.colorfit.beans;

import java.util.ArrayList;

public class Results {
	
	String stringResult;
	int intResult;
	int status;
	MemberDTO mdto;
	DressDTO ddto;
	ArrayList<DressDTO> dlist;
	ArrayList<MemberDTO> mlist;
	ArrayList<ReplyDTO> rlist;
	
	public Results() {
		super();
	}

	public Results(String stringResult, int intResult, int status, MemberDTO mdto, DressDTO ddto,
			ArrayList<DressDTO> dlist, ArrayList<MemberDTO> mlist, ArrayList<ReplyDTO> rlist) {
		super();
		this.stringResult = stringResult;
		this.intResult = intResult;
		this.status = status;
		this.mdto = mdto;
		this.ddto = ddto;
		this.dlist = dlist;
		this.mlist = mlist;
		this.rlist = rlist;
	}

	public String getStringResult() {
		return stringResult;
	}

	public void setStringResult(String stringResult) {
		this.stringResult = stringResult;
	}

	public int getIntResult() {
		return intResult;
	}

	public void setIntResult(int intResult) {
		this.intResult = intResult;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public MemberDTO getMdto() {
		return mdto;
	}

	public void setMdto(MemberDTO mdto) {
		this.mdto = mdto;
	}

	public DressDTO getDdto() {
		return ddto;
	}

	public void setDdto(DressDTO ddto) {
		this.ddto = ddto;
	}

	public ArrayList<DressDTO> getDlist() {
		return dlist;
	}

	public void setDlist(ArrayList<DressDTO> dlist) {
		this.dlist = dlist;
	}

	public ArrayList<MemberDTO> getMlist() {
		return mlist;
	}

	public void setMlist(ArrayList<MemberDTO> mlist) {
		this.mlist = mlist;
	}

	public ArrayList<ReplyDTO> getRlist() {
		return rlist;
	}

	public void setRlist(ArrayList<ReplyDTO> rlist) {
		this.rlist = rlist;
	}
	
}
