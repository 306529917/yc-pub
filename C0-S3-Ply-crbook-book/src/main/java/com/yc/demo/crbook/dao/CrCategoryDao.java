package com.yc.demo.crbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yc.demo.crbook.bean.CrCategroy;

@Repository
public interface CrCategoryDao extends JpaRepository<CrCategroy, Integer>{

}
