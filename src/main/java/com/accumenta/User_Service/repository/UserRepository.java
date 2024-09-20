package com.accumenta.User_Service.repository;

import com.accumenta.User_Service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "SELECT * FROM user WHERE user_number = ?1",nativeQuery = true)
    User findByUserNumber(long userMobileNumber);
}
