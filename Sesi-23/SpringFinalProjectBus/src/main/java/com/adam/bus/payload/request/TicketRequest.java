package com.adam.bus.payload.request;

import javax.validation.constraints.NotBlank;
import java.util.Objects;
import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class TicketRequest {
	
	@ApiModelProperty(hidden = true)
	private Long id;
	
	private int seatNumber;
	
	private Boolean cancellable;
	
	private String journeyDate;
	
	private Long passengerId;
	
	private Long tripScheduleId;
	
	public TicketRequest() {
		super();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cancellable, id, journeyDate, passengerId, seatNumber, tripScheduleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketRequest other = (TicketRequest) obj;
		return Objects.equals(cancellable, other.cancellable) && Objects.equals(id, other.id)
				&& Objects.equals(journeyDate, other.journeyDate) && Objects.equals(passengerId, other.passengerId)
				&& seatNumber == other.seatNumber && Objects.equals(tripScheduleId, other.tripScheduleId);
	}

	@Override
	public String toString() {
		return "TicketRequest [id=" + id + ", seatNumber=" + seatNumber + ", cancellable=" + cancellable
				+ ", journeyDate=" + journeyDate + ", passengerId=" + passengerId + ", tripScheduleId=" + tripScheduleId
				+ ", hashCode()=" + hashCode() + ", getId()=" + getId() + ", getSeatNumber()=" + getSeatNumber()
				+ ", getCancellable()=" + getCancellable() + ", getJourneyDate()=" + getJourneyDate()
				+ ", getPassengerId()=" + getPassengerId() + ", getTripScheduleId()=" + getTripScheduleId()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

	
	public TicketRequest(@NotNull Long id, @NotNull int seatNumber, @NotNull Boolean cancellable,
			@NotBlank String journeyDate, @NotBlank Long passegerId, @NotBlank Long tripScheduleId) {
		super();
		this.id = id;
		this.cancellable = cancellable;
		this.journeyDate = journeyDate;
		this.seatNumber = seatNumber;
		this.passengerId = passegerId;
		this.tripScheduleId = tripScheduleId;
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

	public void setJourneyDate(String journeyData) {
		this.journeyDate = journeyData;
	}

	public Long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}

	public Long getTripScheduleId() {
		return tripScheduleId;
	}

	public void setTripScheduleId(Long tripScheduleId) {
		this.tripScheduleId = tripScheduleId;
	}
}
