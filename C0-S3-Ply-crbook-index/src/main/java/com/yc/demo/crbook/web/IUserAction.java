package com.yc.demo.crbook.web;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.yc.demo.crbook.bean.CrUser;

@FeignClient("cruser")
public interface IUserAction {

	@PostMapping("user/find")
	public List<CrUser> find(CrUser user);
	
}
