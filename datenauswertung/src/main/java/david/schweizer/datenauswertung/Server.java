package david.schweizer.datenauswertung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Server {
    @Autowired
    private Logic logic;

    @GetMapping("users/{id}/data")
    public ArrayList<String> getData(@PathVariable("id") int id, @RequestParam(defaultValue = "", required = false, value = "type") String type) {
        if (type.equals(""))
            return logic.getAllData(id);
        else
            return logic.getData(id, type);
    }

}
