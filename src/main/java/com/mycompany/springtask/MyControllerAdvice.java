package com.mycompany.springtask;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@ControllerAdvice
public class MyControllerAdvice {

    @ModelAttribute("entity")
    MyEntity binderMyEntity(@RequestParam(value = "id", required = false) MyEntity entity) {
        return (entity == null) ? new MyEntity() : entity;
    }
}
