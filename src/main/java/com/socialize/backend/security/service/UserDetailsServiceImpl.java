package com.socialize.backend.security.service;

import com.socialize.backend.persistence.domain.User;
import com.socialize.backend.persistence.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userRepository.findByUserName(username);
            return UserDetailsImpl.build(user);
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException("User not found with username:" + username);
        }
    }

    @Transactional
    public UserDetails loadUserByEmail(String email) throws EmailNotFoundException {
        try {
            User user = userRepository.findByEmail(email);
            return UserDetailsImpl.build(user);
        } catch (EmailNotFoundException e) {
            throw new EmailNotFoundException("User not found with email: " + email);
        }
    }

    public static class EmailNotFoundException extends AuthenticationException {
        public EmailNotFoundException(String msg, Throwable cause) {
            super(msg, cause);
        }

        public EmailNotFoundException(String msg) {
            super(msg);
        }
    }
}
