class Spring Framework {
// Application.kt
    import org.springframework.boot.autoconfigure.SpringBootApplication
            import org.springframework.boot.runApplication

            @SpringBootApplication
            class LanguageAppApplication

    fun main(args: Array<String>) {
        runApplication<LanguageAppApplication>(*args)
    }}