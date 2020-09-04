package com.yc.demo.crbook.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yc.demo.crbook.bean.Result;

public abstract class BaseAction<E, I> {

	protected abstract JpaRepository<E, I> dao();

	@RequestMapping("find")
	public List<E> find(E e) {
		return dao().findAll(Example.of(e));
	}

	@RequestMapping("get")
	public E get(I id) {
		return dao().findById(id).get();
	}

	@RequestMapping("page")
	public Page<E> page(E e, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int rows) {
		Pageable p = PageRequest.of(page, rows);
		return dao().findAll(Example.of(e), p);
	}

	@RequestMapping("save")
	public Result save(@Valid E e, Errors errors) {
		if (errors.hasErrors()) {
			return Result.failure("保存失败！", errors.getAllErrors());
		} else {
			dao().save(e);
			return Result.success("保存成功！");
		}
	}

	@RequestMapping("remove")
	public Result remove(I id) {
		dao().deleteById(id);
		return Result.success("删除成功！");
	}

}
