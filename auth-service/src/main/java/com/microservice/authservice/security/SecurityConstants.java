package com.microservice.authservice.security;

public class SecurityConstants {

    private SecurityConstants() {}

    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5L * 60L * 60L;

    public static final String SIGNING_KEY = "ekaizen";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String AUTHORITIES_KEY = "roles";
    public static final String USER_IMAGE = "imgUser";
    public static final String USER_ID = "userID";
    public static final String USER_NAME = "userName";
    public static final String IS_FIRST_LOGIN = "isFirstLogin";

}
