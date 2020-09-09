package com.yc.demo.crbook.web;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yc.demo.crbook.bean.CrBook;
import com.yc.demo.crbook.bean.CrCategroy;
import com.yc.demo.crbook.bean.CrShowBook;

@FeignClient("crbook")
public interface IBookAction {

	@GetMapping("book/getNewBooks")
	List<CrBook> getNewBooks();
	
	@GetMapping("category/getRootCgys")
	List<CrCategroy> getRootCgys();

	@GetMapping("book/getIndexBooks")
	List<CrShowBook> getIndexBooks();

	@GetMapping("book/get")
	CrBook get(@RequestParam("id") int id);
	
}
