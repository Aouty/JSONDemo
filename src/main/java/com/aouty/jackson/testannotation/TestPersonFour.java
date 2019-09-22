package com.aouty.jackson.testannotation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

/**
 * 测试类
 */
public class TestPersonFour {
    public static void main(String[] args) throws IOException {
        PersonFour personFour = new PersonFour(100, "Aouty", 30, LocalDate.of(2018, 4, 4), new Date());
        System.out.println(String.format("PersonFour:【%s】", personFour.toString()));

        ObjectMapper objectMapper = new XmlMapper();
        objectMapper.findAndRegisterModules();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonByBean = objectMapper.writeValueAsString(personFour);
        System.out.println("使用Jackson将自定义类转换为XML:");
        System.out.println(jsonByBean);

    }
}
