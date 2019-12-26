package com.hasaki.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hasaki.entity.Users;

@Mapper
public interface UserDao {
	 /**
     * 对于多个参数来说，每个参数之前都要加上@Param注解，
     * 要不然会找不到对应的参数进而报错
     */
	@Select("select * from users where username=#{username} and password=#{password}")
	@Results({
		@Result(column="userid",property="userid"),
		@Result(column="password",property="password"),
		@Result(column="realname",property="realname"),
		@Result(column="uemail",property="uemail"),
		@Result(column="username",property="username"),
		@Result(column="userroot",property="userroot"),
		@Result(column="utel",property="utel")
	})
	public List<Users> login(@Param(value="username")String username,@Param(value="password")String password);

	@Insert("insert into users (username,utel,uemail,userroot,realname,password) values(#{username},#{utel},#{uemail},'user',#{realname},#{password})")
	public int register(@Param(value="username")String username,@Param(value="utel")String utel,@Param(value="uemail")String uemail,@Param(value="realname")String realname,@Param(value="password")String password);

	@Update("update users set password=#{password} where userid=#{userid}")
	public int updatePassword(@Param(value="password")String password,@Param(value="userid")Integer userid);

	@Update("update users set uemail=#{ueamil} where userid=#{userid}")
	public int updateEmail(@Param(value="uemail")String uemail,@Param(value="userid")Integer userid);

	@Update("update users set utel=#{utel} where userid=#{userid}")
	public int updateTel(@Param(value="utel")String utel,@Param(value="userid")Integer userid);
}
