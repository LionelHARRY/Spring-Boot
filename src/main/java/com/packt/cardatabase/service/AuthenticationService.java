package com.packt.cardatabase.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import static java.util.Collections.emptyList;

/**
 * 
 * JWT authentication
 *
 */
public class AuthenticationService {
	
	//Expiration for the token (1 day in this case)
	static final long EXPIRATION_TIME = 864_000_00;
	//Key used to digitally sign the JWT
	static final String SIGNING_KEY = "SecretKey";
	//The prefix of the token
	static final String PREFIX = "Bearer";
	
	//Add token to authorization header
	static public void addToken(HttpServletResponse res, String username) {
		String JwtToken = Jwts.builder().setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME ))
				.signWith(SignatureAlgorithm.HS512, SIGNING_KEY)
				.compact();
		
		res.addHeader("Authorization", PREFIX + " " + JwtToken);
		res.addHeader("Access-Control-Expose-Headers", "Authorization");
	}
	
	//Get token from authorization header
	static public Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token != null) {
			String user = Jwts.parser().setSigningKey(SIGNING_KEY)
					.parseClaimsJws(token.replace(PREFIX, "")).getBody().getSubject();
			
			if(user != null) {
				return new UsernamePasswordAuthenticationToken(user, null, emptyList());
			}
		}
		return null;
	}
}
