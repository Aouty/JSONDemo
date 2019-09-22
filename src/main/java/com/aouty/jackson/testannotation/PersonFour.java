package com.aouty.jackson.testannotation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
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
public class PersonFour {
    /**
     * 主键ID
     */
    @JsonProperty(value = "编号")
    private Integer id;
    /**
     * 姓名
     */
    @JsonProperty(value = "姓名")
    @JacksonXmlText
    @JacksonXmlCData
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
    @JacksonXmlProperty(isAttribute = true)
    private LocalDate birthday;
    /**
     * 创建时间
     */
    @JsonProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "GMT+8")
    private Date createTime;
}
