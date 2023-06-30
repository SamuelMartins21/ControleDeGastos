package com.example.controledegastos.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.controledegastos.Services.RoleService;
import com.example.controledegastos.Services.UserService;
import com.example.controledegastos.enums.Rolename;
import com.example.controledegastos.models.RoleModel;
import com.example.controledegastos.models.UserModel;

@RestController
@Secured("permitAll")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CadastroController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleService roleService;

    @PostMapping("/saveuser")
    public ResponseEntity<Object> saveUser(@RequestBody UserModel userModel) {
        RoleModel role = new RoleModel();
        role.setRolename(Rolename.ROLE_USER);

        RoleModel savedRole = roleService.save(role); 

        List<RoleModel> roles = new ArrayList<>();
        roles.add(savedRole);

        userModel.setRoles(roles);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = userModel.getPassword();
        String hashedPassword = passwordEncoder.encode(password);

        userModel.setPassword(hashedPassword);

        UserModel savedUser = userService.save(userModel);

        return ResponseEntity.ok(savedUser);
    }
}