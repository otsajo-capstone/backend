package com.otsazo.colorfit.beans.dao;

import org.apache.ibatis.annotations.Param;
import com.otsazo.colorfit.beans.MemberDTO;

public interface MemberDAO {

	public int insertMember(@Param("dto") MemberDTO dto);
	public int checkId(String mb_id);
	public int checkEmail(String mb_email);
	public int selectUidById(String mb_id);
	public String selectPwById(String mb_id);

	public MemberDTO selectId(String mb_name, String mb_email);
	public MemberDTO selectPw(String mb_id, String mb_name, String mb_email);
	public int updatePw(String mb_pw, String mb_id);
	public MemberDTO selectMemberByUid(int mb_uid);
	public int updateMemberByUid(@Param("dto") MemberDTO dto);
	
}
