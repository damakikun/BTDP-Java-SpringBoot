package com.adam.bus.model;

import java.util.Set;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
@Table(name = "trip_schedule")
public class TripSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trip_id")
	private Trip tripDetail;
	
	@OneToMany(mappedBy = "tripSchedule", cascade = CascadeType.ALL)
	private Set<Ticket> ticketsSold;
	
	private String tripDate;
	
	private int availableSeats;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Trip getTripDetail() {
		return tripDetail;
	}

	public void setTripDetail(Trip tripDetail) {
		this.tripDetail = tripDetail;
	}

	public Set<Ticket> getTicketsSold() {
		return ticketsSold;
	}

	public void setTicketsSold(Set<Ticket> ticketsSold) {
		this.ticketsSold = ticketsSold;
	}

	public String getTripDate() {
		return tripDate;
	}

	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	@Override
	public String toString() {
		return "TripSchedule [id=" + id + ", tripDate=" + tripDate + ", availableSeats=" + availableSeats + ", trip="
				+ tripDetail + ", ticket=" + ticketsSold + ", hashCode()=" + hashCode() + ", getId()=" + getId()
				+ ", getTripDate()=" + getTripDate() + ", getAvailableSeats()=" + getAvailableSeats() + ", getTrip()="
				+ getTripDetail() + ", getTicket()=" + getTicketsSold() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(availableSeats, id, ticketsSold, tripDetail, tripDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TripSchedule other = (TripSchedule) obj;
		return availableSeats == other.availableSeats && id == other.id && Objects.equals(ticketsSold, other.ticketsSold)
				&& Objects.equals(tripDetail, other.tripDetail) && Objects.equals(tripDate, other.tripDate);
	}
	
	public TripSchedule() {
    }
	
	public TripSchedule(@NotBlank String tripDate, @NotNull int availableSeats, Trip tripDetail) {
		super();
        this.tripDate = tripDate;
        this.availableSeats = availableSeats;
        this.tripDetail = tripDetail;
    }
}
