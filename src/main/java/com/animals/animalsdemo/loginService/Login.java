package com.animals.animalsdemo.loginService;


import java.lang.annotation.*;


/**
 * @author pankewei
 * @date  2021年09月23日10:39:50
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
