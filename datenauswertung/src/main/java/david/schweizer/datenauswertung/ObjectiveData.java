package david.schweizer.datenauswertung;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjectiveData {
    private long id;
    private int userId;
    private String type;
    private String kind;
    private boolean repetitive;
    private int amount;
    private String startDate;
    private String endDate;
}
