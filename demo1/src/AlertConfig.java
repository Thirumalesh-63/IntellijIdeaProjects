import java.util.ArrayList;
import java.util.List;

class AlertConfig {
    private static List<AlertDetails> alertsList = new ArrayList<>();

    public static List<AlertDetails> getAlertsList() {
        return alertsList;
    }

    public static void setAlertsList(List<AlertDetails> alerts) {
        alertsList = alerts;
    }
}