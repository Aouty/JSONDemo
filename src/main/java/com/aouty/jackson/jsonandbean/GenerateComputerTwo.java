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
public class GenerateComputerTwo {

    /**
     * 生成全属性的Computer
     *
     * @return ComputerTwo
     * @author Aouty
     */
    public static ComputerTwo generateComputerTwo() {
        Map<String, Object> features = new LinkedHashMap<>();
        features.put("system", "Win 7 Ultimate");
        features.put("CPU", "Intel Core i5");

        LocalDate localDate = LocalDate.of(2019, 5, 5);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.now());
        long milli = localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();

        return new ComputerTwo(1, 100, "联想小新", "联想小新V1070",
                localDate, new Date(milli), "Lenovo", features);
    }

    /**
     * 生成含部分属性的Computer
     *
     * @return ComputerTwo
     * @author Aouty
     */
    public static ComputerTwo generateComputerTwoWithSomeProps() {
        Map<String, Object> features = new LinkedHashMap<>();
        features.put("system", "Win 10 Pro");
        features.put("CPU", "Intel Core i5");

        ComputerTwo computerTwo = new ComputerTwo();
        computerTwo.setId(2);
        computerTwo.setUseDay(200);
        computerTwo.setName("联想大新");
//        computerTwo.setFullName("联想大新V2080");

        LocalDate localDate = LocalDate.of(2019, 6, 6);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.now());
        long milli = localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();

        computerTwo.setActiveDate(localDate);
        computerTwo.setFirstUseDate(new Date(milli));
        computerTwo.setSeries(null);
        computerTwo.setFeatures(features);
        return computerTwo;
    }
}
