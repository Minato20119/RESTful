package com.minato.springboot.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Minato
 *
 */
@Entity
@Table(name = "Filght_Schedules")
public class FlightSchedules {

	@Column(name = "Schedule_ID")
	private int id;

	@Column(name = "Flight_Number")
	private int flightNumber;

	@Column(name = "Departure_Time")
	private Date departureTime;

	@Column(name = "Arrival_Time")
	private Date arrivalTime;

	@Column(name = "Other_Details")
	private String otherDetails;

	private Airlines airlines;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH:mm:ss");

	@ManyToOne
	@JoinColumn(name = "Airline_Code")
	public Airlines getAirlines() {
		return airlines;
	}

	public void setAirlines(Airlines airlines) {
		this.airlines = airlines;
	}

	@JsonIgnore
	private Set<Reservations> reservations = new HashSet<>();

	@OneToMany(mappedBy = "flightSchedules", cascade = CascadeType.ALL)
	public Set<Reservations> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservations> reservations) {
		this.reservations = reservations;
	}

	public FlightSchedules() {
	}

	public FlightSchedules(int flightNumber, String departureTime, String arrivalTime, String otherDetails,
			Airlines airlines) throws ParseException {

		this.flightNumber = flightNumber;
		this.departureTime = sdf.parse(departureTime);
		this.arrivalTime = sdf.parse(arrivalTime);
		this.otherDetails = otherDetails;
		this.airlines = airlines;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

}