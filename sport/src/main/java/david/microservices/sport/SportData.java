package david.microservices.sport;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class SportData {
    @Getter(AccessLevel.NONE)
    long id;
    int userID;
    String date; //muss Format YYYY-MM-DD haben
    String type;
    int amount = 0;
    double time = 0;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }
}