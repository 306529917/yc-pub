package com.yc.demo.crbook.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.demo.crbook.bean.CrBook;
import com.yc.demo.crbook.bean.CrShowBook;
import com.yc.demo.crbook.dao.CrBookDao;
import com.yc.demo.crbook.dao.CrShowBookDao;

@RestController
@RequestMapping("book")
public class BookAction extends BaseAction<CrBook, Integer> {

	@Resource
	private CrBookDao dao;

	@Resource
	private CrShowBookDao sbdao;

	@Override
	protected JpaRepository<CrBook, Integer> dao() {
		return dao;
	}

	@GetMapping("getNewBooks")
	public List<CrBook> getNewBooks() {
		Pageable page = PageRequest.of(1, 12, Sort.by(Direction.DESC, "id"));
		return dao.findAll(page).getContent();
	}

	@GetMapping("getIndexBooks")
	public List<CrShowBook> getIndexBooks() {
		CrShowBook where = new CrShowBook();
		where.setPage("index");
		return sbdao.findAll(Example.of(where));
	}

}
