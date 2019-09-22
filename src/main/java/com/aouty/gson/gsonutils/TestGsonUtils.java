package com.aouty.gson.gsonutils;

import com.aouty.Mobile;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

/**
 * 测试Gson工具类
 */
public class TestGsonUtils {
    public static void main(String[] args) {
        String json = "[{\"id\":100,\"name\":\"AI Phone\",\"features\":{\"system\":\"A12.2\",\"capacity\":\"64G\"}},{}]";
        System.out.println("List<Mobile> list = GsonUtils.getObjectList(json, Mobile.class);");
        List<Mobile> list = GsonUtils.getObjectList(json, Mobile.class);
        list.forEach(System.out::println);
        System.out.println();

        System.out.println("List<Map> list2 = GsonUtils.getObjectList(json, Map.class);");
        List<Map> list2 = GsonUtils.getObjectList(json, Map.class);
        list2.forEach(System.out::println);
        System.out.println();

        System.out.println("List<Mobile> list3 = GsonUtils.getObjectList(json, new TypeToken<Mobile>() {});");
        List<Mobile> list3 = GsonUtils.getObjectList(json, new TypeToken<Mobile>() {
        });
        list3.forEach(System.out::println);
        System.out.println();

        System.out.println("List<Map> list4 = GsonUtils.getObjectList(json, new TypeToken<Map>() {});");
        List<Map> list4 = GsonUtils.getObjectList(json, new TypeToken<Map>() {
        });
        list4.forEach(System.out::println);
        System.out.println();
    }
}
