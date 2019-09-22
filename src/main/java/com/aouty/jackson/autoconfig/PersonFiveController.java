package com.aouty.jackson.autoconfig;

import com.aouty.jackson.testannotation.PersonFive;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.*;

/**
 * Controller
 */
@RequestMapping(value = {"/person-five"})
@RestController
@ResponseBody
public class PersonFiveController {
    /**
     * 访问：localhost:8008/test/persion-five/test即可
     *
     * @return PersonFive
     * @author Aouty
     */
    @GetMapping(value = {"/test"})
    public Object test() throws Exception{
        Map<String, String> introduceMap = new LinkedHashMap<>();
        introduceMap.put("学历", "本科");
        introduceMap.put("专业", "计算机科学与技术");

        List<String> hobby = Arrays.asList("音乐", "观光", "游戏");

        PersonFive personFive = new PersonFive(100, "Aouty", 30,
                LocalDate.of(2018, 4, 4), introduceMap, hobby, new Date());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String jsonByObjectMapper = objectMapper.writeValueAsString(personFive);

        ObjectMapper xmlMapper = new XmlMapper();
        xmlMapper.findAndRegisterModules();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String jsonByXmlMapper = xmlMapper.writeValueAsString(personFive);

        ObjectMapper yamlMapper = new YAMLMapper();
        yamlMapper.findAndRegisterModules();
        yamlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        yamlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String jsonByYAMLMapper = yamlMapper.writeValueAsString(personFive);

        return Arrays.asList(personFive,jsonByObjectMapper,jsonByXmlMapper,jsonByYAMLMapper);
    }
}
