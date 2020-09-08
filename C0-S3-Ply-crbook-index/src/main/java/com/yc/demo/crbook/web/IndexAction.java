package com.yc.demo.crbook.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yc.demo.crbook.bean.CrUser;

@Controller
@SessionAttributes("loginedUser")
public class IndexAction {

	@Resource
	private IBookAction bact;

	@Resource
	private IUserAction uact;

	@GetMapping(path = { "/", "index" })
	public String index(Model m) {
		m.addAttribute("newBooks", bact.getNewBooks());
		m.addAttribute("rootCgys", bact.getRootCgys());
		return "index";
	}

	@PostMapping("login.do")
	public String doLogin(@Valid CrUser user, Errors es, Model m) {
		if (es.hasFieldErrors("account") == false && es.hasFieldErrors("pwd") == false) {
			List<CrUser> list = uact.find(user);
			if (list.size() > 0) {
				m.addAttribute("loginedUser", list.get(0));
				return "index";
			} else {
				es.reject("UserOrPwdError", "用户名或密码错误！");
			}
		}
		m.addAttribute("inUser", user);
		m.addAttribute("errors", es.getAllErrors());
		return "login";
	}

	@GetMapping(path = { "logout.do" })
	public String loginout(Model m, HttpSession session) {
		session.removeAttribute("loginedUser");
		return index(m);
	}

	@GetMapping(path = { "login", "register", "user_edit", "user_home", "user_order", "user_profile", "cart" })
	public void tohtml(Model m) {
	}

}
