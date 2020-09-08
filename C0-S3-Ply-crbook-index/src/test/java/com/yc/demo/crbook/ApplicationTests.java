package com.yc.demo.crbook;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.yc.demo.crbook.bean.CrUser;
import com.yc.demo.crbook.web.IUserAction;

@SpringBootTest
class ApplicationTests {
	
	@Resource
	IUserAction uact;

	@Test
	void contextLoads() {
		
		CrUser user = new CrUser();
		user.setAccount("admin");
		user.setPwd("111");
		System.out.println(user);
		user = uact.find(user).get(0);
		System.out.println(user);
	}

}
