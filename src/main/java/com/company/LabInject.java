package com.company;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)//какой элемент программы будет
                          //использоваться аннотацией
@Retention(RetentionPolicy.RUNTIME)//аннотация хранится в .class файле и доступна во время выполненя
public @interface LabInject {
    //String info() default ""; //метод по умолчанию будет возвращать определенное значение
}
