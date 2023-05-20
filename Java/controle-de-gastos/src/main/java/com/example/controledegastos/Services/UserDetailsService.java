package com.example.controledegastos.Services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.controledegastos.models.UserModel;
import com.example.controledegastos.repositories.UserRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    final UserRepository userRepository;

    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Não foi Possível encontrar o nome de usuário: " + username));
        return new User(userModel.getUsername(), 
                userModel.getPassword(), 
                userModel.isEnabled(), 
                userModel.isAccountNonExpired(), 
                userModel.isCredentialsNonExpired() , 
                userModel.isAccountNonLocked(),
                userModel.getAuthorities());
    }

}
