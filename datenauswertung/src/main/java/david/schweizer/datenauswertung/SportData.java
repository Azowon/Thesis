package david.schweizer.datenauswertung;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SportData {
    long id;
    int userID;
    String date; //muss Format YYYY-MM-DD haben
    String sportart;
    int amount = 0;
    double time = 0;
}
