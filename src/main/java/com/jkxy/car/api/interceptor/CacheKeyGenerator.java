package com.jkxy.car.api.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author skryy9
 */
public interface CacheKeyGenerator {
    /**
     * 获取AOP参数,生成指定缓存Key
     *
     * @param pjp PJP
     * @return 缓存KEY
     */
    String getLockKey(ProceedingJoinPoint pjp);
}
