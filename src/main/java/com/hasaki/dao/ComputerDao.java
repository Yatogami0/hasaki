package com.hasaki.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.hasaki.entity.Computer;

@Mapper
public interface ComputerDao {

	@Select("select a.cid as cid,a.cpu as cpu,a.ctype as ctype,a.gpu as gpu,b.cstate as cstate,b.number as number from computer a,computermag b where a.cid=b.cid")
	@Results({
		@Result(column="cid",property="cid"),
		@Result(column="cpu",property="cpu"),
		@Result(column="ctype",property="ctype"),
		@Result(column="gpu",property="gpu"),
		@Result(column="cstate",property="cstate"),
		@Result(column="number",property="number")
	})
	public List<Computer> selectAll();

	@Insert("insert into computer values(#{cid},#{ctype},#{cpu},#{gpu})")
	public int addComputer(@Param(value="cid")String cid,@Param(value="ctype")String ctype,@Param(value="cpu")String cpu,@Param(value="gpu")String gpu);

	public int deleteComputer(String cid);
}
