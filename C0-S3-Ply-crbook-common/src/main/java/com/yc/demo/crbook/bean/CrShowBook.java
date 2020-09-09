package com.yc.demo.crbook.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cr_show")
public class CrShowBook extends CrShow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String page;

	private String board;

	private String relatb="cr_book";

	@Column(insertable = false, updatable = false)
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

	@Override
	public String toString() {
		return "CrShow [id=" + id + ", page=" + page + ", board=" + board + ", relatb=" + relatb + ", relaid=" + relaid
				+ "]";
	}

	@OneToOne
	@JoinColumn(name="relaid")
	private CrBook book;

	public CrBook getBook() {
		return book;
	}

	public void setBook(CrBook book) {
		this.book = book;
	}

}
