package com.ft.config;

import com.ft.entity.UserInfo;
import com.ft.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> optional = userRepo.findByName(username);

        if (optional.isPresent()) {
            UserInfo userInfo = optional.get();
            return new userInfoUserDetails(userInfo); // Pass the UserInfo object directly
        }
        throw new UsernameNotFoundException("User not found");
    }
}
