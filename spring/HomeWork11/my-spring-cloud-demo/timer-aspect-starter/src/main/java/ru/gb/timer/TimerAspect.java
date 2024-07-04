package ru.gb.timer;

import org.aspectj.lang.reflect.MethodSignature;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class TimerAspect {

    public TimerAspect(TimerProperties properties) {
    }

    @Pointcut("within(@ru.gb.timer.Timer *)")
    public void beansAnnotatedWithTimer() {

    }

    @Pointcut("@annotation(ru.gb.timer.Timer)")
    public void methodsAnnotatedWithTimer() {

    }

    @Around("beansAnnotatedWithTimer() || methodsAnnotatedWithTimer()")
    public Object timerAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println(joinPoint.getTarget().getClass().isAnnotationPresent(Timer.class));
        try {
            if (joinPoint.getTarget().getClass().isAnnotationPresent(Timer.class) ||
                    method.isAnnotationPresent(Timer.class)) {
                long start = System.currentTimeMillis();
                Object result = joinPoint.proceed();
                long elapsedTime = System.currentTimeMillis() - start;
                //  в лог записать следующее: className - methodName #(количество секунд выполнения)
                log.info(joinPoint.getTarget().getClass().getName() + " - " + joinPoint.getSignature().getName() + " #" +
                        elapsedTime * 0.001 + " sec.");
                return result;
            } else {
                Object result = joinPoint.proceed();
                return result;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }
}
