package com.housemgt.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
 private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

 @Before(value = "execution(* com.springboot.toutiaozixun.controller.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint){

     logger.info("before !!!!!!!!!!!!!"+joinPoint.toLongString());
 }

 @After("execution(* com.springboot.toutiaozixun.controller.*.*(..))")
    public void afterMethod(JoinPoint joinPoint){

     logger.info("after !!!!!!!!!!!!!"+joinPoint.toLongString());
 }
}
