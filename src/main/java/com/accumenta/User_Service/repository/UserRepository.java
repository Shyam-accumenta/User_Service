package com.accumenta.User_Service.repository;

import com.accumenta.User_Service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
