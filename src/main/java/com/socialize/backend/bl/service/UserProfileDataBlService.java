package com.socialize.backend.bl.service;

import com.socialize.backend.controller.dto.response.UserProfileDataResponse;
import com.socialize.backend.exception.ErrorCodeException;
import com.socialize.backend.security.service.UserDetailsImpl;
import com.socialize.backend.util.ErrorCode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserProfileDataBlService {

    public UserProfileDataResponse getData() {
        UserProfileDataResponse response;

        try {
            final UserDetailsImpl userPrincipal = getPrincipal();

            if (userPrincipal != null) {
                response = getProfileData(userPrincipal);
            } else {
                throw new ErrorCodeException(ErrorCode.INVALID_USER_PRINCIPAL);
            }

        } catch (ErrorCodeException e) {
            response = new UserProfileDataResponse();
            response.addErrorCode(e.getErrorCode());
        } catch (Exception e) {
            response = new UserProfileDataResponse();
            response.addErrorCode(ErrorCode.GENERAL_ERROR);
        }

        return response;
    }

    private UserDetailsImpl getPrincipal() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return userPrincipal;
    }

    private UserProfileDataResponse getProfileData(final UserDetailsImpl userPrincipal) {

        UserProfileDataResponse response = new UserProfileDataResponse();
        response.setUsername(userPrincipal.getUsername());
        response.setFirstname(userPrincipal.getFirstname());
        response.setLastname(userPrincipal.getLastname());
        response.setEmail(userPrincipal.getEmail());
        response.setCountry(userPrincipal.getCountry());
        response.setDescription(userPrincipal.getDescription());
        response.setBirthDate(userPrincipal.getBirthDate());

        return response;
    }
}
