package com.hasaki.service;

import java.util.Date;
import java.util.List;

import com.hasaki.entity.Rent;

public interface RentService {
	public List<Rent> selectRent();

	public List<Rent> userRent(String username1);

	public int addRent(Date outtime,Integer day,String username_1,String cid);

	public int updateRent(Integer rid,Date backtime);
}
