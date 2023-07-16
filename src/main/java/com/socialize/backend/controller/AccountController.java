package com.socialize.backend.controller;

import com.socialize.backend.controller.dto.response.UserProfileDataResponse;
import com.socialize.backend.controller.service.UserProfileDataService;
import com.socialize.backend.persistence.repository.UserRepository;
import com.socialize.backend.security.jwt.JwtUtils;
import com.socialize.backend.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/socialize/api/account")
public class AccountController {
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;
    private final UserProfileDataService userProfileDataService;

    @Autowired
    public AccountController(UserRepository userRepository, JwtUtils jwtUtils, UserProfileDataService userProfileDataService) {
        this.userRepository = userRepository;
        this.jwtUtils = jwtUtils;
        this.userProfileDataService = userProfileDataService;
    }

    @GetMapping("/getUsername")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return userPrincipal.getUsername();
    }

    @RequestMapping(value = "/getUserProfileData", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public @ResponseBody UserProfileDataResponse userDataCall() {
        return userProfileDataService.process();
    }

}
