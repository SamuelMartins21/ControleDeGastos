package com.example.controledegastos.models;

import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;

import com.example.controledegastos.enums.Rolename;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ROLE")
public class RoleModel implements GrantedAuthority {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID roleId;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = false)
    private Rolename rolename;

    @Override
    public String getAuthority() {
        return this.rolename.toString();
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public Rolename getRolename() {
        return rolename;
    }

    public void setRolename(Rolename rolename) {
        this.rolename = rolename;
    }

}
