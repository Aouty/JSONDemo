package com.aouty.jackson.manualconfig;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试手动配置的Controller
 */
@RestController
@RequestMapping(value = {"/test-config"})
@ResponseBody
public class TestConfigController {
//    private ObjectMapper jsonMapper;
//    private XmlMapper xmlMapper;
//
//    public TestConfigController(@Autowired @Qualifier("json") ObjectMapper jsonMapper,
//                                @Autowired @Qualifier("xml") XmlMapper xmlMapper) {
//        this.jsonMapper = jsonMapper;
//        this.xmlMapper = xmlMapper;
//    }
}
