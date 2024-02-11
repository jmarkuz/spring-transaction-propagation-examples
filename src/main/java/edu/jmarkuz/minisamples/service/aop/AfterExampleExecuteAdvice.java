package edu.jmarkuz.minisamples.service.aop;

import edu.jmarkuz.minisamples.exception.FakeErrorException;
import edu.jmarkuz.minisamples.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class AfterExampleExecuteAdvice {

    private final SearchService searchService;

    @After("execution(* edu.jmarkuz.minisamples.service.example.*.execute())")
    public void logResults() {
        log.info("after execution ----------------");
        log.info("Search for saved students: ");
        this.searchService.listAllStudents();

        log.info("Search for saved students grades: ");
        var students = this.searchService.findAllStudents();
        students.forEach(this.searchService::listAllStudentsGrade);
        log.info("---------------------------------");
    }

    //@AfterThrowing(pointcut = "executePointcut()", throwing = "ex")
    public void logExceptions(FakeErrorException ex) {
        log.info("Exception thrown in Example = ", ex);
    }

    //@Pointcut("execution(* edu.jmarkuz.minisamples.service.example.*.*(..))")
    public void executePointcut() {
    }

}
