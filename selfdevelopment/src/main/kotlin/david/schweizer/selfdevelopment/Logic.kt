package david.schweizer.selfdevelopment

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class Logic {

    @Autowired
    lateinit var selfDevelopmentDataJpaRespository: SelfDevelopmentDataJpaRespository

    fun insertDevelopmentData(data: SelfDevelopmentData) = selfDevelopmentDataJpaRespository.save(data)

    fun deleteDevelopmentData(id: Long) = selfDevelopmentDataJpaRespository.deleteById(id)

    fun getAllDevelopmentData(): MutableList<SelfDevelopmentData> = selfDevelopmentDataJpaRespository.findAll()

    fun getUserDevelopmentById(userID: Int) = selfDevelopmentDataJpaRespository.findByUserID(userID)

    fun getDevelopmentActivity(userID: Int, activity: String) = selfDevelopmentDataJpaRespository.findByUserIDAndActivity(userID, activity)
}