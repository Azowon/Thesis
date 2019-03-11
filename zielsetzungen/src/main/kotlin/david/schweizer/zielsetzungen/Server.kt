package david.schweizer.zielsetzungen

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
class Server {
    @Autowired
    lateinit var logic: Logic


    @PostMapping(value = "/users/{id}/objectives", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun postData(@PathVariable("id") id: Int, @RequestBody data: Objective) {
        data.userID = id
        logic.insertData(data)
    }

    @PutMapping(value = "/users/{id}/objectives/{objectiveid}", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun putData(@PathVariable("objectiveid") id: Int, @RequestBody data: Objective) = logic.insertData(data)


    @GetMapping(value = "/users/{id}/objectives")
    fun getObjective(@PathVariable("id") id: Int, @RequestParam(defaultValue = "", required = false, value = "type") type: String): List<Objective> {
        return if (type != "")
            logic.getObjectivesByUserIdAndType(id, type)
        else
            logic.getObjectivesByUserId(id)
    }

    @GetMapping("/objectives")
    fun getAllObjectives() = logic.getAllObjectives()

    @DeleteMapping("/users/{userid}/objectives/{id}")
    fun deleteObjective(@PathVariable("id") id: Long) = logic.deleteObjective(id)
}