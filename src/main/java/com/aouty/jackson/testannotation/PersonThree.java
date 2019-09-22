package com.aouty.jackson.testannotation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
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
@JsonRootName(value = "ThePerson")
@JsonIgnoreProperties(value = {"birthday","createTime"})
public class PersonThree {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
    /**
     * 出生日期:yyyy-MM-dd
     */
    private LocalDate birthday;
    /**
     * 创建时间
     */
    private Date createTime;
}
