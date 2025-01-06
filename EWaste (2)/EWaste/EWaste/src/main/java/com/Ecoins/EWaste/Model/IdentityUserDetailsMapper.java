package com.Ecoins.EWaste.Model;

import com.Ecoins.EWaste.DTO.IdentityListenerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface IdentityUserDetailsMapper {

    @Mapping(source = "identityData.userId", target = "USER_ID")
    @Mapping(source = "identityData.userCreatedTime", target = "CREATED_DT_BY", dateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @Mapping(source = "identityData.lastModifiedTime", target = "UPDATED_DT_BY", dateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    void updateIdentityUserProfileData(IdentityListenerResponse.IdentityData identityData, @MappingTarget UserDetails userDetails);

    default OffsetDateTime map(String value) {
        return OffsetDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

}
