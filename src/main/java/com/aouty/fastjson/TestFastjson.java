package com.aouty.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.aouty.GenerateMobile;
import com.aouty.Mobile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 测试fastjson
 */
public class TestFastjson {
    public static void main(String[] args) {
        System.out.println("################################### fastjson ###################################");
        Mobile mobile = GenerateMobile.generateMobile();
        System.out.println("Mobile的toString():\n" + mobile);
        Mobile mobileWithSomeProps = GenerateMobile.generateMobileWithSomeProps();
        System.out.println("\nMobile的toString():\n" + mobileWithSomeProps);
        System.out.println();

        //1.将Java对象转换为JSON字符串
        System.out.println("====================================将Java对象转换为JSON字符串====================================");
        String jsonMobile = JSON.toJSONString(mobile);
        System.out.println("将单个对象使用JSON的toJSONString方法进行转换:\n" + jsonMobile);
        //生成的JSON字符串中不包含null值或者未设置值得属性,但是包含""值的属性
        String jsonMobileWithSomeProps = JSON.toJSONString(mobileWithSomeProps);
        System.out.println("\n将仅包含部分属性的单个对象使用JSON的toJSONString方法进行转换:\n" + jsonMobileWithSomeProps);
        System.out.println();

        //2.将Java对象转换为JSONObject
        System.out.println("====================================将Java对象转换为JSONObject====================================");
        JSONObject jsonObject = (JSONObject) JSON.toJSON(mobile);
        System.out.println("将单个对象使用JSON的toJSON方法进行转换:\n" + jsonObject);
        //生成的JSON字符串中不包含null值或者未设置值得属性,但是包含""值的属性
        JSONObject jsonObjectWithSomeProps = (JSONObject) JSON.toJSON(mobileWithSomeProps);
        System.out.println("\n将仅包含部分属性的单个对象使用JSON的toJSON方法进行转换:\n" + jsonObjectWithSomeProps);
        System.out.println();

        //1.将Java对象集合转换为JSON字符串
        System.out.println("====================================将Java对象集合转换为JSON字符串====================================");
        List<Mobile> mobiles = Arrays.asList(mobile, mobileWithSomeProps);
        String jsonMobiles = JSON.toJSONString(mobiles);
        System.out.println("将对象集合用JSON的toJSONString方法进行转换:\n" + jsonMobiles);
        System.out.println();

        //2.将Java对象集合转换为JSONArray
        System.out.println("====================================将Java对象集合转换为JSONArray====================================");
        JSONArray jsonArray = (JSONArray) JSON.toJSON(mobiles);
        System.out.println("将对象集合用JSON的toJSON方法进行转换:\n" + jsonArray);
        System.out.println();

        //1.将JSON字符串转换为JSONObject
        System.out.println("====================================将JSON字符串转换为JSONObject====================================");
        JSONObject jsonObjectByString = JSON.parseObject(jsonMobile);
        System.out.println("将JSON字符串使用JSON的toJSON方法进行转换:\n" + jsonObjectByString);
        System.out.println();

        //2.将JSON字符串装好为JSONArray
        System.out.println("====================================将JSON字符串装好为JSONArray====================================");
        JSONArray jsonArrayByString = JSON.parseArray(jsonMobiles);
        System.out.println("将JSON字符串使用JSON的toJSON方法进行转换:\n" + jsonArrayByString);
        System.out.println();

        //3.将JSON字符串转换为Java对象
        System.out.println("====================================将JSON字符串装好为Java对象====================================");
        Mobile mobileByJson = JSON.parseObject(jsonMobile, Mobile.class);
        System.out.println("将JSON字符串使用JSON的parseObject方法进行转换:\n" + mobileByJson);
        Mobile mobileByJson2 = JSON.parseObject(jsonMobile, new TypeReference<Mobile>() {
        });
        System.out.println("将JSON字符串使用JSON的parseObject方法进行转换:\n" + mobileByJson2);
        System.out.println();

        //4.将JSON字符串转换为Java对象集合
        System.out.println("====================================将JSON字符串转换为Java对象集合====================================");
        List<Mobile> mobileListByJson = JSON.parseArray(jsonMobiles, Mobile.class);
        System.out.println("将JSON字符串使用JSON的parseArray方法进行转换:\n" + mobileListByJson);
        List<Mobile> mobileListByJson2 = JSON.parseObject(jsonMobiles, new TypeReference<List<Mobile>>() {
        });
        System.out.println("将JSON字符串使用JSON的parseArray方法进行转换:\n" + mobileListByJson2);
        System.out.println();

        //1.将JSONObject转换为JSON字符串
        System.out.println("====================================将JSONObject转换为JSON字符串====================================");
        String stringByJsonObject = JSON.toJSONString(jsonObject);
        System.out.println("将JSONObject使用JSON的toJSONString方法进行转换:\n" + stringByJsonObject);
        System.out.println();

        //2.将JSONObject转换为Java对象
        System.out.println("====================================将JSONObject转换为Java对象====================================");
        Mobile mobileByJsonObject = JSON.toJavaObject(jsonObject, Mobile.class);
        System.out.println("将JSONObject使用JSON的toJavaObject方法进行转换:\n" + mobileByJsonObject);
        System.out.println();

        //1.将JSONArray转换为JSON字符串
        System.out.println("====================================将JSONArray转换为JSON字符串====================================");
        String stringByJsonArray = JSON.toJSONString(jsonArray);
        System.out.println("将JSONArray使用JSON的toJSONString方法进行转换:\n" + stringByJsonArray);
        System.out.println();

        //2.将JSONArray转换为Java对象集合
        System.out.println("====================================将JSONArray转换为Java对象集合====================================");
        List<Mobile> mobileListByJsonArray = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            mobileListByJsonArray.add(JSON.toJavaObject(jsonArray.getJSONObject(i), Mobile.class));
        }
        System.out.println("将JSONArray使用JSON的toJavaObject和JSONArray的getJSONObject方法进行转换:\n" + mobileListByJsonArray);
        System.out.println();

    }
}
