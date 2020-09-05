package com.yc.demo.crbook.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.demo.crbook.bean.CrBook;
import com.yc.demo.crbook.dao.CrBookDao;

@RestController
@RequestMapping("book")
public class BookAction extends BaseAction<CrBook,Integer>{
	
	@Resource
	private CrBookDao dao;
	
	@Override
	protected JpaRepository<CrBook, Integer> dao() {
		return dao;
	}
	
	@GetMapping("getNewBooks")
	public List<CrBook> getNewBooks(){
		// TODO 未完待续。。。
		return null;
	}

}
