# mini-samples

Mini samples on java: 'Spring and Transactions'

Build with Java 21, Spring Boot 3.2.2, and Spring Data 3.2.2. The database used was: PostgreSQL 15.4

To see the result of running a sufficient case, execute the application with the corresponding properties '
example.number' (by default 0 will be used with the successful insertion of students and their grades by discipline).
The log will detail the actions of the transaction. SpringData was set up with ddl-auto = create, signifying that your
database should only be installed. If you're utilizing a different database, modify the property values
spring.jpa.database and spring.datasource.* to match your database configuration.
