package com.company;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String firstName() default "DefaultFirstName";
    String lastName() default "DefaultLastName";
    int age() default 0;
}
