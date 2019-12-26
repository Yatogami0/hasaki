package com.hasaki.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasaki.dao.RentDao;
import com.hasaki.entity.Rent;
import com.hasaki.service.RentService;

@Service("rentService")
public class RentServiceImpl implements RentService{

	@Autowired
	private RentDao rentDao;
	private List<Rent> rent;

	public List<Rent> selectRent() {
		// TODO 自動生成されたメソッド・スタブ
		rent =	rentDao.selectRent();
		return rent;
	}


	public List<Rent> userRent(String username_1) {
		// TODO 自動生成されたメソッド・スタブ
		rent =	rentDao.userRent(username_1);
		return rent;
	}


	@Override
	public int addRent(Date outtime, Integer day, String username_1,String cid) {
		// TODO 自動生成されたメソッド・スタブ
		int num = 0;
		num = rentDao.addRent(outtime, day, username_1,cid);
		return num;
	}


	@Override
	public int updateRent(Integer rid, Date backtime) {
		// TODO 自動生成されたメソッド・スタブ
		int num= 0;
		num = rentDao.updateRent(rid, backtime);
		return num;
	}

}
