package spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAop {
    @Pointcut("execution(* spring.service.*.*(..))")
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
