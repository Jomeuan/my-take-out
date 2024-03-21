package com.example.mytakeout;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import lombok.Data;

public class Test1 {
    public static void main(String[] args){
        InnerTest1 innerTest1 = new InnerTest1();
        System.out.println(innerTest1.getS());
    }
}

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@interface inter1{
    String value() default "null";
}

@Data
@inter1
class InnerTest1 {
    String s ;    
}