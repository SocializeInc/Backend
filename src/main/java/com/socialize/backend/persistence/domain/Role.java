package com.socialize.backend.persistence.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    public enum ERole {
        ROLE_USER,
        ROLE_ADMIN
    }

    @Id
    @SequenceGenerator(name = "role_seq", sequenceName = "role_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    private Long id;

    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(length = 20, name = "role")
    private ERole role;

    public Role() {

    }

    public Role(ERole role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        return id.equals(role.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role=" + role +
                '}';
    }
}
