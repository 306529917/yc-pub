package com.yc.demo.crbook.web;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.demo.crbook.bean.CrCategroy;
import com.yc.demo.crbook.dao.CrCategoryDao;

@RestController
@RequestMapping("category")
public class CategroyAction extends BaseAction<CrCategroy,Integer>{
	
	@Resource
	private CrCategoryDao dao;
	
	@Override
	protected JpaRepository<CrCategroy, Integer> dao() {
		return dao;
	}

}
