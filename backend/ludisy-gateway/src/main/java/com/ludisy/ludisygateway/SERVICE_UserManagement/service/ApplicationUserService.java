package com.ludisy.ludisygateway.SERVICE_UserManagement.service;

import com.ludisy.ludisygateway.SERVICE_UserManagement.converter.ApplicationUserDTOConverter;
import com.ludisy.ludisygateway.SERVICE_UserManagement.dto.ApplicationUserDTO;
import com.ludisy.ludisygateway.SERVICE_UserManagement.dto.JwtRequest;
import com.ludisy.ludisygateway.SERVICE_UserManagement.dto.JwtResponse;
import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;
import com.ludisy.ludisygateway.SERVICE_UserManagement.repository.ApplicationUserRepository;
import com.ludisy.ludisygateway.SERVICE_UserManagement.security.JwtTokenUtil;
import com.ludisy.ludisygateway.SERVICE_UserManagement.security.JwtUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationUserService.class);

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    ApplicationUserDTOConverter applicationUserDTOConverter;

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    public ResponseEntity<?> authenticate(JwtRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);


        return ResponseEntity.ok(new JwtResponse(token));
    }

    public ApplicationUser getById(String userId) {
        logger.info("Get application user with id {}", userId);
        ApplicationUser applicationUser = applicationUserRepository.findByUserId(userId);
        return applicationUser;
    }

    public ApplicationUserDTO getDTOById(String userId) {
        ApplicationUserDTO applicationUserDTO = applicationUserDTOConverter.convert(getById(userId));

        return applicationUserDTO;
    }
}
