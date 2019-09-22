package com.aouty.jackson.manualconfig;

import org.springframework.context.annotation.Configuration;

/**
 * 手动配置Jackson
 */
@Configuration
public class JacksonConfig {

//    @Bean
//    @Primary
//    @Qualifier(value = "xml")
//    public XmlMapper xmlMapper(Jackson2ObjectMapperBuilder builder) {
//        XmlMapper xmlMapper = builder.createXmlMapper(true).build();
//        xmlMapper.findAndRegisterModules();
//        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//        return xmlMapper;
//    }
//
//    @Bean
//    @Primary
//    @Qualifier(value = "json")
//    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder){
//        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
//        objectMapper.findAndRegisterModules();
//        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//        return objectMapper;
//    }
}
