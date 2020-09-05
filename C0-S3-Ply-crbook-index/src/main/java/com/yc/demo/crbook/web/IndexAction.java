package com.yc.demo.crbook.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexAction {
	
	@Resource
	private IBookAction bact;
	
	@GetMapping("/")
	public String index(Model m) {
		m.addAttribute("newBooks", bact.getNewBooks());
		return "index";
	}

}
