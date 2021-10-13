package com.microservice.userservice.controllers;

import com.microservice.userservice.dtos.UserDTO;
import com.microservice.userservice.utils.ResponseUtils;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.microservice.userservice.services.UserService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;

import static com.microservice.userservice.utils.UrlConstants.*;

@RestController
@AllArgsConstructor
@Log4j2
@RequestMapping(USER_URL)
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping
	public ResponseEntity<URI> save(@Valid @NotNull @RequestBody UserDTO user) {
		return ResponseEntity.ok().location(ResponseUtils.toURI(service.save(user).getId())).build();
	}

	@GetMapping
	public ResponseEntity<Page<UserDTO>> findAll(@RequestParam(required = false) String email, Pageable pageable) {
		pageable = PageRequest.of(pageable.getPageNumber(),pageable.getPageSize());
		return ResponseEntity.ok(service.findAll(pageable, email));
	}

	@GetMapping(PARAMS_ID)
	public ResponseEntity<UserDTO> findById(@Valid @NotNull @PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
}
