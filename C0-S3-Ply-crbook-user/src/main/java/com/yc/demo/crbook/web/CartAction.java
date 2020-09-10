package com.yc.demo.crbook.web;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.demo.crbook.bean.CrCart;
import com.yc.demo.crbook.bean.Result;
import com.yc.demo.crbook.dao.CrCartDao;

@RestController
@RequestMapping("cart")
public class CartAction extends BaseAction<CrCart, Integer> {

	@Resource
	private CrCartDao dao;

	@Override
	protected JpaRepository<CrCart, Integer> dao() {
		return dao;
	}

	@PostMapping("addCart.do")
	public Result addCart(@RequestBody CrCart cart) {
		if (cart.getCnt() == null) {
			cart.setCnt(1);
		}
		CrCart dbcart = null;
		if (cart.getId() != null) {
			dbcart = dao.findById(cart.getId()).get();
		} else {
			Example<CrCart> exa = Example.of(cart, ExampleMatcher.matching().withIgnorePaths("cnt", "createTime"));
			dbcart = dao.findOne(exa).orElse(null);
		}
		if (dbcart != null) {
			dbcart.setCnt(dbcart.getCnt() + cart.getCnt());
			cart = dbcart;
		} else {
			cart.setCreateTime(new Timestamp(System.currentTimeMillis()));
		}
		cart = dao.save(cart);
		return Result.success("添加购物车成功！", cart);
	}

}
