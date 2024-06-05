class Services// UserService.kt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService(@Autowired private val userRepository: UserRepository) {
    fun saveUser(user: User): User {
        return userRepository.save(user)
    }

    fun getUserById(id: Long): User? {
        return userRepository.findById(id).orElse(null)
    }
}

// LessonService.kt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LessonService(@Autowired private val lessonRepository: LessonRepository) {
    fun saveLesson(lesson: Lesson): Lesson {
        return lessonRepository.save(lesson)
    }

    fun getLessonsByLanguage(language: String): List<Lesson> {
        return lessonRepository.findAll().filter { it.language == language }
    }
}

// ProgressService.kt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProgressService(@Autowired private val progressRepository: ProgressRepository) {
    fun saveProgress(progress: Progress): Progress {
        return progressRepository.save(progress)
    }

    fun getProgressByUserId(userId: Long): List<Progress> {
        return progressRepository.findByUserId(userId)
    }
} {
}