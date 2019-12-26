package com.hasaki.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hasaki.dao.UserDao;
import com.hasaki.entity.Users;
import com.hasaki.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	private List<Users> users;

	public List<Users> login(String username, String password) {
		// TODO 自動生成されたメソッド・スタブ
		users =	userDao.login(username, password);
		return users;
	}

	@Transactional
	public int register(String username,String utel,String uemail,String realname,String password) {
		// TODO 自動生成されたメソッド・スタブ
		int num = 0;
		num = userDao.register(username,utel,uemail,realname,password);
		return num;
	}

	@Transactional
	public int updatePassword(String password, Integer userid) {
		// TODO 自動生成されたメソッド・スタブ
		int num=0;
		num = userDao.updatePassword(password, userid);
		return num;
	}

	@Transactional
	public int updateEmail(String uemail, Integer userid) {
		// TODO 自動生成されたメソッド・スタブ
		int num = 0;
		num = userDao.updateEmail(uemail, userid);
		return num;
	}

	@Transactional
	public int updateTel(String utel, Integer userid) {
		// TODO 自動生成されたメソッド・スタブ
		int num = 0;
		num = userDao.updateTel(utel, userid);
		return num;
	}

}
