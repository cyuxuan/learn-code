package club.beenest.blog.support.log.annotation;

import club.beenest.blog.support.log.enums.VisitBehavior;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于需要记录访客访问日志的方法
 *
 * @author 陈玉轩
 * @since　1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface VisitLogger {
	/**
	 * 访问行为枚举
	 */
	VisitBehavior value() default VisitBehavior.UNKNOWN;
}
