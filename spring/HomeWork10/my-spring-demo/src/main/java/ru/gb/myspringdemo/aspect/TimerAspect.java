package ru.gb.myspringdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Аспект для измерения времени выполнения методов.
 * Использует аннотацию @Timer для отслеживания методов.
 */
@Slf4j
@Aspect
@Component
public class TimerAspect {

    /**
     * Определяет точку среза для бинов, аннотированных @Timer.
     */
    @Pointcut("within(@ru.gb.myspringdemo.aspect.Timer *)")
    public void beansAnnotatedWith() {
    }

    /**
     * Определяет точку среза для методов, аннотированных @Timer.
     */
    @Pointcut("@annotation(ru.gb.myspringdemo.aspect.Timer)")
    public void methodsAnnotatedWith() {
    }

    /**
     * Совет вокруг выполнения методов, измеряющий время их выполнения.
     * @param joinPoint точка соединения
     * @return результат выполнения метода
     * @throws Throwable если возникает исключение при выполнении метода
     */
    @Around("beansAnnotatedWith() || methodsAnnotatedWith()")
    public Object timerAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            long start = System.currentTimeMillis();
            Object result = joinPoint.proceed();
            long elapsedTime = System.currentTimeMillis() - start;
            log.info(joinPoint.getTarget().getClass().getName() + " - " + joinPoint.getSignature().getName() + " #" +
                    elapsedTime * 0.001 + " sec.");
            return result;
        } catch (Throwable e) {
            log.error("exception: [{}, {}]", e.getClass(), e.getMessage());
            throw e;
        }
    }
}