package com.otsazo.colorfit.beans.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.otsazo.colorfit.beans.DressDTO;
import com.otsazo.colorfit.beans.DressMemberDTO;
import com.otsazo.colorfit.beans.LikesDTO;
import com.otsazo.colorfit.beans.ReplyDTO;
import com.otsazo.colorfit.beans.RereplyDTO;

public interface DressDAO {

	public int insertDress(@Param("dto") DressDTO dto);
	public int insertDress2(@Param("dto") DressDTO dto);
	public ArrayList<DressDTO> selectMyDresses(int mb_uid);
	public ArrayList<DressDTO> selectYourDresses(int mb_type);
	public DressMemberDTO selectDress(int dress_uid);
	public int updateDress(@Param("dto") DressDTO dto);
	public int deleteDress(int dress_uid);
	public int changeShareType(int dress_uid);
	public int insertReply(@Param("dto") ReplyDTO dto);
	public int updateReply(@Param("dto") ReplyDTO dto);
	public int deleteRereply(int rereply_uid);
	public int insertRereply(@Param("dto") RereplyDTO dto);
	public int updateRereply(@Param("dto") RereplyDTO dto);
	public int deleteReply(int reply_uid);
	public ArrayList<ReplyDTO> selectDressReply(int dress_uid);
	public ArrayList<ReplyDTO> selectMyReply(int mb_uid);
	public ArrayList<RereplyDTO> selectMyRereply(int mb_uid);
	public ArrayList<RereplyDTO> selectRereply(int reply_uid);
	public int likeDress(@Param("dto") LikesDTO dto);
	public int likeDress2(@Param("dto") LikesDTO dto);
	public int unlikeDress(@Param("dto") LikesDTO dto);
	public int unlikeDress2(@Param("dto") LikesDTO dto);
	public LikesDTO checkLikesType(@Param("dress_uid") int dress_uid, @Param("mb_uid") int mb_uid);
	public ArrayList<LikesDTO> selectMyLikes(int mb_uid);
}
