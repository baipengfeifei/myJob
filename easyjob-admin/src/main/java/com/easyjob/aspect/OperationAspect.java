package com.easyjob.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

/**
 * AOP切片
 */
@Aspect
@Component("operationAspect")
public class OperationAspect {
//    @Pointcut("@annotation(com.easyjob.annotation.GlobalInterceptor)")
//    private void pointCut(){
//
//    }
    private Logger logger;
    @Before("@annotation(com.easyjob.annotation.GlobalInterceptor)")
    public void interceptorDo(JoinPoint point){
        logger.info(point.getArgs().toString());
    }
}
