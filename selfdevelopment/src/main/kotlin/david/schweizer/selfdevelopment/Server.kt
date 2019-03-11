package david.schweizer.selfdevelopment

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
class Server {

    @Autowired
    lateinit var Logic: Logic

    @PostMapping(value = "/users/{id}/development", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createDevelopmentData(@PathVariable("id") id: Int, @RequestBody selfDevelopmentData: SelfDevelopmentData) {
        selfDevelopmentData.userID = id
        Logic.insertDevelopmentData(selfDevelopmentData)
    }

    @PutMapping(value = "/users/{id}/development/{developmentid}", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun updateDevelopmentData(@PathVariable("developmentid") id: Long, @RequestBody selfDevelopmentData: SelfDevelopmentData) = Logic.insertDevelopmentData(selfDevelopmentData)


    @DeleteMapping("/users/{userid}/development/{id}")
    fun deleteDevelopmentData(@PathVariable("id") id: Long) {
        Logic.deleteDevelopmentData(id)
    }

    @GetMapping("/development")
    fun getAllDevelopmentData() = Logic.getAllDevelopmentData()

    @GetMapping("users/{id}/development")
    fun getUserDevelopment(@PathVariable("id") id: Int, @RequestParam(defaultValue = "", required = false, value = "type") type: String): List<SelfDevelopmentData> {

        return if (type == "")
            Logic.getUserDevelopmentById(id)
        else
            Logic.getDevelopmentActivity(id, type)
    }
}