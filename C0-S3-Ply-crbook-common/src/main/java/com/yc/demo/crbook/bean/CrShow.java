package com.yc.demo.crbook.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CrShow implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String page;

	private String board;

	private String relatb;

	private Integer relaid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getRelatb() {
		return relatb;
	}

	public void setRelatb(String relatb) {
		this.relatb = relatb;
	}

	public Integer getRelaid() {
		return relaid;
	}

	public void setRelaid(Integer relaid) {
		this.relaid = relaid;
	}

}