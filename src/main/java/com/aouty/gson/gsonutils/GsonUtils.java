package com.aouty.gson.gsonutils;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Gson工具类
 */
@SuppressWarnings("WeakerAccess")
public class GsonUtils {

    /**
     * 将JSON格式的字符串转换为特定对象(支持Map)
     * 如果此字符串中存在空对象的子字符串，会被转换为一个空对象
     *
     * @param jsonString JSON格式字符串
     * @param cls        特定对象的class
     * @param <T>        特定对象
     * @return 对象
     * @author Aouty
     */
    public static <T> T getObject(String jsonString, Class<T> cls) {
        T t = null;
        try {
            Gson gson = new Gson();
            JsonArray jsonArray = new JsonParser().parse(jsonString).getAsJsonArray();
            for (JsonElement jsonElement : jsonArray) {
                t = gson.fromJson(jsonElement, cls);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 将JSON格式的字符串转换为特定对象(支持Map)
     * 如果此字符串中存在空对象的子字符串，会被转换为一个空对象
     *
     * @param jsonString JSON格式字符串
     * @param typeToken  指示类对象
     * @param <T>        特定对象
     * @return 对象
     * @author Aouty
     */
    public static <T> T getObject(String jsonString, TypeToken<T> typeToken){
        T t = null;
        try {
            Gson gson = new Gson();
            JsonArray jsonArray = new JsonParser().parse(jsonString).getAsJsonArray();
            for (JsonElement jsonElement : jsonArray) {
                t = gson.fromJson(jsonElement, typeToken.getType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 将JSON格式的字符串转换为特定对象集合(支持Map)
     * 如果此字符串中存在空对象的子字符串，会被转换为一个空对象
     *
     * @param jsonString JSON格式字符串
     * @param cls        特定对象的class
     * @param <T>        特定对象
     * @return 对象集合
     * @author Aouty
     */
    public static <T> List<T> getObjectList(String jsonString, Class<T> cls) {
        List<T> list = new ArrayList<>();
        try {
            Gson gson = new Gson();
            JsonArray jsonArray = new JsonParser().parse(jsonString).getAsJsonArray();
            for (JsonElement jsonElement : jsonArray) {
                list.add(gson.fromJson(jsonElement, cls));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 将JSON格式的字符串转换为特定对象集合(支持Map)
     * 如果此字符串中存在空对象的子字符串，会被转换为一个空对象
     *
     * @param jsonString JSON格式字符串
     * @param typeToken  指示类对象
     * @param <T>        特定对象
     * @return 对象集合
     * @author Aouty
     */
    public static <T> List<T> getObjectList(String jsonString, TypeToken<T> typeToken){
        List<T> list = new ArrayList<>();
        try {
            Gson gson = new Gson();
            JsonArray jsonArray = new JsonParser().parse(jsonString).getAsJsonArray();
            for (JsonElement jsonElement : jsonArray) {
                list.add(gson.fromJson(jsonElement, typeToken.getType()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}

