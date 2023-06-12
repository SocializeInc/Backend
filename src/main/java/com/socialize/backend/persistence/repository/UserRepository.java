package com.socialize.backend.persistence.repository;

import com.socialize.backend.persistence.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query("FROM User WHERE id=:id")
    public Optional<User> findById(@Param("id") Long id);

    @Query("SELECT u FROM User u WHERE u.userId=:userId")
    public User getByUserId(@Param("userId") String userId);

    @Query("SELECT u FROM User u WHERE u.userName=:userName")
    public User findByUserName(@Param("user_name") String userName);






}
