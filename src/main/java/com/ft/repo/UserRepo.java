package com.ft.repo;

import com.ft.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserInfo,Integer> {

    Optional<UserInfo> findByName(String name);
}
