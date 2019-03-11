package david.schweizer.datenauswertung;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@FeignClient(name = "DevelopmentClient", url = "http://localhost:8084")
public interface DevelopmentClient {

    @GetMapping("/users/{id}/development")
    public ArrayList<DevelopmentData> getDevelopmentDataWithType(@PathVariable("id") int id, @RequestParam(defaultValue = "", required = false, value = "type") String type);

}
