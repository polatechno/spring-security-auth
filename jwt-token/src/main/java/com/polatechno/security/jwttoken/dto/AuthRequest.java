package com.polatechno.security.jwttoken.dto;

public record AuthRequest(
        String username,
        String password

) {
}
