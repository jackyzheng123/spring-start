package com.zjx.config;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 日志切面
 * 
 * @author zhengjiaxing
 * @date 2018年10月29日
 */
@Aspect
public class LogAspect {

	/**
	 * 切点
	 */
	@Pointcut(value = "execution(public int com.zjx.service.CalculateService.div(..))")
	public void logCut() {
	}

	/**
	 * 前置通知
	 * 
	 * @param joinPoint
	 */
	@Before(value = "logCut()")
	public void beforeLog(JoinPoint joinPoint) {
		System.out.println("方法执行前置通知@Before...方法名：" + joinPoint.getSignature().getName() + ", 参数列表："
				+ Arrays.asList(joinPoint.getArgs()));
	}

	/**
	 * 后置通知
	 * 
	 * @param joinPoint
	 */
	@After(value = "logCut()")
	public void afterLog(JoinPoint joinPoint) {
		System.out.println("方法执行后置通知@After...结束" + joinPoint.getSignature().getName());
	}

	/**
	 * 返回通知
	 * 
	 * @param joinPoint
	 * @param result
	 */
	@AfterReturning(value = "logCut()", returning = "result")
	public void afterReturingLog(JoinPoint joinPoint, Object result) {
		System.out.println("方法执行返回前@AfterReturning..." + joinPoint.getSignature().getName() + "返回结果：" + result);
	}

	/**
	 * 异常通知
	 * 
	 * @param joinPoint
	 * @param exception
	 */
	@AfterThrowing(value = "logCut()", throwing = "exception")
	public void throwsLog(JoinPoint joinPoint, Exception exception) {
		System.out.println("抛出异常通知@AfterThrowing..." + joinPoint.getSignature().getName() + "抛出异常：" + exception);
	}

	/**
	 * 环绕通知：动态代理，手动推进目标方法运行
	 * 
	 * @throws Throwable
	 */
	/*@Around(value = "logCut()")
	public void around(ProceedingJoinPoint joinPoint) {
		System.out.println("==========环绕通知start==========");
		// 方法名
		String methodName = joinPoint.getSignature().getDeclaringTypeName();
		// 参数列表
		List<Object> args = Arrays.asList(joinPoint.getArgs());

		Object result = null;
		try {
			// 前置通知
			System.out.println("前置通知：方法：" + methodName + ", 参数：" + args);
			// 执行目标方法
			result = joinPoint.proceed();
			// 返回通知
			System.out.println("返回通知：方法：" + methodName + ", 结果：" + result);
		} catch (Throwable e) {
			// 异常通知
			System.out.println("异常通知：方法：" + methodName + ", 异常：" + e);
			e.printStackTrace();
		}
		// 后置通知
		System.out.println("后置通知：" + methodName);
		System.out.println("==========环绕通知end==========");
	}*/

}
