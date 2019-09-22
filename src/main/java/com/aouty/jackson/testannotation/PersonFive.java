package com.aouty.jackson.testannotation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 人物类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName(value = "人物")
public class PersonFive {
    /**
     * 主键ID
     */
    @JsonProperty(value = "编号")
    private Integer id;
    /**
     * 姓名
     */
    @JsonProperty(value = "姓名")
    private String name;
    /**
     * 年龄
     */
    @JsonProperty(value = "年龄")
    private int age;
    /**
     * 出生日期:yyyy-MM-dd
     */
    @JsonProperty(value = "出生日期")
    @JsonFormat(pattern = "yyyy年MM月dd日")
    private LocalDate birthday;
    /**
     * 介绍
     */
    @JsonProperty(value = "介绍")
    private Map<String, String> introduce;
    /**
     * 爱好
     */
    @JsonProperty(value = "爱好")
    private List<String> hobby;
    /**
     * 创建时间
     */
    @JsonProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "GMT+8")
    private Date createTime;
}
