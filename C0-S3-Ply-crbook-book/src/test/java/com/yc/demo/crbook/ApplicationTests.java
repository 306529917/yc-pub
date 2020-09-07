package com.yc.demo.crbook;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.yc.demo.crbook.bean.CrArticle;
import com.yc.demo.crbook.bean.CrBook;
import com.yc.demo.crbook.bean.CrCategroy;
import com.yc.demo.crbook.biz.BookBiz;
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
	
	@Test
	@Transactional
	void test2() {
		CrCategroy g = gdao.findById(31).get();
		System.out.println(g.getChildren());
		System.out.println("==========================");
		/*
		 * while(g!=null) { System.out.println(g); g = g.getParent(); }
		 */
	}
	
	@Test
	@Transactional
	void test3() {
		for(CrCategroy cc : gdao.findByPidIsNull()) {
			System.out.println(cc.getName() + "  " + cc.getChildren());
		}
	}

}
