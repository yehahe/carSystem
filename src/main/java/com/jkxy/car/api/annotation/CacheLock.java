package com.jkxy.car.api.annotation;


import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @author skryy9
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CacheLock {

    /**
     * redis 锁key的前缀
     *
     * @return redis 锁key的前缀
     */
    String prefix() default "";

    /**
     * 过期秒数,默认为5秒
     *
     * @return 轮询锁的时间
     */
    int expire() default 1000000;

    /**
     * 超时时间单位
     *
     * @return 豪秒
     */
    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;

    /**
     * <p>Key的分隔符（默认 :）</p>
     * <p>生成的Key：N:SO1008:500</p>
     *
     * @return String
     */
    String delimiter() default ":";
}
