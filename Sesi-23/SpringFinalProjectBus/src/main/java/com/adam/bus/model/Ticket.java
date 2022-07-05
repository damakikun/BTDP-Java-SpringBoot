package com.adam.bus.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int seatNumber;
	
	private Boolean cancellable;
	
	private String journeyDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trip_schedule_id")
	private TripSchedule tripSchedule;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User passenger;
	
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", seatNumber=" + seatNumber + ", cancellable=" + cancellable + ", journeyDate="
				+ journeyDate + ", passenger=" + passenger + ", tripSchedule=" + tripSchedule + ", hashCode()=" + hashCode()
				+ ", getId()=" + getId() + ", getSeatNumber()=" + getSeatNumber() + ", isCancellable()="
				+ getCancellable() + ", getJourneyDate()=" + getJourneyDate() + ", getPassenger()=" + getPassenger()
				+ ", getTripSchedule()=" + getTripSchedule() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cancellable, id, journeyDate, seatNumber, tripSchedule, passenger);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		return cancellable == other.cancellable && id == other.id && Objects.equals(journeyDate, other.journeyDate)
				&& seatNumber == other.seatNumber && Objects.equals(tripSchedule, other.tripSchedule)
				&& Objects.equals(passenger, other.passenger);
	}
	
	public Ticket() {
    }

    public Ticket(int seatNumber, Boolean cancellable, String journeyDate, User passenger,
    		TripSchedule tripSchedule) {
    	super();
        this.seatNumber = seatNumber;
        this.cancellable = cancellable;
        this.journeyDate = journeyDate;
        this.passenger = passenger;
        this.tripSchedule = tripSchedule;
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Boolean getCancellable() {
		return cancellable;
	}

	public void setCancellable(Boolean cancellable) {
		this.cancellable = cancellable;
	}

	public String getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	public TripSchedule getTripSchedule() {
		return tripSchedule;
	}

	public void setTripSchedule(TripSchedule tripSchedule) {
		this.tripSchedule = tripSchedule;
	}

	public User getPassenger() {
		return passenger;
	}

	public void setPassenger(User passenger) {
		this.passenger = passenger;
	}
}
