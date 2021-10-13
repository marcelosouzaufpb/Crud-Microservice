package com.microservice.userservice.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.microservice.userservice.domains.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.microservice.userservice.utils.RegexConstants.EMAIL_REGEX;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	public static final int PASSWORD_MIN_LENGTH = 6;

	private Long id;

	@Pattern(regexp = EMAIL_REGEX, message = "{error.user.email.pattern}")
	@NotEmpty(message = "{info.user.email.notEmpty}")
	private String email;

	private String password;

	@NotNull(message = "{info.user.profileId.notnull}")
	private ProfileDTO profile;

	public UserDTO(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.password = user.getPassword();
	}
}
