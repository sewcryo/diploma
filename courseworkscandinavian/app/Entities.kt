class Entities// User.kt
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    val username: String,
    val email: String,
    var password: String
)

// Lesson.kt
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Lesson(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    val language: String,
    val title: String,
    val content: String
)

// Progress.kt
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Progress(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    val userId: Long,
    val lessonId: Long,
    val progress: Double
) {
}