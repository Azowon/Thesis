package david.schweizer.zielsetzungen

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class Logic {
    @Autowired
    lateinit var objectiveJpaRespository: ObjectiveJpaRespository

    fun deleteObjective(id: Long) = objectiveJpaRespository.deleteById(id)

    fun getAllObjectives(): MutableList<Objective> = objectiveJpaRespository.findAll()

    fun getObjectivesByUserIdAndType(userId: Int, type: String) = objectiveJpaRespository.findByUserIDAndType(userId, type)

    fun getObjectivesByUserId(userId: Int) = objectiveJpaRespository.findByUserID(userId)

    fun insertData(data: Objective) = objectiveJpaRespository.save(data)
}