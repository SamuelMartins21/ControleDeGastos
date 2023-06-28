package com.example.controledegastos.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controledegastos.models.RoleModel;
import com.example.controledegastos.repositories.RoleRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RoleService {
    
    @Autowired
    private RoleRepository roleRepository;

    public RoleModel save(RoleModel roleModel){
        return roleRepository.save(roleModel);
    }
}
