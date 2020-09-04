package com.yc.demo.crbook;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import com.yc.demo.crbook.bean.CrUser;
import com.yc.demo.crbook.dao.CrUserDao;

@SpringBootTest
class ApplicationTests {

	@Resource
	private CrUserDao cdao;
	
	@Test
	void contextLoads() {
		CrUser cu = new CrUser();
		cu.setName("a");
		cdao.findAll(Example.of(cu));
	}

}
