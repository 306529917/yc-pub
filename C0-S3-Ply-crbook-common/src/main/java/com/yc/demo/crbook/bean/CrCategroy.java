package com.yc.demo.crbook.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class CrCategroy implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(insertable=false,updatable=false)
    private Integer pid;
    
    @OneToMany
    @JoinColumn(name="pid")
    private List<CrCategroy> children;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

	public List<CrCategroy> getChildren() {
		return children;
	}

	public void setChildren(List<CrCategroy> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "CrCategroy [id=" + id + ", name=" + name + ", pid=" + pid + "]";
	}

}