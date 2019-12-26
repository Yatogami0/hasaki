package com.hasaki.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hasaki.entity.Rent;

@Mapper
public interface RentDao {
	@Select("select rstate,rid,r.* from rent r order by rstate desc,rid desc")
	@Results({
		@Result(column="rid",property="rid"),
		@Result(column="backtime",property="backtime"),
		@Result(column="day",property="day"),
		@Result(column="outtime",property="outtime"),
		@Result(column="rstate",property="rstate"),
		@Result(column="username_1",property="username_1"),
		@Result(column="cid",property="cid")
	})
	public List<Rent> selectRent();

	@Select("select rstate,r.* from rent r where username_1=#{username_1} order by rstate desc")
	@Results({
		@Result(column="rid",property="rid"),
		@Result(column="backtime",property="backtime"),
		@Result(column="day",property="day"),
		@Result(column="outtime",property="outtime"),
		@Result(column="rstate",property="rstate"),
		@Result(column="username_1",property="username_1")
	})
	public List<Rent> userRent(String username_1);

	@Insert("insert into rent (outtime,day,rstate,username_1,cid) values(#{outtime},#{day},'2未完成',#{username_1},#{cid})")
	public int addRent(@Param(value="outtime")Date outtime,@Param(value="day")Integer day,@Param(value="username_1")String username_1,@Param(value="cid")String cid);

	@Update("update rent set rstate='1完成した', backtime=#{backtime} where rid=#{rid} and rstate='2未完成'")
	public int updateRent(Integer rid,Date backtime);
}
