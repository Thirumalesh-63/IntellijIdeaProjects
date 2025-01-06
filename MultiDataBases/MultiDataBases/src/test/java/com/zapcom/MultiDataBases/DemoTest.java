package com.zapcom.MultiDataBases;

public class DemoTest {


    @Monitor

    public Integer userEntitlements (String jsonUserEntitlementsLiteral) {

        log.info("START of processing of method userEntitlements");

        try {
            jsonUserEntitlementsLiteral = AlertsUtil.decodeJsonString(jsonUserEntitlementsLiteral);
            SingleUserEntitlements singleUserEntitlements

                    = objectMapper.readValue(jsonUserEntitlementsLiteral, SingleUserEntitlements.class);

                    String userId = singleUserEntitlements.getUserDetails().get(0).idStoreuserkey;

            log.error("User Entitlements Service userEntitlements() user id -{}", userId);

            if (userId != null) {

                JsonNode alertsJsonNode = alertSettingsService.getUserAlerts(userId);

                log.error("User Entitlements {}", alertsJsonNode);

                JsonNode userAlerts = alertsJsonNode.path("result").path( "userAlerts").get(0);

                JsonNode acctAlerts = userAlerts.path( "acctAlerts");
                List<String> accountCategories = new ArrayList<>();

                acctAlerts.fieldNames().forEachRemaining (accountCategories::add);

                log.info("All accountCategories: {}", accountCategories);

                List<String> accountAlertIds = new ArrayList<>();

                for (String categoryName: accountCategories) {

                    JsonNode categoryAlerts = acctAlerts.path(categoryName);
                    categoryAlerts.fields().forEachRemaining (field -> {

                        JsonNode value = field.getValue();

                        if (value.isBoolean() && value.asBoolean() == false) {

                            return;

                        }

                        accountAlertIds.add(field.getKey());

                    });

                }

                log.info("User Entitlements Service userEntitlements() size is-{}", accountAlertIds.size());

                List<String> userAllAlertsDB = userAlertsRepository.fetchUserAlerts(userId);

                log.info("User Entitlements Service userEntitlements() sizeInDB is-{}", userAllAlertsDB.size());

                List<String> unmatchedList = new ArrayList<>(accountAlertIds);

                unmatchedList.removeAll(userAllAlertsDB);

                List<String> unmatched = new ArrayList<>();

                unmatched.addAll(unmatchedList);
                log.info("User Entitlements Service userEntitlements() unmatched is-{}", unmatched);

                Integer count =0;
                for (String alertId: unmatched) {

                    log.info("getAlertAccounts calling for userId={}, alertId={}", userId, alertId);

                    List<AlertDetails> alertsList = AlertConfig.getAlertsList();

                    AlertDetails alertDetailsList = alertsList.stream().filter(alertids -> alertids.getAlertId().equals(alertId)).find();

                    if (alertDetailsList.isDefault() || alertDetailsList.isMandatory()) {

                        JsonNode alertAccounts = alertSettingsService.getAlertAccounts (userId, alertId);

                        log.info("getAlertAccounts: alertAccounts ={}", alertAccounts);

                        JsonNode alertAccountsResult = objectMapper.readTree(alertAccounts.toString());

                        JsonNode resultArrayNode = alertAccountsResult.get("result");

                        List<UserAlertAccounts> userAlertAccounts = objectMapper.readValue(resultArrayNode.path( "userAlertAccounts");

                        log.info("userAlertAccounts: userAlertAccounts ={}", userAlertAccounts);

                        for (UserAlertAccounts userAlertAccount: userAlertAccounts) {

                            count = userAlertsRepository.saveUserAlertAccountDetails (userAlertAccount, alertDetailsList, userId);

                            log.info("count: count ={}", count);

                        }
                    }
                }
                return count;
            } else {

                log.error("User Entitlements Service userEntitlements() user id is empty");

                return 0;

            } catch (Exception e) {

                log.error("Identity Service upsertUserDetails() Call Exception, message={}", e.getMessage());

                return 0;



            }
        }

    }
}
