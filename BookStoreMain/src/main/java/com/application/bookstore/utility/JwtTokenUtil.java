package com.application.bookstore.utility;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/***
 * @Component : Component of Application
 */

@Component
public class JwtTokenUtil implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String SECRET_KEY = "secret";

    /**
     * Method for Creating Token
     * @param claims
     * @param subject
     * @return
     */
    public String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    /**
     * Method For gnerating Token
     * @param username
     * @return
     */
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<String, Object>();
        return createToken(claims, username);
    }

    /**
     * method to get username from token
     * @param token
     * @return
     */
    public String getUsernameFromToken(String token) {
        Claims claim = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return claim.getSubject();
    }

    /**
     * method to Validate Token
     * @param token
     * @return
     */
    public boolean isValidToken(String token) {
        String username = getUsernameFromToken(token);
        if(username == null || username.equals(""))
            return false;
        return true;
    }
}