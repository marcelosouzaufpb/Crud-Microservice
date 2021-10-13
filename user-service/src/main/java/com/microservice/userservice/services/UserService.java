package com.microservice.userservice.services;

import com.microservice.userservice.domains.User;
import com.microservice.userservice.dtos.UserDTO;
import com.microservice.userservice.exceptions.NotFoundException;
import com.microservice.userservice.repositories.UserRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.microservice.userservice.utils.MessageExceptionConstants.GENERAL_NOT_FOUND_EXCEPTION;

@Service
public class UserService {

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	private final UserRepository repository;

	public User save(UserDTO dto) {
		return repository.save(new User(dto));
	}

	public UserDTO findById(Long id) {
		return new UserDTO(
				repository.findById(id).orElseThrow(() -> new NotFoundException(GENERAL_NOT_FOUND_EXCEPTION)));
	}

	public Page<UserDTO> findAll(Pageable pageable, String email) {
		return Strings.isEmpty(email) ? repository.findAll(pageable).map(UserDTO::new)
				: repository.findAllByEmailContainingIgnoreCase(pageable, email).map(UserDTO::new);
	}

}
