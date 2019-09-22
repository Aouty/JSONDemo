package com.aouty;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

/**
 * 手机
 */
//@Data注解的toString()：BeanName(prop1=value2,prop2=value2),不推荐使用
//重写Object的toString():BeanName{prop1=value2,prop2=value2}
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Mobile {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 中文名称
     */
    private String name;
    /**
     * 英文名称
     */
    private String ename;
    /**
     * 个性签名
     */
    private String signature;
    /**
     * 激活日期
     */
    private LocalDate activeDate;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public LocalDate getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(LocalDate activeDate) {
        this.activeDate = activeDate;
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

    public Mobile() {
    }

    public Mobile(Integer id, String name, String ename, String signature, LocalDate activeDate, String series, Map<String, Object> features) {
        this.id = id;
        this.name = name;
        this.ename = ename;
        this.signature = signature;
        this.activeDate = activeDate;
        this.series = series;
        this.features = features;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ename='" + ename + '\'' +
                ", signature='" + signature + '\'' +
                ", activeDate=" + activeDate +
                ", series='" + series + '\'' +
                ", features=" + features +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mobile mobile = (Mobile) o;
        return Objects.equals(id, mobile.id) &&
                Objects.equals(name, mobile.name) &&
                Objects.equals(ename, mobile.ename) &&
                Objects.equals(signature, mobile.signature) &&
                Objects.equals(activeDate, mobile.activeDate) &&
                Objects.equals(series, mobile.series) &&
                Objects.equals(features, mobile.features);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ename, signature, activeDate, series, features);
    }
}
