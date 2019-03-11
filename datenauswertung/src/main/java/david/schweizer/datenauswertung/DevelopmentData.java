package david.schweizer.datenauswertung;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DevelopmentData {
    private long id;
    private int userID;
    private String activity;
    private String date;
    private int amount;
    private double time;
}
