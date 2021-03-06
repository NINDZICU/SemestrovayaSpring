package ru.kpfu.loggers;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Anatoly on 14.05.2017.
 */
@Aspect
public class WebServiceLogger {
    @Pointcut("execution(* *(..))")
    public void webService(){}

    @Pointcut("@annotation(ru.kpfu.annotations.MyAnnotation)")
    public void loggableMethod(){}
    @Around("webService()&&loggableMethod()")
    public Object logWebService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.println("Method NAME: "+methodName);

        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("USER NAME: "+name);

        Object result = proceedingJoinPoint.proceed();


        return result;
    }
}
