package com.microservice.userservice.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegexConstants {
	public static final String LOGIN_REGEX = "^[_.@A-Za-z0-9-]*$";
	public static final String EMAIL_REGEX = "^$|^(?:[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]){1,64}@(?:[a-zA-Z0-9à-á-â-ã-é-ê-í-ó-ô-õ-ú-ü-ç-]){2,64}\\.[a-zA-Z0-9]{1,10}(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,8}[a-zA-Z0-9])?)*$";
	public static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$^+=!*()@%&]).{6,}$";
}
