package ru.gb.myspringdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class RecoverExceptionAspect {

    @Pointcut("@annotation(ru.gb.myspringdemo.aspect.RecoverException)")
    public void methodAnnotatedWithRecoverException() {
    }

    @Around("methodAnnotatedWithRecoverException()")
    public Object handleRecoverException(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        RecoverException annotation = signature.getMethod().getAnnotation(RecoverException.class);
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            for (Class<? extends RuntimeException> exceptionClass : annotation.noRecoverFor()) {
                if (exceptionClass.isAssignableFrom(e.getClass())) {
                    throw e;
                }
            }
            log.warn("Exception caught in method: {}. Returning default value. Exception: {}", joinPoint.getSignature().getName(), e.getMessage());
            return getDefaultReturnValue(signature.getReturnType());
        }
    }

    private Object getDefaultReturnValue(Class<?> returnType) {
        if (returnType.isPrimitive()) {
            if (returnType.equals(boolean.class)) {
                return false;
            } else if (returnType.equals(char.class)) {
                return '\u0000';
            } else if (returnType.equals(byte.class) || returnType.equals(short.class) || returnType.equals(int.class) || returnType.equals(long.class) || returnType.equals(float.class) || returnType.equals(double.class)) {
                return 0;
            }
        }
        return null;
    }
}
