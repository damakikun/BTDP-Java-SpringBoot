package com.adam.bus.payload.request;

import javax.validation.constraints.NotBlank;
import java.util.Objects;
import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class GetTripScheduleRequest {
	@ApiModelProperty(hidden = true)
	private Long id;
	
	private int available_seats; 
	
	private Long trip_detail;
	
	private String tripDate;
	
	@Override
	public int hashCode() {
		return Objects.hash(available_seats, id, tripDate, trip_detail);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GetTripScheduleRequest other = (GetTripScheduleRequest) obj;
		return available_seats == other.available_seats && Objects.equals(id, other.id)
				&& Objects.equals(tripDate, other.tripDate) && Objects.equals(trip_detail, other.trip_detail);
	}

	@Override
	public String toString() {
		return "GetTripScheduleRequest [id=" + id + ", available_seats=" + available_seats + ", trip_detail="
				+ trip_detail + ", tripDate=" + tripDate + ", hashCode()=" + hashCode() + ", getId()=" + getId()
				+ ", getAvailable_seats()=" + getAvailable_seats() + ", getTrip_detail()=" + getTrip_detail()
				+ ", getTripDate()=" + getTripDate() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}
	
	public GetTripScheduleRequest() {
		super();
	}

	public GetTripScheduleRequest(Long id, @NotNull int available_seats, @NotBlank Long trip_detail,
			@NotBlank String tripDate) {
		super();
		this.id = id;
		this.available_seats = available_seats;
		this.tripDate = tripDate;
		this.trip_detail = trip_detail;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTripDate() {
		return tripDate;
	}

	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}

	public int getAvailable_seats() {
		return available_seats;
	}

	public void setAvailable_seats(int available_seats) {
		this.available_seats = available_seats;
	}

	public Long getTrip_detail() {
		return trip_detail;
	}

	public void setTrip_detail(Long trip_detail) {
		this.trip_detail = trip_detail;
	}
}
