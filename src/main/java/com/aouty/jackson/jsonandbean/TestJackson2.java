package com.aouty.jackson.jsonandbean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/**
 * 测试Jackson
 */
public class TestJackson2 {
    public static void main(String[] args) throws IOException {
        System.out.println("################################### Jackson ###################################");

        ObjectMapper objectMapper = new ObjectMapper();
        //如果实体类中使用了Java8提供的日期时间类，那么需要在Jackson中注册这些模块
//        objectMapper.findAndRegisterModules();//Jackson也可以自动搜索所有模块,与下面的代码等效
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(new ParameterNamesModule());
        objectMapper.registerModule(new Jdk8Module());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        List<ComputerTwo> computerTwoList = Arrays.asList(GenerateComputerTwo.generateComputerTwo(),
                GenerateComputerTwo.generateComputerTwoWithSomeProps());
        String jsonByBean = objectMapper.writeValueAsString(GenerateComputerTwo.generateComputerTwo());
        System.out.println(String.format("JSON字符串：【%s】", jsonByBean));
        String jsonByList = objectMapper.writeValueAsString(computerTwoList);
        System.out.println(String.format("JSON字符串：【%s】\n", jsonByList));

//
//        //1.将JSON字符串解析为自定义对象
//        System.out.println("====================================将JSON字符串解析为Java对象====================================");
//        ComputerTwo computerTwo = objectMapper.readValue(jsonByBean, ComputerTwo.class);
//        System.out.println("将JSON字符串解析为自定义实体类：\n" + computerTwo.toString());

        //2.将JSON字符串解析为系统自带的类：Map
        @SuppressWarnings("unchecked") Map<String, Object> mapByJson = objectMapper.readValue(jsonByBean, Map.class);
        System.out.println("将JSON字符串解析为Map：\n" + mapByJson.toString());
        System.out.println();

        //1.将JSON字符串解析为自定义对象集合
        System.out.println("====================================将JSON字符串解析为Java对象集合====================================");
        List<ComputerTwo> computerTwoListByJson = objectMapper.readValue(jsonByList, new TypeReference<List<ComputerTwo>>() {
        });
        System.out.println("将JSON字符串解析为自定义实体类集合：\n" + computerTwoListByJson.toString());

        //2.将JSON字符串解析为系统自带的类集合：List<Map>
        List<Map<String, Object>> mapListByJson = objectMapper.readValue(jsonByList, new TypeReference<List<Map<String, Object>>>() {
        });
        System.out.println("将JSON字符串解析为List<Map>：\n" + mapListByJson.toString());
        System.out.println();

        //1.将自定义类的JOSN字符串按树形结构进行解析
        System.out.println("====================================将自定义类的JSON字符串按树形结构进行解析====================================");
        JsonNode jsonNode = objectMapper.readTree(jsonByBean);
        int id = jsonNode.get("id").asInt();
        System.out.println(String.format("ID:【%d】", id));
        String name = jsonNode.get("name").asText();
        System.out.println(String.format("name:【%s】", name));
        JsonNode activeDateNode = jsonNode.get("activeDate");
        if (activeDateNode instanceof ArrayNode) {
            //当未设置objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);时，
            // java.time.LocalDate类型字段会被解析为ArrayNode,是ArrayList<IntNode>类型
            StringJoiner activeDate = new StringJoiner("-");
            for (JsonNode node : activeDateNode) {
                int value = node.asInt();
                activeDate.add(String.valueOf(value));
            }
            System.out.println(String.format("activeDate:【%s】", activeDate.toString()));
        } else if (activeDateNode instanceof TextNode) {
            //当设置objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);后，
            // java.time.LocalDate类型字段会被解析为TextNode
            System.out.println(String.format("activeDate:【%s】", activeDateNode.asText()));
        }
        //此时java.util.Date类型的字段被解析为TextNode类型
        //get和findValue方法都可以
        String firstUseDate = jsonNode.findValue("firstUseDate").asText();
        System.out.println(String.format("firstUseDate:【%s】", firstUseDate));
        JsonNode featuresNode = jsonNode.get("features");
        String system = featuresNode.findValue("system").asText();
        System.out.println(String.format("属性名称：【system】属性值：【%s】", system));
        String cpu = featuresNode.findValue("CPU").asText();
        System.out.println(String.format("属性名称：【cpu】属性值：【%s】", cpu));

        //2.将Java对象集合的JOSN字符串按树形结构进行解析
        System.out.println("====================================将自定义类集合的JSON字符串按树形结构进行解析====================================");
        JsonNode jsonNodeByList = objectMapper.readTree(jsonByList);
        for (int i = 0; i < jsonNodeByList.size(); i++) {
            //jsonNodeByList中的每一个元素相当于JsonNode jsonNode = objectMapper.readTree(jsonByBean);
            System.out.println(String.format("这是第【%d】个元素的信息", (i + 1)));
            int idItem = jsonNodeByList.get(i).get("id").asInt();
            System.out.println(String.format("ID:【%d】", idItem));
            String nameItem = jsonNodeByList.get(i).findValue("name").asText();
            System.out.println(String.format("name:【%s】", nameItem));
            System.out.println();
        }

        //1.将Map的JOSN字符串按树形结构进行解析
        System.out.println("====================================将Map的JSON字符串按树形结构进行解析====================================");
        String jsonByMap = objectMapper.writeValueAsString(mapByJson);
        JsonNode jsonNodeByMap = objectMapper.readTree(jsonByMap);
        //当未设置objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);时，
        // java.time.LocalDate类型字段会被解析为ArrayNode,是ArrayList<IntNode>类型
        //当设置objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);后，
        // java.time.LocalDate类型字段会被解析为TextNode

        //2.将Map集合的JOSN字符串按树形结构进行解析
        System.out.println("====================================将Map集合的JSON字符串按树形结构进行解析====================================");
        String jsonByMapList = objectMapper.writeValueAsString(mapListByJson);
        JsonNode jsonNodeByMapList = objectMapper.readTree(jsonByMapList);
        //当未设置objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);时，
        // java.time.LocalDate类型字段会被解析为ArrayNode,是ArrayList<IntNode>类型
        //当设置objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);后，
        // java.time.LocalDate类型字段会被解析为TextNode

    }
}
