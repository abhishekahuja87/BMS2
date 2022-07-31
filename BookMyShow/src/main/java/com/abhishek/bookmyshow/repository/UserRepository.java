package com.abhishek.bookmyshow.repository;


import com.abhishek.bookmyshow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT DISTINCT u.* from user u where u.mobile=:mobile", nativeQuery = true)
    User getByMobileNumber(@Param("mobile") String mobile);
}
