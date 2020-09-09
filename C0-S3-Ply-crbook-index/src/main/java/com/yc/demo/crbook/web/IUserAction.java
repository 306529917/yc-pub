package com.yc.demo.crbook.web;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.yc.demo.crbook.bean.CrCart;
import com.yc.demo.crbook.bean.CrUser;
import com.yc.demo.crbook.bean.Result;

@FeignClient("cruser")
public interface IUserAction {

	@PostMapping("user/find")
	public List<CrUser> find(CrUser user);

	@PostMapping(path = "user/register.do")
	public Result register(@RequestParam("repwd") String repwd, @RequestBody CrUser user);

	@PostMapping(path = "cart/addCart.do")
	public Result addCart(CrCart cart);
	
	@GetMapping("cart/find")
	List<CrCart> queryCart(CrCart cart);



}
