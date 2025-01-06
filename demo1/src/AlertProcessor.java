import java.util.*;
import java.util.stream.*;

public class AlertProcessor {

    public static void main(String[] args) {
        // Static data for demonstration
        List<AlertDetails> staticAlerts = List.of(
                new AlertDetails("A1", 'Y', 'N'),
                new AlertDetails("A2", 'N', 'Y'),
                new AlertDetails("A3", 'N', 'N'),
                new AlertDetails("A4", 'Y', 'Y')
        );
        AlertConfig.setAlertsList(staticAlerts);

        String alertId = "A1";
        Optional<AlertDetails> alertsList = fetchAlertDetails(alertId);

        if(alertsList.isEmpty())
        {
            System.err.println("no match found");
        }
        System.err.println(alertsList);
//        if (alertsList.isEmpty()) {
//            return;
//        }

//        AlertDetails alertDetails = getAlertDetailsByAlertId(alertId, alertsList);
//        System.err.println(alertDetails);
//        if (alertDetails != null) {
//        }
    }

    private static Optional<AlertDetails> fetchAlertDetails(String alertId) {
        return  AlertConfig.getAlertsList().stream()
                .filter(alert -> alert.getAlertId().equals(alertId) &&
                        (alert.getIsMandatory() == 'Y' || alert.getIsDefault() == 'Y')).findFirst();
    }

    private static AlertDetails getAlertDetailsByAlertId(String alertId, List<AlertDetails> alertsList) {
        return alertsList.stream()
                .filter(alert -> alert.getAlertId().equals(alertId))
                .findFirst()
                .orElseGet(() -> {
                    return null;
                });
    }
}