package david.microservices.sport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SportDataJpaRespository  extends JpaRepository<SportData, Long> {

    List<SportData> findByUserID(int id);
    List<SportData> findByUserIDAndType(int id, String type);


}
