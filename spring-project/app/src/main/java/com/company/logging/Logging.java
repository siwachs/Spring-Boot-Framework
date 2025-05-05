package com.company.logging;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {
    @Before("execution(public void com.company.Service.UserService.login())")
    public void loggingAdvice1() {
        System.out.println("Before Advice. Run before login");
    }

    @After("execution(public void com.company.Service.UserService.login())")
    public void loggingAdvice2() {
        System.out.println("After Advice. Run after login");
    }

    @Around("execution(public void com.company.service.UserService.login())")
    public void loggingAdvice3() {
        System.out.println("Before and After invoking method logIn");
    }

    @AfterThrowing("execution(public void com.company.service.UserService.logout())")
    public void loggingAdvice4() {
        System.out.println("Exception thrown in logOut method");
    }

    @AfterReturning("execution(public void com.company.Service.UserService.logout())")
    public void loggingAdvice5() {
        System.out.println("AfterReturning advice for logOut is run");
    }

    @Pointcut("execution(public * com.company.service.UserService.*(..))")
    public void pointCut() {
    }

    @Pointcut("execution(public * com.company.service.UserService.*(..))")
    public void pointCut1() {
    }

    @Before("pointCut() || pointCut1()")
    public void loggingAdvice6() {
        System.out.println("Before advice using pointcut is executed");
    }
}
