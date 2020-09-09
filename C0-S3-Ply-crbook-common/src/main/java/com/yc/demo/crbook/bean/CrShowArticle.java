package com.yc.demo.crbook.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cr_show")
public class CrShowArticle extends CrShow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String relatb = "cr_article";

	public String getRelatb() {
		return relatb;
	}

	public void setRelatb(String relatb) {
		this.relatb = relatb;
	}

	@OneToOne
	@JoinColumn(name="relaid")
	private CrArticle article;

	public CrArticle getArticle() {
		return article;
	}

	public void setArticle(CrArticle article) {
		this.article = article;
	}

}
