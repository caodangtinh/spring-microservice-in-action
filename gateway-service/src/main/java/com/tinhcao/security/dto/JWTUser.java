package com.tinhcao.security.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JWTUser implements Serializable {
    private static final long serialVersionUID = 3267450506466650330L;

    private Long id;
    private String name;
    private String username;
    private String email;
    private List<Authority> authorities;
}
