package com.yc.demo.crbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yc.demo.crbook.bean.CrUser;

@Repository
public interface CrUserDao extends JpaRepository<CrUser, Integer>{

	@Query("select count(*) from CrUser a where a.account=:account")
	int countByAccount(String account);

}
