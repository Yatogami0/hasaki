package com.hasaki.service;

import java.util.List;

import com.hasaki.entity.Computer;

public interface ComputerService {

	public List<Computer> selectAll();

	public int addComputer(String cid,String ctype,String cpu,String gpu);

	public int deleteComputer(String cid);
}
