package cn.itear.perm.po;

import java.io.Serializable;

public class UserPo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5094780227872215074L;
	private Integer id;
	private String name;
	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}