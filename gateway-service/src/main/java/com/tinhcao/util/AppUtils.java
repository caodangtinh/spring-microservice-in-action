//package com.tinhcao.util;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//import com.tinhcao.security.dto.Authority;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author tinhcao
// */
//
//public class AppUtils {
//
//    public static List<GrantedAuthority> getAuthorities(List<Authority> authorities) {
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        for (Authority authority : authorities) {
//            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
//        }
//        return grantedAuthorities;
//    }
//
//}
