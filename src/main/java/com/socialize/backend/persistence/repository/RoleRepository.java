package com.socialize.backend.persistence.repository;

import com.socialize.backend.persistence.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {

    @Query("FROM Role WHERE id=:id")
    public Optional<Role> findById(@Param("id") Long id);

    @Query("SELECT r FROM Role r WHERE r.role=:role")
    public Role getByRole(@Param("role")Enum<Role.ERole> role);
}
