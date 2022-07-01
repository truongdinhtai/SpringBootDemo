package com.example.SpringBootDemo.Utils;

import org.modelmapper.ModelMapper;

public class MergingObjects {

    private static ModelMapper modelMapper = new ModelMapper();

    public static Object mergeObject(Object source, Class<?> clazz) {
        Object object = modelMapper.map(source, clazz);
        return object;
    }
}
