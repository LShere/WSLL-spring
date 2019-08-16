package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class aspect {

    @Pointcut("execution(* auto.dao.*.*(..))")
    void myPointcut() {
    }

    @Before("myPointcut()")
    public void before() {
        System.out.println("before-----------");
    }

    @After("myPointcut()")
    public void after() {
        System.out.println("after-----------");
    }

    @Around("myPointcut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("around begin-----------");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        System.out.println("around end-----------");
    }


}
