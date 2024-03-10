# Spring transaction propagation level project

Mini samples on java: 'Spring and Transactions'

Build with Java 21, Spring Boot 3.2.2, and Spring Data 3.2.2. The database used was: PostgreSQL 15.4

To see the result of running a sufficient case, execute the application with the corresponding properties '
example.number' (by default 0 will be used with the successful insertion of students and their grades by discipline).
The log will detail the actions of the transaction. SpringData was set up with ddl-auto = create, signifying that your
database should only be installed. If you're utilizing a different database, modify the property values
spring.jpa.database and spring.datasource.* to match your database configuration.

Transaction propagation types:
- MANDATORY: uses the current transaction and throws an exception if one not exist
- REQUIRED: joins the current transaction. If one does not exist, create it
- NESTED: creates a transaction parallel to the pre-existing transaction. If one does not exist, create it
- NEVER: does not allow transaction execution. If a transaction exists, an exception will be thrown
- NOT_SUPPORTED: does not allow transaction execution. Suspends the current transaction, if one exists
- REQUIRES_NEW: creates a new transaction and suspends the current
- SUPPORTS: joins the current transaction. If one does not exist, it does not create it
___________________________________________________________________________________________
Examples:
1. The default settings for propagation and isolation are set to REQUIRED and DEFAULT, respectively.
   Consequently, during execution, a transaction is initiated, utilized in both studentService.save() and gradeService.saveGrades().
   However, an exception is thrown during the execution of gradeService.saveGrades().
   Consequently, neither the student nor their grades are saved due to a rollback performed for both operations.

2. An exception will occur because the initial method (execute) failed to initialize a transaction.
   This occurs because the savePropagationMandatory method in studentService necessitates (MANDATORY) the presence of one.

3. Even if savePropagationNested throws an exception, the student will still be saved.
   This is because the savePropagationNested method initiates a nested transaction (NESTED) within the transaction initiated by execute.
   To achieve this, a savePoint is established immediately after the student is saved.
   Subsequently, when an error occurs, the rollback only extends as far as the savePoint.

4. An exception will be raised because a transaction was initiated by executing, but savePropagationNever in studentService prohibits its existence.

5. Despite an exception being thrown by the SavePropagationNotSupported method, student2 is still saved.
   This is because the transaction initiated during execute is temporarily suspended.
   Consequently, when the error occurs, both student1 and student2 have already been saved in the database.

6. Although an error is raised by SaveGrades, the student is successfully saved.
   This is because the savePropagationRequiredNew method in studentService initiates a new transaction, pausing the current one.
   Thus, the error encountered in the execute transaction, which is the same as in saveGrades, does not affect the transaction initiated in savePropagationRequiredNew.
   Consequently, the rollback only affects saveGrades.

7. Each student is saved without any issues. Since execute did not initiate a transaction,
   executeWithoutTransaction executes the savePropagationSupports method non-transactionally.
   Conversely, the executeWithTransaction method establishes a transaction, allowing savePropagationSupports to execute transactional.****
