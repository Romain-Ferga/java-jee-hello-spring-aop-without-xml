package com.spring.annotations.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MonLogger {

	@Pointcut("execution(* com.spring.annotations..*(..))")
	public void methodeMain() {
	}

	@Before("methodeMain()")
	public void logMethodEntry(JoinPoint joinPoint) {

		String name = joinPoint.getSignature().toLongString(); // Nom de la m�thode intercept�e

		StringBuffer sb = new StringBuffer(name + " called with: [");

		Object[] args = joinPoint.getArgs(); // Liste des valeurs des arguments re�us par la m�thode

		for (int i = 0; i < args.length; i++) {

			Object o = args[i];

			sb.append("'" + o + "'");

			sb.append((i == args.length - 1) ? "" : ", ");

		}

		sb.append("]");

		System.out.println(sb);

	}

	@AfterReturning(pointcut = "methodeMain()", returning = "result")
	public void logMethodExit(StaticPart staticPart, Object result) {

		String name = staticPart.getSignature().toLongString(); // Nom de la m�thode intercept�e

		System.out.println(name + " returning: [" + result + "]");

	}

	@Around("methodeMain()")
	public Object logMethodAround(final ProceedingJoinPoint jointPoint) throws Throwable {

		String name = jointPoint.getSignature().toLongString(); // Nom de la m�thode intercept�e

		System.out.println(name + " is running");

		Object obj = jointPoint.proceed();

		System.out.println(name + " is executed");

		return obj;

	}

}