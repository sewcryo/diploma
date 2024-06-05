class Database// build.gradle
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.xerial:sqlite-jdbc:3.34.0")
}

// application.properties
spring.datasource.url=jdbc:sqlite:language_app.db
spring.datasource.driver-class-name=org.sqlite.JDBC
spring.jpa.database-platform=org.hibernate.dialect.SQLiteDialect {
}