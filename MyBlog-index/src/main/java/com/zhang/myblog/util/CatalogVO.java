package com.zhang.myblog.util;


import java.io.Serializable;

/**
 * 实现序列化接口，用于返回分类对象.用于接收前台传递给后台的参数
 */
import com.zhang.myblog.entity.Catalog;

public class CatalogVO implements Serializable {
 
	private static final long serialVersionUID = 1L;
	//值对象
	private String username;
	private Catalog catalog;
	
	public CatalogVO() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

}
