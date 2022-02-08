package org.spring.my.advice;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Aspect
public class LoggingAdvice {
	@Before("execution(* org.spring.my.*Controller.*(..))")
	public void beforeLog(JoinPoint jp) {
		System.out.println(jp.getSignature().toShortString() + " : " + Arrays.toString(jp.getArgs()));
	}
	
	@AfterReturning(pointcut="execution(* org.spring.my.*Controller.*(..))", returning = "rObj")
	public void afterLog(JoinPoint jp, Object rObj) {
		System.out.println(jp.getSignature().toShortString());  //실행된 메소드명
		System.out.println("리턴값:" + rObj.toString());
	}
}
