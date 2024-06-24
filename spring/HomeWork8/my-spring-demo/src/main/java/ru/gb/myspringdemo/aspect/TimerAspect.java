package ru.gb.myspringdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TimerAspect {

    @Pointcut("within(@ru.gb.myspringdemo.aspect.Timer *)")
    public void beansAnnotatedWith() {
    }

    @Pointcut("@annotation(ru.gb.myspringdemo.aspect.Timer)")
    public void methodsAnnotatedWith() {
    }

    @Around("beansAnnotatedWith() || methodsAnnotatedWith()")
    public Object timerAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long elapsedTime = System.currentTimeMillis() - start;
            log.info("{} - {} #{} sec", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName(), elapsedTime / 1000.0);
        }
    }
}
