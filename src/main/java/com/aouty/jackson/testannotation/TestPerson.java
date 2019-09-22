package com.aouty.jackson.testannotation;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

/**
 * 测试类
 */
public class TestPerson {
    public static void main(String[] args) throws IOException {
        Person person = new Person(100, "Aouty", 30, LocalDate.of(2018, 4, 4), new Date());
        System.out.println(String.format("Person:【%s】", person.toString()));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        //1.将自定义类对象写为字符串
        String jsonByBean = objectMapper.writeValueAsString(person);
        System.out.println(String.format("将自定义类对象写为字符串:【%s】", jsonByBean));

        //2.将自定义类对象写为文件
        String fileName = "person.json";
        objectMapper.writeValue(new File(fileName), person);
        System.out.println(String.format("将自定义类对象写为文件,文件名:【%s】", fileName));

        //3.将自定义类对象写为字节流（字节数组）
        byte[] bytesByBean = objectMapper.writeValueAsBytes(person);
        System.out.println("将自定义类对象写为字节流（字节数组）:");
        for (int i = 0; i < bytesByBean.length; i++) {
            if (0 != i && 0 == i % 20) {
                System.out.println();
            }
            System.out.print(bytesByBean[i] + "\t");
        }
        System.out.println();

        //4.从字符串中读取并转换为自定义类对象
        Person personByJson = objectMapper.readValue(jsonByBean, Person.class);
        System.out.println(String.format("从字符串中读取并转换为自定义类对象:【%s】", personByJson.toString()));

        //5.从文件中读取并转换为自定义类对象
        Person personByFile = objectMapper.readValue(new File(fileName), Person.class);
        System.out.println(String.format("从文件中读取并转换为自定义类对象:【%s】", personByFile.toString()));

        //6.从字节流中读取并转换为自定义类对象
        Person personByBytes = objectMapper.readValue(bytesByBean, Person.class);
        System.out.println(String.format("从字节流中读取并转换为自定义类对象:【%s】", personByBytes.toString()));

    }
}
