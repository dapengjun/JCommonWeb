package cn.itear.perm.po;

import java.io.Serializable;

public class GroupPo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2761631853360122093L;

	private Integer id;
	private String name;
	private String desc;
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
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
