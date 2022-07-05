package com.adam.bus.controller;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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

import com.adam.bus.model.Agency;
import com.adam.bus.model.Stop;
import com.adam.bus.model.Ticket;
import com.adam.bus.model.TripSchedule;
import com.adam.bus.model.User;
import com.adam.bus.payload.request.AgencyRequest;
import com.adam.bus.payload.request.TicketRequest;
import com.adam.bus.payload.response.MessageResponse;
import com.adam.bus.repository.TicketRepository;
import com.adam.bus.repository.TripScheduleRepository;
import com.adam.bus.repository.UserRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {

	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	TripScheduleRepository tripScheduleRepository;

	@GetMapping("/")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	public ResponseEntity<?> getAllTickets() {
		List<TicketRequest> dataArrResult = new ArrayList<>();
		for (Ticket dataArr : ticketRepository.findAll()) {
			dataArrResult.add(new TicketRequest(dataArr.getId(), dataArr.getSeatNumber(), dataArr.getCancellable(),
					dataArr.getJourneyDate(), dataArr.getPassenger().getId(), dataArr.getTripSchedule().getId()));
		}
		return ResponseEntity.ok(new MessageResponse<TicketRequest>(true, "Success Retrieving Data", dataArrResult));
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getTicketById(@PathVariable(value = "id") Long id) {
		Ticket ticket = ticketRepository.findById(id).get();
		if (ticket == null) {
			return ResponseEntity.notFound().build();
		} else {
			TicketRequest dataResult = new TicketRequest(ticket.getId(), ticket.getSeatNumber(),
					ticket.getCancellable(), ticket.getJourneyDate(), ticket.getPassenger().getId(),
					ticket.getTripSchedule().getId());
			return ResponseEntity.ok(new MessageResponse<TicketRequest>(true, "Success Retrieving Data", dataResult));
		}
	}

	@PostMapping("/")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	public ResponseEntity<?> beliTiket(@Valid @RequestBody TicketRequest ticketRequest) {
		User user = userRepository.findById(ticketRequest.getPassengerId()).get();
		TripSchedule tripSchedule = tripScheduleRepository.findById(ticketRequest.getTripScheduleId()).get();
		Ticket ticket = new Ticket(ticketRequest.getSeatNumber(), ticketRequest.getCancellable(),
				ticketRequest.getJourneyDate(), user, tripSchedule);
		ticketRepository.save(ticket);
		return ResponseEntity.ok(new MessageResponse<Ticket>(true, "Success Adding Data"));
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> gantiTiket(@PathVariable(value = "id") Long id,
			@Valid @RequestBody TicketRequest ticketDetail) {
		Ticket ticket = ticketRepository.findById(id).get();
		User user = userRepository.findById(ticketDetail.getPassengerId()).get();
		TripSchedule tripSchedule = tripScheduleRepository.findById(ticketDetail.getTripScheduleId()).get();
		if (ticket == null) {
			return ResponseEntity.notFound().build();
		}
		ticket.setCancellable(ticketDetail.getCancellable());
		ticket.setJourneyDate(ticketDetail.getJourneyDate());
		ticket.setSeatNumber(ticketDetail.getSeatNumber());
		ticket.setPassenger(user);
		ticket.setTripSchedule(tripSchedule);

		Ticket gantiTiket = ticketRepository.save(ticket);

		return ResponseEntity.ok(new MessageResponse<Ticket>(true, "Success Updating Data"));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "", authorizations = { @Authorization(value = "apiKey") })
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteTicket(@PathVariable(value = "id") Long id) {
		String result = "";
		try {
			ticketRepository.findById(id).get();

			result = "Ticket with id: " + id + " is deleted";
			ticketRepository.deleteById(id);

			return ResponseEntity.ok(new MessageResponse<Stop>(true, result));
		} catch (Exception e) {
			result = "Ticket with id: " + id + " not found";
			return ResponseEntity.ok(new MessageResponse<Stop>(false, result));
		}
	}
}
