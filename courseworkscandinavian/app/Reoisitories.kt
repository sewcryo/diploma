class Reoisitories// UserRepository.kt
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>

// LessonRepository.kt
import org.springframework.data.jpa.repository.JpaRepository

interface LessonRepository : JpaRepository<Lesson, Long>

// ProgressRepository.kt
import org.springframework.data.jpa.repository.JpaRepository

interface ProgressRepository : JpaRepository<Progress, Long> {
    fun findByUserId(userId: Long): List<Progress>
} {
}