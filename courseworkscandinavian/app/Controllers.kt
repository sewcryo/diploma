class Controllers {
}// UserController.kt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(@Autowired private val userService: UserService) {

    @PostMapping("/register")
    fun registerUser(@RequestBody user: User): User {
        return userService.saveUser(user)
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): User? {
        return userService.getUserById(id)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody user: User): User? {
        val existingUser = userService.getUserById(id)
        return if (existingUser != null) {
            val updatedUser = existingUser.copy(username = user.username, email = user.email, password = user.password)
            userService.saveUser(updatedUser)
        } else null
    }
}

// LessonController.kt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/lessons")
class LessonController(@Autowired private val lessonService: LessonService) {

    @GetMapping("/{language}")
    fun getLessonsByLanguage(@PathVariable language: String): List<Lesson> {
        return lessonService.getLessonsByLanguage(language)
    }
}

// ProgressController.kt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/progress")
class ProgressController(@Autowired private val progressService: ProgressService) {

    @PostMapping("/save")
    fun saveProgress(@RequestBody progress: Progress): Progress {
        return progressService.saveProgress(progress)
    }

    @GetMapping("/{userId}")
    fun getProgressByUserId(@PathVariable userId: Long): List<Progress> {
        return progressService.getProgressByUserId(userId)
    }
}