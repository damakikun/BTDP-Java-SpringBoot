package com.adam.bus.payload.request;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.adam.bus.model.Agency;

import io.swagger.annotations.ApiModelProperty;

public class BusCustomRequest {
	
	@ApiModelProperty(hidden = true)
	private Long id;

	private String code;

	private int capacity;

	private String make;

//	@ApiModelProperty(hidden = true)
	private Agency agencyId;
	
	@Override
	public int hashCode() {
		return Objects.hash(agencyId, capacity, code, id, make);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BusCustomRequest other = (BusCustomRequest) obj;
		return Objects.equals(agencyId, other.agencyId) && capacity == other.capacity
				&& Objects.equals(code, other.code) && Objects.equals(id, other.id) && Objects.equals(make, other.make);
	}

	@Override
	public String toString() {
		return "BusCustomRequest [id=" + id + ", code=" + code + ", capacity=" + capacity + ", make=" + make
				+ ", agencyId=" + agencyId + ", hashCode()=" + hashCode() + ", getId()=" + getId() + ", getCode()="
				+ getCode() + ", getCapacity()=" + getCapacity() + ", getMake()=" + getMake() + ", getAgencyId()="
				+ getAgencyId() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

	
	public BusCustomRequest() {
		super();
	}

	public BusCustomRequest(Long id, @NotNull int capacity, @NotBlank String code, @NotBlank String make,
			@NotBlank Agency agencyId) {
		super();
		this.id = id;
		this.capacity = capacity;
		this.code = code;
		this.make = make;
		this.agencyId = agencyId;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public Agency getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Agency agencyId) {
		this.agencyId = agencyId;
	}
}
