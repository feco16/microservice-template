package com.ludisy.ludisygateway.SERVICE_UserManagement.converter;

import com.ludisy.ludisygateway.SERVICE_UserManagement.dto.ApplicationUserDTO;
import com.ludisy.ludisygateway.SERVICE_UserManagement.model.ApplicationUser;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class ApplicationUserConverter implements Converter<ApplicationUserDTO, ApplicationUser> {

    @Override
    public ApplicationUser convert(ApplicationUserDTO source) {
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setBirthDate(source.getBirthDate());
        applicationUser.setCoundDownSec(source.getCoundDownSec());
        applicationUser.setDisplayName(source.getDisplayName());
        applicationUser.setGender(source.getGender());
        applicationUser.setHeight(source.getHeight());
        applicationUser.setPhotoUrl(source.getPhotoUrl());
        applicationUser.setUserId(source.getUserId());
        applicationUser.setWeight(source.getWeight());
        applicationUser.setUsername(source.getUsername());
        applicationUser.setPassword(source.getPassword());
        applicationUser.setWorkouts(new ArrayList<>());

        return applicationUser;
    }
}
