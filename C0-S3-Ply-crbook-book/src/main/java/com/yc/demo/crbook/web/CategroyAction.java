package com.yc.demo.crbook.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.demo.crbook.bean.CrCategroy;
import com.yc.demo.crbook.dao.CrCategoryDao;

@RestController
@RequestMapping("category")
public class CategroyAction extends BaseAction<CrCategroy, Integer> {

	@Resource
	private CrCategoryDao dao;

	@Override
	protected JpaRepository<CrCategroy, Integer> dao() {
		return dao;
	}

	@GetMapping("getRootCgys")
	public List<CrCategroy> getRootCgys() {
		return dao.findByPidIsNull();
	}

}
