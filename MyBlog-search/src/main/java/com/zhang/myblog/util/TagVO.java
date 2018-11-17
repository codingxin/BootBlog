package com.zhang.myblog.util;


import java.io.Serializable;


public class TagVO implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	private String name;  //标签名字
	private Long count;  //标签数量
	
	public TagVO(String name, Long count) {
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
 
}
