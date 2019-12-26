package com.hasaki.service;

import java.util.List;

import com.hasaki.entity.Users;

public interface UserService {
	public List<Users> login(String username,String password);

	public int register(String username,String utel,String uemail,String realname,String password);

	public int updatePassword(String password,Integer userid);

	public int updateEmail(String uemail,Integer userid);

	public int updateTel(String utel,Integer userid);
}
