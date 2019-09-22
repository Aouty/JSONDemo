package com.aouty.jackson.jsonandbean;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * 电脑类
 */
public class Computer {

    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 使用天数：从激活日期开始
     */
    private int useDay;

    /**
     * 名称
     */
    private String name;
    /**
     * 全称
     */
    private String fullName;

    /**
     * 激活日期
     */
    private LocalDate activeDate;
    /**
     * 首次使用日期
     */
    private Date firstUseDate;
    /**
     * 系列
     */
    private String series;
    /**
     * 特点
     */
    private Map<String, Object> features;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUseDay() {
        return useDay;
    }

    public void setUseDay(int useDay) {
        this.useDay = useDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(LocalDate activeDate) {
        this.activeDate = activeDate;
    }

    public Date getFirstUseDate() {
        return firstUseDate;
    }

    public void setFirstUseDate(Date firstUseDate) {
        this.firstUseDate = firstUseDate;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Map<String, Object> getFeatures() {
        return features;
    }

    public void setFeatures(Map<String, Object> features) {
        this.features = features;
    }

    public Computer() {
    }

    public Computer(Integer id, int useDay, String name, String fullName, LocalDate activeDate, Date firstUseDate, String series, Map<String, Object> features) {
        this.id = id;
        this.useDay = useDay;
        this.name = name;
        this.fullName = fullName;
        this.activeDate = activeDate;
        this.firstUseDate = firstUseDate;
        this.series = series;
        this.features = features;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Computer computer = (Computer) o;
        return useDay == computer.useDay &&
                id.equals(computer.id) &&
                name.equals(computer.name) &&
                fullName.equals(computer.fullName) &&
                activeDate.equals(computer.activeDate) &&
                firstUseDate.equals(computer.firstUseDate) &&
                series.equals(computer.series) &&
                features.equals(computer.features);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, useDay, name, fullName, activeDate, firstUseDate, series, features);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", useDay=" + useDay +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", activeDate=" + activeDate +
                ", firstUseDate=" + firstUseDate +
                ", series='" + series + '\'' +
                ", features=" + features +
                '}';
    }
}
