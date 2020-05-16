package com.linkgoo.framework.web.core.util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Set;

/**
 * 对象验证器
 *
 */
public class BeanValidator {

    /**
     * 验证某个bean的参数
     *
     * @param object 被校验的参数
     * @throws ValidationException 如果参数校验不成功则抛出此异常
     */
    public static <T> void validate(T object) {
        //获得验证器
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        //执行验证
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object);
        //如果有验证信息，则将第一个取出来包装成异常返回
        ConstraintViolation<T> constraintViolation = getFirst(constraintViolations);
        if (constraintViolation != null) {
            String msg = "[" + constraintViolation.getPropertyPath().toString() + "]: " + constraintViolation.getMessage();
            throw new ValidationException(msg);
        }
    }

    public static <T>ConstraintViolation getFirst(Set<ConstraintViolation<T>> constraintViolations) {
        Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }

}
