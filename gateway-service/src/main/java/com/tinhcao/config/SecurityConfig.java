//package com.tinhcao.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.tinhcao.security.JwtAuthenticationEntryPoint;
//import com.tinhcao.security.JwtAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
//@ConditionalOnProperty(name = "app.security.enabled", havingValue = "true", matchIfMissing = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    private final JwtAuthenticationEntryPoint unauthorizedHandler;
//
//    @Autowired
//    public SecurityConfig(JwtAuthenticationEntryPoint unauthorizedHandler) {
//        this.unauthorizedHandler = unauthorizedHandler;
//    }
//
//    @Bean
//    public JwtAuthenticationFilter jwtAuthenticationFilter() {
//        return new JwtAuthenticationFilter();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .cors()
//                .and()
//	                .csrf()
//	                .disable()
//                .exceptionHandling()
//                .authenticationEntryPoint(unauthorizedHandler)
//                .and()
//	                .sessionManagement()
//	                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//	                .authorizeRequests()
//	                .anyRequest()
//	                .permitAll();
//
//        // Add our custom JWT security filter
//        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//    }
//}