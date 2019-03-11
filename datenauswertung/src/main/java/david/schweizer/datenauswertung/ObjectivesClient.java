package david.schweizer.datenauswertung;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@FeignClient(name = "ObjectivesClient", url = "http://localhost:8082")
public interface ObjectivesClient {

    @GetMapping("/users/{id}/objectives?type={type}")
    public ArrayList<ObjectiveData> getUserObjectives(@PathVariable("id") int id, @PathVariable("type") String type);

    @GetMapping("/users/{id}/objectives")
    public ArrayList<ObjectiveData> getObjectiveDataById(@PathVariable("id") int id);
}
