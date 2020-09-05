package com.yc.demo.crbook;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import com.yc.demo.crbook.bean.CrCart;
import com.yc.demo.crbook.bean.CrUser;
import com.yc.demo.crbook.dao.CrCartDao;
import com.yc.demo.crbook.dao.CrUserDao;

@SpringBootTest
class ApplicationTests {

	@Resource
	private CrUserDao udao;
	
	@Resource
	private CrCartDao cdao;
	
	@Test
	void contextLoads() {
		CrUser cu = new CrUser();
		cu.setName("a");
		udao.findAll(Example.of(cu));
		List<CrCart> list = cdao.findAll();
		for( CrCart c : list) {
			System.out.println("=============");
			System.out.println(c.getUser());
			System.out.println(c.getBook());
		}
	}

}
