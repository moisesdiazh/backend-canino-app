Para el uso del backend se debe utilizar: 
1. mvn install
2. Se debe utilizar MySQL 5.0
3. Se debe añadir la config de mysql en el application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/
spring.datasource.username=
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.defer-datasource-initialization=true
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
logging.level.org.hibernate.SQL=debug

