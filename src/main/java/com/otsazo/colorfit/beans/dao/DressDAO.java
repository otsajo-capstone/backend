package com.otsazo.colorfit.beans.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import com.otsazo.colorfit.beans.DressDTO;

public interface DressDAO {

	public int insertDress(@Param("dto") DressDTO dto);
	public ArrayList<DressDTO> selectMyDresses(int mb_uid);
	public DressDTO selectDress(int dress_uid);
	public int updateDress(@Param("dto") DressDTO dto);
	public int deleteDress(int dress_uid);

}
