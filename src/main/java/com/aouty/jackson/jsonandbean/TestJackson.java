package com.aouty.jackson.jsonandbean;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

/**
 * 测试Jackson
 */
public class TestJackson {
    public static void main(String[] args) throws IOException {
        System.out.println("################################### Jackson ###################################");
        //创建ObjectMapper对象
        System.out.println("====================================Computer:toString()====================================");
        ObjectMapper objectMapper = new ObjectMapper();
        Computer computer = GenerateComputer.generateComputer();
        System.out.println("Computer的toString():\n" + computer);
        Computer computerWithSomeProps = GenerateComputer.generateComputerWithSomeProps();
        System.out.println("\nComputer的toString():\n" + computerWithSomeProps);
        System.out.println();

        //1.将Java对象转换为JSON
        System.out.println("====================================将Java对象转换为JSON：自定义类序列化====================================");
        String jsonComputer = objectMapper.writeValueAsString(computer);
        System.out.println("将单个对象使用ObjectMapper的writeValueAsString方法进行转换:\n" + jsonComputer);
        //生成的JSON字符串中未设置或者设置为null的属性值为null
        String jsonComputerWithSomeProps = objectMapper.writeValueAsString(computerWithSomeProps);
        System.out.println("\n将仅包含部分属性的单个对象使用ObjectMapper的writeValueAsString方法进行转换:\n" + jsonComputerWithSomeProps);

        //对日期时间格式进行设置：不使用timestamps
        System.out.println("\nJackson对java.util.Date类型默认输出格式为timestamps,");
        System.out.println("通过设置objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);");
        System.out.println("将使得java.util.Date类型输出为[ISO-8601 ]-compliant notation：1970-01-01T00:00:00.000+0000");
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        jsonComputer = objectMapper.writeValueAsString(computer);
        System.out.println("\n将单个对象使用ObjectMapper的writeValueAsString方法进行转换:\n" + jsonComputer);
        //生成的JSON字符串中未设置或者设置为null的属性值为null
        jsonComputerWithSomeProps = objectMapper.writeValueAsString(computerWithSomeProps);
        System.out.println("\n将仅包含部分属性的单个对象使用ObjectMapper的writeValueAsString方法进行转换:\n" + jsonComputerWithSomeProps);

        //自定义日期时间输出格式：
        System.out.println("\nJackson支持对java.util.Date类型的输出格式进行自定义设置，设置为：yyyy-MM-dd HH:mm:ss");
        System.out.println("未生效，需要去实体类属性加注解@JsonFormat(pattern=\"yyyy-MM-dd\")//注解只影响对应下面的一个字段");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        objectMapper.getSerializationConfig().with(dateFormat);
        jsonComputer = objectMapper.writeValueAsString(computer);
        System.out.println("\n将单个对象使用ObjectMapper的writeValueAsString方法进行转换:\n" + jsonComputer);
        //生成的JSON字符串中未设置或者设置为null的属性值为null
        jsonComputerWithSomeProps = objectMapper.writeValueAsString(computerWithSomeProps);
        System.out.println("\n将仅包含部分属性的单个对象使用ObjectMapper的writeValueAsString方法进行转换:\n" + jsonComputerWithSomeProps);
        System.out.println();

        //2.将Java对象转换为JSON
        System.out.println("====================================将Java对象转换为JSON：自定义类序列化-第二种方式 ====================================");
        //createGenerator():第一个参数时OutputStream类型，第二个时JsonEncoding类型，此方法不仅可以将JSON直接写入网络流，还可以将JSON写入文件流或内存流
        JsonGenerator jsonGenerator = objectMapper.getFactory().createGenerator(System.out, JsonEncoding.UTF8);
        System.out.println("将单个对象使用JsonGenerator的writeObject方法进行转换：");
        jsonGenerator.writeObject(computer);
        System.out.println("\n将仅包含部分属性的单个对象使用JsonGenerator的writeObject方法进行转换：");
        jsonGenerator.writeObject(computerWithSomeProps);
        System.out.println();


        //创建ObjectMapper对象
        System.out.println();
        System.out.println("====================================ComputerTwo:toString()====================================");
        ObjectMapper objectMapper2 = new ObjectMapper();
        ComputerTwo computerTwo = GenerateComputerTwo.generateComputerTwo();
        System.out.println("ComputerTwo的toString():\n" + computerTwo);
        ComputerTwo computerTwoWithSomeProps = GenerateComputerTwo.generateComputerTwoWithSomeProps();
        System.out.println("\nComputerTwo的toString:\n" + computerTwoWithSomeProps);

        //1.将Java对象集合转换为JSON
        System.out.println("\n====================================将Java对象（Date类型加@JsonFormat后）转换为JSON====================================");
        String jsonComputerTwo = objectMapper.writeValueAsString(computerTwo);
        System.out.println("将单个对象使用ObjectMapper的writeValueAsString方法进行转换:\n" + jsonComputerTwo);
        JsonGenerator jsonGenerator2 = objectMapper.getFactory().createGenerator(System.out, JsonEncoding.UTF8);
        System.out.println("将单个对象使用JsonGenerator的writeObject方法进行转换：");
        jsonGenerator2.writeObject(computerTwo);
        //生成的JSON字符串中未设置或者设置为null的属性值为null
        String jsonComputerTwoWithSomeProps = objectMapper.writeValueAsString(computerTwoWithSomeProps);
        System.out.println("\n\n将仅包含部分属性的单个对象使用ObjectMapper的writeValueAsString方法进行转换:\n" + jsonComputerTwoWithSomeProps);
        System.out.println("将仅包含部分属性的单个对象使用JsonGenerator的writeObject方法进行转换：");
        jsonGenerator2.writeObject(computerTwoWithSomeProps);

        //2.将Java对象集合转换为JSON
        System.out.println("\n====================================将Java对象（Date类型加@JsonFormat后）集合转换为JSON====================================");
        List<ComputerTwo> computerTwoList = Arrays.asList(computerTwo, computerTwoWithSomeProps);
        String jsonByList = objectMapper2.writeValueAsString(computerTwoList);
        System.out.println("将Java对象集合用ObjectMapper的writeValueAsString方法进行转换:\n" + jsonByList);
        jsonByList = objectMapper.writeValueAsString(computerTwoList);
        System.out.println("\n将Java对象集合用ObjectMapper的writeValueAsString方法进行转换:\n" + jsonByList);

    }
}
