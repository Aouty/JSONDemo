package com.aouty;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 生成手机工具类
 */
public class GenerateMobile {

    /**
     * 生成全属性的Mobile
     *
     * @return Mobile
     * @author Aouty
     */
    public static Mobile generateMobile() {
        Map<String, Object> features = new LinkedHashMap<>();
        features.put("system", "A12.2");
        features.put("capacity", "64G");

        return new Mobile(1, "iPhone Xs Max", "iPhone Xs Max", "Aouty's iPhone",
                LocalDate.of(2019, 05, 23), "iPhone Xs Max", features);
    }

    /**
     * 生成含部分属性的Mobile
     *
     * @return Mobile
     * @author Aouty
     */
    public static Mobile generateMobileWithSomeProps() {
        Map<String, Object> features = new LinkedHashMap<>();
        features.put("system", "A12.2");
        features.put("capacity", "64G");

        Mobile mobile = new Mobile();
        mobile.setId(2);
        mobile.setName("iPhone Xs Max");
        mobile.setEname(null);
        mobile.setSignature("");
        mobile.setActiveDate(LocalDate.of(2019, 5, 23));
        mobile.setFeatures(features);
        return mobile;
    }
}
