package com.ft.config;

import com.ft.entity.UserInfo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class userInfoUserDetails implements UserDetails {

    private String name;

    private String password;

    private List<GrantedAuthority> listOfAuthorities;


    userInfoUserDetails(UserInfo user){
        name=user.getName();
        password=user.getPassword();
        listOfAuthorities= Arrays.stream(user.getRoles()
                        .split(","))
                         .map(SimpleGrantedAuthority::new)
                          .collect(Collectors.toList());
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return listOfAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public  boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public  boolean isEnabled() {

        return true;
    }
}
