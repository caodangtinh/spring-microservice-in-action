//package com.tinhcao.security;
//
//import io.jsonwebtoken.*;
//import io.jsonwebtoken.impl.TextCodec;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//public class JwtTokenProvider {
//
//    @Value("${app.security.jwtSecret}")
//    private String jwtSecret;
//
//    @Value("${app.security.accessTokenExpiration}")
//    private int accessTokenExpiration;
//
//    @Value("${app.security.refreshTokenExpiration}")
//    private int refreshTokenExpiration;
//
//    public String validateToken(String authToken) {
//        try {
//            return Jwts.parser()
//                    .setSigningKey(TextCodec.BASE64.encode(jwtSecret))
//                    .parseClaimsJws(authToken)
//                    .getBody()
//                    .getSubject();
//        } catch (SignatureException ex) {
//            log.error("Invalid JWT signature");
//        } catch (MalformedJwtException ex) {
//            log.error("Invalid JWT token");
//        } catch (ExpiredJwtException ex) {
//            log.error("Expired JWT token");
//        } catch (UnsupportedJwtException ex) {
//            log.error("Unsupported JWT token");
//        } catch (IllegalArgumentException ex) {
//            log.error("JWT claims string is empty.");
//        }
//        return null;
//    }
//
//}
