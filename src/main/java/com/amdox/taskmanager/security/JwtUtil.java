package com.amdox.taskmanager.security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	private final Key key;
	private final long expiration = 1 * 1000 * 60 * 60 * 24;

	public JwtUtil() {

		String secret = System.getenv("JWT_SECRET");

		if (!StringUtils.hasText(secret)) {
			secret = "secret";
		}

		key = Keys.hmacShaKeyFor(secret.getBytes());
	}

	public String generateToken(String subject) {
		Date now = new Date();
		Date expiry = new Date(now.getTime() + expiration);

		return Jwts.builder().subject(subject).issuedAt(now).expiration(expiry).signWith(key, SignatureAlgorithm.HS256)
				.compact();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(key).build().parseSignedClaims(token);
			return true;
		} catch (JwtException e) {
			return false;
		}
	}

	public String getSubject(String token) {
		return Jwts.parser().setSigningKey(key).build().parseSignedClaims(token).getPayload().getSubject();
	}

}
