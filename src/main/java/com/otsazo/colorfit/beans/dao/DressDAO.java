package com.otsazo.colorfit.beans.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import com.otsazo.colorfit.beans.DressDTO;
import com.otsazo.colorfit.beans.ReplyDTO;

public interface DressDAO {

	public int insertDress(@Param("dto") DressDTO dto);
	public ArrayList<DressDTO> selectMyDresses(int mb_uid);
	public ArrayList<DressDTO> selectYourDresses(int mb_type);
	public DressDTO selectDress(int dress_uid);
	public int updateDress(@Param("dto") DressDTO dto);
	public int deleteDress(int dress_uid);
	public int insertReply(@Param("dto") ReplyDTO dto);
	public int updateReply(@Param("dto") ReplyDTO dto);
	public int deleteReply(int reply_uid);
	public ArrayList<ReplyDTO> selectDressReply(int dress_uid);
	public ArrayList<ReplyDTO> selectMyReply(int mb_uid);
	public int likeDress(int dress_uid);

}
