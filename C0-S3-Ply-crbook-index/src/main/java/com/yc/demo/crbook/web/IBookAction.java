package com.yc.demo.crbook.web;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.yc.demo.crbook.bean.CrBook;

@FeignClient("book")
public interface IBookAction {

	@GetMapping("getNewBooks")
	List<CrBook> getNewBooks();
	
}
