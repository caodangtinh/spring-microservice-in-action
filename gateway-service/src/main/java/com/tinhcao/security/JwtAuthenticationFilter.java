//package com.tinhcao.security;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.tinhcao.constant.GatewayConstant;
//import com.tinhcao.security.dto.JWTUser;
//import com.tinhcao.security.dto.UserPrincipal;
//import com.tinhcao.util.AppUtils;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Slf4j
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private JwtTokenProvider tokenProvider;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        try {
//            String jwt = getJwtFromRequest(request);
//            if (StringUtils.hasText(jwt)) {
//                String subject = tokenProvider.validateToken(jwt);
//                if (StringUtils.hasText(subject)) {
//                    JWTUser jwtUser = objectMapper.readValue(subject, JWTUser.class);
//                    //
//                    UserPrincipal userPrincipal = new UserPrincipal(jwtUser.getId(), jwtUser.getName(), jwtUser.getUsername(), null, null, AppUtils.getAuthorities(jwtUser.getAuthorities()));
//                    //
//                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userPrincipal, null, AppUtils.getAuthorities(jwtUser.getAuthorities()));
//                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                }
//            }
//        } catch (Exception ex) {
//            log.error("Could not set user authentication in security context", ex);
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//    private String getJwtFromRequest(HttpServletRequest request) {
//        String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);
//        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(GatewayConstant.BEARER_TOKEN)) {
//            return bearerToken.substring(GatewayConstant.BEARER_TOKEN.length());
//        }
//        return null;
//    }
//
//
//}
