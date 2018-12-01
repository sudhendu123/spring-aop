/**
 * 
 */
package com.doj.aopapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Dinesh.Rajput
 *
 */
@Aspect
@Component
public class LoggingAspect {
	
	/**
	 * Declaring before advice 
	 * @param jp
	 * @throws Throwable
	 */
	//@Before("execution(* com.doj.aopapp.service.*.*(..))") // before advice with pointcut expression directly
	@Before("logForAllMethods()") //before advice with name pointcut that declared as name logForAllMethods()
	public void beforeAdviceForAllMethods(JoinPoint jp) throws Throwable {
        System.out.println("****LoggingAspect.beforeAdviceForAllMethods() " + jp.getSignature().getName());
    }
	
	/**
	 * Declaring before advice for all transfer methods whose taking three arguments of any type 
	 * of all classes in the package com.doj.aopapp.service
	 * @param jp
	 * @throws Throwable
	 */
	@Before("execution(* com.doj.aopapp.service.*.transfer(*,*,*))")
	public void beforeAdviceForTransferMethods(JoinPoint jp) throws Throwable {
        System.out.println("****LoggingAspect.beforeAdviceForTransferMethods() " + jp.getSignature().getName());
    }
	
	/**
	 * Declaring named pointcut
	 */
	@Pointcut("execution(* com.doj.aopapp.service.*.*(..))")
	public void logForAllMethods(){}
}
