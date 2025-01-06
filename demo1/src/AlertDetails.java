
class AlertDetails {
    private String alertId;
    private char isMandatory;
    private char isDefault;

    public AlertDetails(String alertId, char isMandatory, char isDefault) {
        this.alertId = alertId;
        this.isMandatory = isMandatory;
        this.isDefault = isDefault;
    }

    public String getAlertId() {
        return alertId;
    }

    public char getIsMandatory() {
        return isMandatory;
    }

    public char getIsDefault() {
        return isDefault;
    }

    @Override
    public String toString() {
        return "AlertDetails{alertId='" + alertId + "', isMandatory=" + isMandatory + ", isDefault=" + isDefault + "}";
    }
}
