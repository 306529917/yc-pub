package com.yc.demo.crbook.web;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
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

	@RequestMapping("addCart.do")
	public Result addCart(CrCart cart) {
		System.out.println(cart);
		if (cart.getId() != null) {
			CrCart dbcart = dao.findById(cart.getId()).get();
			dbcart.setCnt(dbcart.getCnt() + cart.getCnt());
			cart = dbcart;
		}
		cart = dao.save(cart);
		return Result.success("添加购物车成功！", cart);
	}

}
