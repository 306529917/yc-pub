package com.yc.demo.crbook.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.demo.crbook.dao.CrCategoryDao;

@Service
@Transactional
public class BookBiz {
	
	@Resource
	private CrCategoryDao gdao;

}
