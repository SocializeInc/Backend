package com.socialize.backend.controller;

import com.socialize.backend.bl.dto.request.SearchRequest;
import com.socialize.backend.bl.dto.response.SearchResponse;
import com.socialize.backend.persistence.repository.UserRepository;
import com.socialize.backend.persistence.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> searchUsers(@RequestBody SearchRequest searchRequest) {

        System.out.println("Debug" + searchRequest.getData());
        if (Objects.equals(searchRequest.getData(), "")) {
            return ResponseEntity.badRequest().body(new SearchResponse("Error: No search data has been provided"));
        }

        List<User> users = userRepository.findByUsernameStartsWith(searchRequest.getData());

        return ResponseEntity.ok(new SearchResponse(users));

    }


}