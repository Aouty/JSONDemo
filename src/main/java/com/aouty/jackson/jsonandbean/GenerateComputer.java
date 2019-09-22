package com.aouty.jackson.jsonandbean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 生成电脑工具类
 */
public class GenerateComputer {

    /**
     * 生成全属性的Computer
     *
     * @return Computer
     * @author Aouty
     */
    public static Computer generateComputer() {
        Map<String, Object> features = new LinkedHashMap<>();
        features.put("system", "Win 7 Ultimate");
        features.put("CPU", "Intel Core i5");

        LocalDate localDate = LocalDate.of(2019, 5, 5);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.now());
        long milli = localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();

        return new Computer(1, 100, "联想小新", "联想小新V1070",
                localDate, new Date(milli), "Lenovo", features);
    }

    /**
     * 生成含部分属性的Computer
     *
     * @return Computer
     * @author Aouty
     */
    public static Computer generateComputerWithSomeProps() {
        Map<String, Object> features = new LinkedHashMap<>();
        features.put("system", "Win 10 Pro");
        features.put("CPU", "Intel Core i5");

        Computer computer = new Computer();
        computer.setId(2);
        computer.setUseDay(200);
        computer.setName("联想大新");
//        computer.setFullName("联想大新V2080");

        LocalDate localDate = LocalDate.of(2019, 6, 6);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.now());
        long milli = localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();

        computer.setActiveDate(localDate);
        computer.setFirstUseDate(new Date(milli));
        computer.setSeries(null);
        computer.setFeatures(features);
        return computer;
    }
}
