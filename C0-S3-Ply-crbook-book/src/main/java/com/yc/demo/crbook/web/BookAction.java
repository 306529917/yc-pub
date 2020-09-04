package com.yc.demo.crbook.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookAction {
	
	@GetMapping("book")
	public String index(HttpServletRequest req) {
		return "book  "+req.getServerName() + ":" + req.getServerPort();
	}

}
