package com.mycompany.springtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class MyConvertor implements Converter<String, MyEntity> {

    @Autowired
    MyRepository repository;

    @Override
    public MyEntity convert(String id) {
        System.out.println("convertor " + id);
        if (id.isEmpty()) {
            return null;
        } else {
            return repository.findByStringId(id);
        }
    }

}
