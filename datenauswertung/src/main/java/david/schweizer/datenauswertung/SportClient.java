package david.schweizer.datenauswertung;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@FeignClient(name = "SportsClient", url = "http://localhost:8081")
public interface SportClient {

    @GetMapping("/users/{id}/sports")
    public ArrayList<SportData> getUserSports(@PathVariable("id") int id);

    @GetMapping("/users/{id}/sports")
    public ArrayList<SportData> getSportDataWithType(@PathVariable("id") int id, @RequestParam(defaultValue = "", required = false, value = "type") String type);

}
