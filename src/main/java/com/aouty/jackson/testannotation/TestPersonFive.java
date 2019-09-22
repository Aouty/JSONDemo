package com.aouty.jackson.testannotation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

/**
 * 测试类
 */
public class TestPersonFive {
    public static void main(String[] args) throws IOException {
        Map<String,String> introduceMap = new LinkedHashMap<>();
        introduceMap.put("学历","本科");
        introduceMap.put("专业","计算机科学与技术");

        List<String> hobby = Arrays.asList("音乐","观光","游戏");

        PersonFive personFive = new PersonFive(100, "Aouty", 30,
                LocalDate.of(2018, 4, 4), introduceMap, hobby, new Date());
        System.out.println(String.format("PersonFive:【%s】", personFive.toString()));

        ObjectMapper yamlMapper = new YAMLMapper();
        yamlMapper.findAndRegisterModules();
        yamlMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        yamlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        yamlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonByBean = yamlMapper.writeValueAsString(personFive);
        System.out.println("使用Jackson将自定义类转换为YML(application.yml):");
        System.out.println(jsonByBean);
    }
}
