package com.yc.demo.crbook.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.demo.crbook.bean.CrUser;
import com.yc.demo.crbook.dao.CrUserDao;
import com.yc.demo.crbook.util.Utils;

@Service
@Transactional
public class UserBiz {

	@Resource
	private CrUserDao udao;

	public void register(CrUser user, String repwd) throws BizException {
		Utils.must(user.getPwd().equals(repwd), "pwd", "两次输入的密码不一致！");
		Utils.must(udao.countByAccount(user.getAccount()) == 0, "account", "该账号已经被注册了！");
		udao.save(user);
	}
}
