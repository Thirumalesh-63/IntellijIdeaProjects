package com.Ecoins.EWaste.Service;

import com.Ecoins.EWaste.DTO.IdentityListenerResponse;
import com.Ecoins.EWaste.Model.IdentityUserDetailsMapper;
import com.Ecoins.EWaste.Model.UserDetails;
import com.Ecoins.EWaste.Repository.SQLQueries;
import com.Ecoins.EWaste.Repository.UsersRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class Service1 {

    private static final Logger log = LoggerFactory.getLogger(Service1.class);

    @Autowired
    private IdentityUserDetailsMapper identityUserDetailsMapper;


    @Autowired
    private SQLQueries quiries;


    @Autowired
    private UsersRepository userDetailsRepository;

    public int upsertUserDetails(String jsonUserIdentityLiteral) {
        log.info("START of processing of method upsertUserDetails");

        try {
            IdentityListenerResponse identityListenerResponse =
                    new ObjectMapper().readValue(jsonUserIdentityLiteral, IdentityListenerResponse.class);

            UserDetails userDetails = UserDetails.builder().build();
            identityUserDetailsMapper.updateIdentityUserProfileData(
                    identityListenerResponse.getIdentityData(), userDetails);
            int userId = userDetails.getUSER_ID();
//            Integer count= quiries.findById(Integer.parseInt(userId));

            if (userId>0) {
                quiries.updateRecord(userDetails);
                // Process the user data as needed
            } else {
                quiries.saveRecord(userDetails);
            }


            return userId;
        } catch (Exception e) {
            log.error("Identity Service upsertUserDetails() failed", e);
            return 0;
        }
    }

    public UserDetails getUser(){
        UserDetails user= new UserDetails();
        user.setId(1);
        user.setUSER_ID(34);
        return user;
    }

    public String upsertUserDetails2(UserDetails userDetails) {

        quiries.saveRecord(userDetails);
        return "success";
    }
}
