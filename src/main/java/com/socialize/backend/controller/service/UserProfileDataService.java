package com.socialize.backend.controller.service;

import com.socialize.backend.bl.service.UserProfileDataBlService;
import com.socialize.backend.controller.dto.response.UserProfileDataResponse;
import com.socialize.backend.exception.ErrorCodeException;
import com.socialize.backend.util.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserProfileDataService {

    private static final Logger logger = LoggerFactory.getLogger(UserProfileDataService.class);
    private final UserProfileDataBlService userDataService;

    @Autowired
    public UserProfileDataService(UserProfileDataBlService userDataService) {
        this.userDataService = userDataService;
    }

    public UserProfileDataResponse process() {
        UserProfileDataResponse response;

        try {
            logger.debug("UserProfileData process started");
            response = processRequest();

        } catch (ErrorCodeException e) {
            logger.warn("Error while processing UserProfileData");
            response = new UserProfileDataResponse();
            response.addErrorCode(e.getErrorCode());
        } catch (Exception e) {
            logger.error("Error while processing UserProfileData");
            response = new UserProfileDataResponse();
            response.addErrorCode(ErrorCode.GENERAL_ERROR);
        }

        return response;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected UserProfileDataResponse processRequest() throws ErrorCodeException {
        UserProfileDataResponse response = userDataService.getData();

        if (response != null) {
            return response;
        } else {
            throw new ErrorCodeException(ErrorCode.INVALID_PROFILE_DATA);
        }
    }
}
