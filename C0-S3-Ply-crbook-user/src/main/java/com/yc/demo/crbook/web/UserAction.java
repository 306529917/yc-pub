package com.yc.demo.crbook.web;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.demo.crbook.bean.CrUser;
import com.yc.demo.crbook.dao.CrUserDao;

@RestController
@RequestMapping("user")
public class UserAction extends BaseAction<CrUser,Integer>{
	
	@Resource
	private CrUserDao dao;
	
	@Override
	protected JpaRepository<CrUser, Integer> dao() {
		return dao;
	}

}
