package david.schweizer.selfdevelopment

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component

@Component
interface SelfDevelopmentDataJpaRespository : JpaRepository<SelfDevelopmentData, Long> {

    fun findByUserID(id: Int): List<SelfDevelopmentData>
    fun findByUserIDAndActivity(id: Int, activity: String): List<SelfDevelopmentData>
}