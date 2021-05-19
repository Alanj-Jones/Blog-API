package com.challenge.warmup.security;

import com.challenge.warmup.model.User;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import static java.lang.String.format;

import java.util.Date;

@Component
public class JwtTokenUtil {
    
    private final String jwtSecret = "zdtlD3JK56m6wTTgsNFhqzjqP";
    private final String jwtIssuer = "example.io";

    public String generateAccessToken(User user) {
        return Jwts.builder()
                    .setSubject(format("%s,%s", user.getUserId(), user.getUsername()))
                    .setIssuer(jwtIssuer)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000)) // 1 Semana
                    .signWith(SignatureAlgorithm.HS512, jwtSecret)
                    .compact();
    }

    public String getUserId(String token) {
        Claims claims = Jwts.parser()
                            .setSigningKey(jwtSecret)
                            .parseClaimsJws(token)
                            .getBody();

        return claims.getSubject().split(",")[0];
    }

    public String getUsername(String token) {
        Claims claims = Jwts.parser()
                            .setSigningKey(jwtSecret)
                            .parseClaimsJws(token)
                            .getBody();

        return claims.getSubject().split(",")[1];
    }

    public Date getExpirationDate(String token) {
        Claims claims = Jwts.parser()
                            .setSigningKey(jwtSecret)
                            .parseClaimsJws(token)
                            .getBody();

        return claims.getExpiration();
    }

    public boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            System.out.print("Invalid JWT signature - {}" + ex.getMessage());
        } catch (MalformedJwtException ex) {
            System.out.print("Invalid JWT token - {}" + ex.getMessage());
        } catch (ExpiredJwtException ex) {
            System.out.print("Expired JWT token - {}" + ex.getMessage());
        } catch (UnsupportedJwtException ex) {
            System.out.print("Unsupported JWT token - {}" + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            System.out.print("JWT claims string is empty - {}" + ex.getMessage());
        }
        return false;
    }
    
}
