package com.otsazo.colorfit.beans.dao;

import org.apache.ibatis.annotations.Param;
import com.otsazo.colorfit.beans.DressDTO;

public interface DressDAO {

	public int insertDress(@Param("dto") DressDTO dto);

}
