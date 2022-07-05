package com.adam.bus.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adam.bus.model.Stop;
import com.adam.bus.payload.request.StopRequest;
import com.adam.bus.payload.response.MessageResponse;
import com.adam.bus.repository.StopRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/stop")
public class StopController {

	@Autowired
	StopRepository stopRepository;

	@GetMapping("/")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	public ResponseEntity<?> getAllStops() {
		return ResponseEntity.ok(stopRepository.findAll());
	}

	@PostMapping("/")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	public ResponseEntity<?> addStop(@Valid @RequestBody Stop stop) {
		return ResponseEntity.ok(stopRepository.save(stop));
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateStop(@PathVariable(value = "id") Long id,
			@Valid @RequestBody StopRequest stopRequest) {
		Stop stop = stopRepository.findById(id).get();
//		Agency agency = agencyRepository.findById(busDetail.getAgencyId()).get();
		if (stop == null) {
			return ResponseEntity.notFound().build();
		}
		stop.setCode(stopRequest.getCode());
		stop.setName(stopRequest.getName());
		stop.setDetail(stopRequest.getDetail());
//		bus.setAgency(agency);

		Stop updatedStop = stopRepository.save(stop);

		return ResponseEntity.ok(new MessageResponse<Stop>(true, "Success Updating Data", updatedStop));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteStop(@PathVariable(value = "id") Long id) {
		String result = "";
		try {
			stopRepository.findById(id).get();

			result = "Data with id: " + id + " is deleted";
			stopRepository.deleteById(id);

			return ResponseEntity.ok(new MessageResponse<Stop>(true, result));
		} catch (Exception e) {
			result = "Data with id: " + id + " not found";
			return ResponseEntity.ok(new MessageResponse<Stop>(false, result));
		}
	}
}