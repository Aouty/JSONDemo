package com.aouty.jackson.testannotation;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

/**
 * 测试类
 */
public class TestPersonTwo {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        PersonTwo personTwo = new PersonTwo(100, "Aouty", 30, LocalDate.of(2018, 4, 4), new Date());
        System.out.println(String.format("PersonTwo:【%s】", personTwo.toString()));
        String jsonByBean = objectMapper.writeValueAsString(personTwo);
        System.out.println(String.format("使用Jackson的@JsonProperty注解后将自定义类转换为JSON字符串:【%s】", jsonByBean));
        System.out.println();

        PersonTwo personTwo2 = new PersonTwo(200,"Yoona",20, LocalDate.of(2019,6,6),new Date());
        System.out.println(String.format("PersonTwo:【%s】", personTwo2.toString()));
        String json2ByBean = objectMapper.writeValueAsString(personTwo2);
        System.out.println(String.format("使用Jackson的@JsonProperty注解后将自定义类转换为JSON字符串:【%s】", json2ByBean));

    }
}
