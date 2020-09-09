package com.yc.demo.crbook.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CrCart implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(insertable = false, updatable = false)
	private Integer uid;

	@Column(insertable = false, updatable = false)
	private Integer bid;

	private Integer cnt;

	private Timestamp createTime;

	@OneToOne
	@JoinColumn(name = "uid")
	private CrUser user;

	@OneToOne
	@JoinColumn(name = "bid")
	private CrBook book;

	public CrUser getUser() {
		return user;
	}

	public void setUser(CrUser user) {
		this.user = user;
	}

	public CrBook getBook() {
		return book;
	}

	public void setBook(CrBook book) {
		this.book = book;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "CrCart [id=" + id + ", uid=" + uid + ", bid=" + bid + ", cnt=" + cnt + ", createTime=" + createTime
				+ ", user=" + user + ", book=" + book + "]";
	}
	
}