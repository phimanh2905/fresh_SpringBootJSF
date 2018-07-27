package com.xamthien.model;
// Generated Jul 23, 2018 3:57:16 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name = "CUSTOMER", catalog = "ebflight")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler","reservations"})
public class Customer implements java.io.Serializable {

	private Integer cid;
	private String CName;
	private String phone;
	private String email;
	private Set<Reservation> reservations = new HashSet<Reservation>(0);

	public Customer() {
	}

	public Customer(String CName, String phone,String email) {
		this.CName = CName;
		this.phone = phone;
		this.email = email;
	}

	public Customer(String CName, String phone, String email, Set<Reservation> reservations) {
		this.CName = CName;
		this.phone = phone;
		this.email = email;
		this.reservations = reservations;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "CID", unique = true, nullable = false)
	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Column(name = "C_NAME", nullable = false, length = 50)
	public String getCName() {
		return this.CName;
	}

	public void setCName(String CName) {
		this.CName = CName;
	}

	@Column(name = "PHONE", nullable = false, length = 15)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "EMAIL", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
//	public Set<Reservation> getReservations() {
//		return this.reservations;
//	}
//
//	public void setReservations(Set<Reservation> reservations) {
//		this.reservations = reservations;
//	}
//
//	@Override
//	public String toString() {
//		return "Customer [cid=" + cid + ", CName=" + CName + ", phone=" + phone + ", email=" + email + "]";
//	}
	

}
