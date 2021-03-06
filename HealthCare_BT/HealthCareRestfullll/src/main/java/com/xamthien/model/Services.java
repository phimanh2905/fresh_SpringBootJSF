package com.xamthien.model;
// Generated Aug 14, 2018 2:08:08 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Services generated by hbm2java
 */
@Entity
@Table(name = "SERVICES", catalog = "healthcare")
public class Services implements java.io.Serializable {

	private String name;
	private String icon;
	private String detail;
	private String path;

	public Services() {
	}

	public Services(String name, String icon, String detail, String path) {
		this.name = name;
		this.icon = icon;
		this.detail = detail;
		this.path = path;
	}

	@Id

	@Column(name = "NAME", unique = true, nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "ICON", nullable = false, length = 50)
	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Column(name = "DETAIL", nullable = false, length = 200)
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Column(name = "PATH", nullable = false, length = 50)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
