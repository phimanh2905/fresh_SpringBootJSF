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

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Airline generated by hbm2java
 */
@Entity
@Table(name = "AIRLINE", catalog = "ebflight")
//@JsonIgnoreProperties(value = {"flightScheduleses"})
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","flightScheduleses"})
public class Airline implements java.io.Serializable {

	private Integer aid;
	private String AName;
	private String ANote;
	private Set<FlightSchedules> flightScheduleses = new HashSet<FlightSchedules>(0);

	public Airline() {
	}

	public Airline(String AName) {
		this.AName = AName;
	}

	public Airline(String AName, String ANote, Set<FlightSchedules> flightScheduleses) {
		this.AName = AName;
		this.ANote = ANote;
		this.flightScheduleses = flightScheduleses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "AID", unique = true, nullable = false)
	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	@Column(name = "A_NAME", nullable = false, length = 50)
	public String getAName() {
		return this.AName;
	}

	public void setAName(String AName) {
		this.AName = AName;
	}

	@Column(name = "A_NOTE")
	public String getANote() {
		return this.ANote;
	}

	public void setANote(String ANote) {
		this.ANote = ANote;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "airline")
	public Set<FlightSchedules> getFlightScheduleses() {
		return this.flightScheduleses;
	}

	public void setFlightScheduleses(Set<FlightSchedules> flightScheduleses) {
		this.flightScheduleses = flightScheduleses;
	}

}