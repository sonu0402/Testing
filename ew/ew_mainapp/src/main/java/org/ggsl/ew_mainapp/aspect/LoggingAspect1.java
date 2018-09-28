package org.ggsl.ew_mainapp.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
@Aspect
@ComponentScan(basePackages="org.ggsl")
@Component
public class LoggingAspect1 {
	
	
	@Pointcut(value = "execution(* org.ggsl.*.service.*.*.*(..))")
	public void loggingOperation() {}
	
	
	@Around(value="loggingOperation()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable
    {
		final Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
		logger.info("The method " + joinPoint.getSignature().getName()+ "() begins with parameters " + Arrays.toString(joinPoint.getArgs()));
		
        try
        {
            Object result = joinPoint.proceed();
            logger.info("The method " + joinPoint.getSignature().getName()+ "() ends with " + result);
            return result;
        } catch (IllegalArgumentException e)
        {
        	logger.error("Illegal argument "+ Arrays.toString(joinPoint.getArgs()) + " in "+ joinPoint.getSignature().getName() + "()");
            throw e;
        }      
    }

}
