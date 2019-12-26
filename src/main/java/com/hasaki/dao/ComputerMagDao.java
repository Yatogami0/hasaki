package com.hasaki.dao;

import org.apache.ibatis.annotations.Mapper;

import com.hasaki.entity.ComputerMag;

@Mapper
public interface ComputerMagDao {

	public int addComputerMag(ComputerMag computerMag);

	public int updateComputerMag(String number,String cstate);

	public int deleteComputerMag();

}
