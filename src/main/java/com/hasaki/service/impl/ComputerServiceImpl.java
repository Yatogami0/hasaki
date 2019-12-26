package com.hasaki.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hasaki.dao.ComputerDao;
import com.hasaki.entity.Computer;
import com.hasaki.service.ComputerService;

@Service("computerService")
public class ComputerServiceImpl implements ComputerService {

	@Autowired
	private ComputerDao computerDao;
	private List<Computer> computer;

	public List<Computer> selectAll() {
		// TODO 自動生成されたメソッド・スタブ
		computer = computerDao.selectAll();
		return computer;
	}


	public int addComputer(String cid,String ctype,String cpu,String gpu) {
		// TODO 自動生成されたメソッド・スタブ
		int num=0;
		num=computerDao.addComputer(cid, ctype, cpu, gpu);
		return num;
	}


	public int deleteComputer(String cid) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

}
