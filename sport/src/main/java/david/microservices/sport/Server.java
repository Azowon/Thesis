package david.microservices.sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Server {

    @Autowired
    private Logic logic;

    @PostMapping(value = "/users/{id}/sports", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createSpotsData(@PathVariable("id") int id, @RequestBody SportData sportData) {
        sportData.setUserID(id);
        logic.insert(sportData);
    }

    @PutMapping(value = "/users/{id}/sports/{sportsid}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateSportsData(@PathVariable("sportsid") long sportsid, @RequestBody SportData sportData) {

        sportData.setId(sportsid);
        logic.insert(sportData);
    }

    @DeleteMapping("/users/{userid}/sports/{id}")
    public void deleteSportsData(@PathVariable("id") long id) {logic.deleteSportsData(id); }

   @GetMapping("/sports")
    public List<SportData> getAll() {
        return logic.getAll();
   }

   @GetMapping("users/{id}/sports") // http://localhost:8080/users/1/sports?type=running
    public List<SportData> getUserActivity(@PathVariable("id") int id, @RequestParam(defaultValue = "", required = false, value = "type") String type) {
       if (type.equals("")) {
           return logic.getUserSportsById(id);
       }
       return logic.getSportsType(id, type);
   }
}
