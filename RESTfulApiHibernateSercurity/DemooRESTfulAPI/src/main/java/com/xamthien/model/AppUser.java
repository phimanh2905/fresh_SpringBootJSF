package com.xamthien.model;
// Generated Jul 23, 2018 3:57:16 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "USER", catalog = "ebflight")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","role"})
public class AppUser implements java.io.Serializable {

	private Integer uid;
	private Role role;
	private String username;
	private String pass;

	public AppUser() {
	}

	public AppUser(Role role, String username, String pass) {
		this.role = role;
		this.username = username;
		this.pass = pass;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "UID", unique = true, nullable = false)
	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "USERNAME", nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASS", nullable = false, length = 50)
	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
