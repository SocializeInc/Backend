package com.socialize.backend.controller;

import com.socialize.backend.bl.request.SearchRequest;
import com.socialize.backend.bl.response.LoginResponse;
import com.socialize.backend.bl.response.SearchResponse;
import com.socialize.backend.bl.response.SignupResponse;
import com.socialize.backend.persistence.repository.UserRepository;
import com.socialize.backend.persistence.domain.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/socialize/api/search")
public class SearchController {
    private final UserRepository userRepository;
    @Autowired
    public SearchController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users")
    public ResponseEntity<?> searchUsers(@RequestBody SearchRequest searchRequest) {

        System.out.println("Debug" + searchRequest.getData());
        if (Objects.equals(searchRequest.getData(), "")) {
            return ResponseEntity.badRequest().body(new SearchResponse("Error: No search data has been provided"));
        }

        List<User> users = userRepository.findByUsernameStartsWith(searchRequest.getData());

        return ResponseEntity.ok(new SearchResponse(users));

    }


}