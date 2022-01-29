package com.application.bookstore.repository;

import com.application.bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Repository : Creating Repository
 */
@Repository
public interface BookStoreUserRepository extends JpaRepository<User,Long> {
    @Query("select user from User user where user.mobileNumber=:userMobile or user.password=:pass")
    public User getUserDetails(@Param("userMobile") String mobileNumber, @Param("pass") String password);

    @Query("select user from User user where user.mobileNumber=:userMobile")
    public User getUserDetails(@Param("userMobile") String mobileNumber);
}
