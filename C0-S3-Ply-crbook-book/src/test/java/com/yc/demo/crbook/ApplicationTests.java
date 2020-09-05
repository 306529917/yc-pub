package com.yc.demo.crbook;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.yc.demo.crbook.bean.CrArticle;
import com.yc.demo.crbook.dao.CrArticleDao;
import com.yc.demo.crbook.dao.CrCategoryDao;

@SpringBootTest
class ApplicationTests {

	@Resource
	private CrArticleDao cdao;
	
	@Resource
	private CrCategoryDao gdao;
	
	@Resource
	BookBiz bbiz;
	
	@Test
	void contextLoads() {
		CrArticle a = new CrArticle();
		a.setTitle("test");
		a.setCreateTime(new Timestamp(System.currentTimeMillis()));
		cdao.saveAndFlush(a);
		a = cdao.findById(a.getId()).get();
		System.out.println(a.getTitle());
		System.out.println(a.getCreateTime());
	}
	
	@Test
	void test1() {
	}

}
