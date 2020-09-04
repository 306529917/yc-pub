package com.yc.demo.crbook.web;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.demo.crbook.bean.CrArticle;
import com.yc.demo.crbook.dao.CrArticleDao;


@RestController
@RequestMapping("article")
public class ArticleAction extends BaseAction<CrArticle,Integer>{
	
	@Resource
	private CrArticleDao dao;
	
	@Override
	protected JpaRepository<CrArticle, Integer> dao() {
		return dao;
	}

}
