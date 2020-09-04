package com.yc.demo.crbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yc.demo.crbook.bean.CrBook;

@Repository
public interface CrBookDao extends JpaRepository<CrBook, Integer>{

}
