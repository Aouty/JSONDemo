package com.aouty.jackson.testannotation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

/**
 * 人物类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonTwo {
    /**
     * 主键ID
     * 默认情况下，JSON字符串的属性名称与注解的属性名称相同，可以使用@JsonProperty注解的value属性修改JSON属性名称
     * 而@JsonProperty注解的index属性可以指定生成JSON属性的顺序,默认值为-1
     */
    @JsonProperty(value = "人物编号", index = 0)
    private Integer id;
    /**
     * 姓名
     */
    @JsonProperty(value = "人物名字", index = -1)
    private String name;
    /**
     * 年龄
     */
    private int age;
    /**
     * 出生日期:yyyy-MM-dd
     */
    @JsonProperty(index = -1)
    private LocalDate birthday;
    /**
     * 创建时间
     */
    private Date createTime;
}
