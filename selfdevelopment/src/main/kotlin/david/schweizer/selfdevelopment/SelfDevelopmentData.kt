package david.schweizer.selfdevelopment

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "SelfDevelopmentData")
data class SelfDevelopmentData(@Id @GeneratedValue val id: Long? = null, var userID: Int = 0, var activity: String = "",
                               var date: String = "", var amount: Int = 0, var time: Double = 0.0)