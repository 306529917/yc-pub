package com.yc.demo.crbook.web;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yc.demo.crbook.bean.CrUser;
import com.yc.demo.crbook.bean.Result;
import com.yc.demo.crbook.biz.BizException;
import com.yc.demo.crbook.biz.UserBiz;
import com.yc.demo.crbook.dao.CrUserDao;

@RestController
@RequestMapping("user")
public class UserAction extends BaseAction<CrUser, Integer> {

	@Resource
	private CrUserDao dao;

	@Resource
	private UserBiz ubiz;

	@Override
	protected JpaRepository<CrUser, Integer> dao() {
		return dao;
	}

	@PostMapping("register.do")
	public Result register(@RequestParam("repwd") String repwd, @Valid @RequestBody CrUser user, Errors errors) {
		if (errors.hasErrors() == false) {
			try {
				ubiz.register(user, repwd);
				return Result.success("注册成功！");
			} catch (BizException e) {
				e.printStackTrace();
				errors.rejectValue(e.getCode(), e.getCode(), e.getMessage());
				System.out.println(errors.getAllErrors());
			}
		}
		return Result.failure("注册失败！", errors.getAllErrors());
	}

}
