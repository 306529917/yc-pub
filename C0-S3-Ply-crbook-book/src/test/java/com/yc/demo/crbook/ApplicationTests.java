package com.yc.demo.crbook;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.yc.demo.crbook.bean.CrArticle;
import com.yc.demo.crbook.bean.CrBook;
import com.yc.demo.crbook.dao.CrArticleDao;
import com.yc.demo.crbook.dao.CrBookDao;
import com.yc.demo.crbook.dao.CrCategoryDao;

@SpringBootTest
class ApplicationTests {

	@Resource
	private CrArticleDao adao;

	@Resource
	private CrCategoryDao gdao;

	@Resource
	private CrBookDao bdao;
	
	@Resource
	BookBiz bbiz;

	@Test
	void contextLoads() {
		CrArticle a = new CrArticle();
		a.setTitle("test");
		a.setCreateTime(new Timestamp(System.currentTimeMillis()));
		adao.saveAndFlush(a);
		a = adao.findById(a.getId()).get();
		System.out.println(a.getTitle());
		System.out.println(a.getCreateTime());
	}

	@Test
	void test1() {
		CrBook book = bdao.findById(791).get();
		System.out.println(book.getPressDate());
		System.out.println(adao.findById(71483).get().getCreateTime());
	}

}
