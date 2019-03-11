package david.schweizer.zielsetzungen

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "Objectives")
data class Objective(@Id @GeneratedValue var id: Long = 0, var userID: Int = 1, var type: String = "liegestuetze", var kind: String = "sports",
                     var repetitive: Boolean = false, var amount: Int = 10, var startDate: String = "2018.12.01", var endDate: String = "2018.12.31")