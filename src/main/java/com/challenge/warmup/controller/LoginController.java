package com.challenge.warmup.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.challenge.warmup.model.User;
import com.challenge.warmup.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginController {

    @PostMapping("/auth/login")
	public User login(@RequestParam("user") String username, @RequestParam("password") String password) {
        
        String token = getJWTToken(username);
        User user = new User();    
        user.setEmail(username);
        user.setPassword(password);
        user.setToken(token);		
        return user;
		
	}

    private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}


    // private boolean isAuthenticated() {
    //     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    //     if (authentication == null || AnonymousAuthenticationToken.class.isAssignableFrom(authentication.getClass())) {
    //         return false;
    //     }
    //     return authentication.isAuthenticated();
    //     }
    
}
