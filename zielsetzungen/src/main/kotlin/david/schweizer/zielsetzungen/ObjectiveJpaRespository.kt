package david.schweizer.zielsetzungen

import org.springframework.data.jpa.repository.JpaRepository

interface ObjectiveJpaRespository : JpaRepository<Objective, Long> {

    fun findByUserID(id: Int): List<Objective>
    fun findByUserIDAndType(id: Int, type: String): List<Objective>
}