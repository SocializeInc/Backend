package com.socialize.backend.persistence.repository;

import com.socialize.backend.persistence.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    List<User> findByUsernameStartsWith(String username);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Query("SELECT u.username FROM User u WHERE u.id = :id")
    String findUsernameById(Long id);

    @Query("SELECT u.id FROM User u WHERE u.username = :username")
    Long findIdByUsername(String username);

    @Query("SELECT u.firstname FROM User u WHERE u.username = :username")
    String findFirstNameByUsername(String username);

    @Query("SELECT u.lastname FROM User u WHERE u.username = :username")
    String findLastNameByUsername(String username);



}
