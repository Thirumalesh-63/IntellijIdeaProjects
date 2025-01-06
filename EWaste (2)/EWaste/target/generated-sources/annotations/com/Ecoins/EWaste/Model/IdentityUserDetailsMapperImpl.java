package com.Ecoins.EWaste.Model;

import com.Ecoins.EWaste.DTO.IdentityListenerResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-22T12:56:42+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class IdentityUserDetailsMapperImpl implements IdentityUserDetailsMapper {

    @Override
    public void updateIdentityUserProfileData(IdentityListenerResponse.IdentityData identityData, UserDetails userDetails) {
        if ( identityData == null ) {
            return;
        }

        if ( identityData.getUserId() != null ) {
            userDetails.setUSER_ID( Integer.parseInt( identityData.getUserId() ) );
        }
        userDetails.setCREATED_DT_BY( map( identityData.getUserCreatedTime() ) );
        userDetails.setUPDATED_DT_BY( map( identityData.getLastModifiedTime() ) );
    }
}
