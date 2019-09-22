package com.aouty.jackson.testannotation;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

/**
 * 测试类
 */
public class TestPersonThree {
    public static void main(String[] args) throws IOException {
        PersonThree personThree= new PersonThree(100, "Aouty", 30, LocalDate.of(2018, 4, 4), new Date());
        System.out.println(String.format("PersonThree:【%s】", personThree.toString()));
        System.out.println();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        String jsonByBean = objectMapper.writeValueAsString(personThree);
        System.out.println(String.format("使用Jackson将自定义类转换为JSON字符串:【%s】", jsonByBean));
        System.out.println();


        ObjectMapper objectMapper2 = new ObjectMapper();
        objectMapper2.findAndRegisterModules();
        objectMapper2.enable(SerializationFeature.WRAP_ROOT_VALUE);
        objectMapper2.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        String json2ByBean = objectMapper2.writeValueAsString(personThree);
        System.out.println(String.format("使用Jackson将自定义类转换为JSON字符串:【%s】", json2ByBean));
        PersonThree personThreeByJson = objectMapper2.readValue(json2ByBean, PersonThree.class);
        System.out.println(String.format("使用Jackson将JSON字符串反序列化为自定义类：【%s】", personThreeByJson));

    }
}
