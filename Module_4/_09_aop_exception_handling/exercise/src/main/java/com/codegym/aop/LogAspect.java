package com.codegym.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
@Aspect
public class LogAspect {
    private int numberOfVisiting = 0;
    @Pointcut("execution(* com.codegym.controller.LibraryController.do*(..))")
    public void logAfterRunMethod(){
    }

    @AfterReturning("logAfterRunMethod()")
    public void afterCallMethod(JoinPoint joinPoint){
        System.err.println("The amount of book has been change after method :"+ joinPoint.getSignature().getName());
    }

    @Pointcut("within(com.codegym.controller.LibraryController*)")
    public void visiting(){
    }

    @After("visiting()")
    public void afterAllMethodCall(JoinPoint joinPoint){
        numberOfVisiting++;
        System.err.println("Guess has been visited, Method "+joinPoint.getSignature().getName()+" has been called.\n"+
                "Number of visits : "+numberOfVisiting);
    }
}
