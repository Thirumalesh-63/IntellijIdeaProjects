package com.Ecoins.EWaste.DTO;

public class IdentityListenerResponse {

    private IdentityData identityData;

    // Getters and Setters
    public IdentityData getIdentityData() { return identityData; }
    public void setIdentityData(IdentityData identityData) { this.identityData = identityData; }

    public static class IdentityData {
        private String userId;
        private String userCreatedTime;
        private String lastModifiedTime;

        // Getters and Setters
        public String getUserId() { return userId; }
        public void setUserId(String userId) { this.userId = userId; }
        public String getUserCreatedTime() { return userCreatedTime; }
        public void setUserCreatedTime(String userCreatedTime) { this.userCreatedTime = userCreatedTime; }
        public String getLastModifiedTime() { return lastModifiedTime; }
        public void setLastModifiedTime(String lastModifiedTime) { this.lastModifiedTime = lastModifiedTime; }
    }
}
