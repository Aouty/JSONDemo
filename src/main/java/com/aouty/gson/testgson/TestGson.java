package com.aouty.gson.testgson;

import com.aouty.GenerateMobile;
import com.aouty.Mobile;
import com.google.gson.*;

import java.util.*;

/**
 * Gson测试
 */
public class TestGson {
    public static void main(String[] args){
        System.out.println("################################### Gson ###################################");
        Mobile mobile = GenerateMobile.generateMobile();
        System.out.println("Mobile的toString():\n" + mobile);
        Mobile mobileWithSomeProps = GenerateMobile.generateMobileWithSomeProps();
        System.out.println("\nMobile的toString():\n" + mobileWithSomeProps);

        Gson gson = new Gson();
        //1.将对象转换为JSON
        System.out.println("====================================将对象转换为JSON====================================");
        String jsonMobile = gson.toJson(mobile);
        System.out.println("\n将单个对象使用Gson的toJson方法进行转换:\n" + jsonMobile);
        //生成的JSON字符串中不包含null值或者未设置值得属性,但是包含""值的属性
        String jsonMobileWithSomeProps = gson.toJson(mobileWithSomeProps);
        System.out.println("\n将仅包含部分属性的单个对象使用Gson的toJson方法进行转换:\n" + jsonMobileWithSomeProps);

        //2.将对象集合转换为JSON
        System.out.println("====================================将对象集合转换为JSON====================================");
        List<Mobile> mobiles = Arrays.asList(mobile, mobileWithSomeProps);
        String jsonMobiles = gson.toJson(mobiles);
        System.out.println("\n将对象集合使用Gson的toJson方法进行转换:\n" + jsonMobiles);

        //3.将Map转换为JSON
        System.out.println("====================================将Map转换为JSON====================================");
        Map<String, Object> features = mobile.getFeatures();
        String jsonByMap = gson.toJson(features);
        System.out.println("\n将Map使用Gson的toJson方法进行转换:\n" + jsonByMap);
        String jsonByEmptyMap = gson.toJson(Collections.EMPTY_MAP);
        System.out.println("\n将没有任何元素的空Map使用Gson的toJson方法进行转换:\n" + jsonByEmptyMap);

        //4.将List<Map>转换为JSON
        System.out.println("====================================将List<Map>转换为JSON====================================");
        String jsonByList = gson.toJson(Arrays.asList(features, Collections.EMPTY_MAP));
        System.out.println("\n将List使用Gson的toJson方法进行转换:\n" + jsonByList);
        String jsonByEmptyList = gson.toJson(Collections.EMPTY_LIST);
        System.out.println("\n将没有任何元素的List使用Gson的toJson方法进行转换:\n" + jsonByEmptyList);
        String jsonByIncludeEmptyList = gson.toJson(Arrays.asList(Collections.EMPTY_MAP));
        System.out.println("\n将仅包含一个空Map的List使用Gson的toJson方法进行转换:\n" + jsonByIncludeEmptyList);
        System.out.println();

        Gson gson2 = new com.google.gson.GsonBuilder().create();
        //1.将一个JSON格式字符串解析为特定对象
        System.out.println("====================================将一个JSON格式字符串解析为特定对象====================================");
        String jsonStr = "{\"id\":100,\"name\":\"AI Phone\",\"features\":{\"system\":\"A12.2\",\"capacity\":\"64G\"}}";
        Mobile mobileByJson = gson2.fromJson(jsonStr, Mobile.class);
        System.out.println("将JSON格式字符串使用Gson的fromJson方法进行转换：\n" + mobileByJson);

        //2.将一个JSON格式字符串解析为对象集合
        System.out.println("====================================将一个JSON格式字符串解析为对象集合：使用JsonParser类====================================");
        JsonParser jsonParser = new JsonParser();
        String jsonSpaceArray = "[]";
        List<Mobile> mobileList = new ArrayList<>();
        JsonArray jsonArray = jsonParser.parse(jsonSpaceArray).getAsJsonArray();
        for (JsonElement jsonElement : jsonArray) {
            mobileList.add(gson2.fromJson(jsonElement,Mobile.class));
        }
        System.out.println("\n将空数组的JSON格式字符串转换为集合：\n" + mobileList);
        String jsonSpaceArray2 = "[{}]";
        List<Mobile> mobileList2 = new ArrayList<>();
        jsonArray = jsonParser.parse(jsonSpaceArray2).getAsJsonArray();
        for (JsonElement jsonElement : jsonArray) {
            mobileList2.add(gson2.fromJson(jsonElement,Mobile.class));
        }
        System.out.println("\n将空数组的JSON格式字符串转换为集合：\n" + mobileList2);
        String jsonArrayStr = "[{\"id\":100,\"name\":\"AI Phone\",\"features\":{\"system\":\"A12.2\",\"capacity\":\"64G\"}},{}]";
        List<Mobile> mobileList3 = new ArrayList<>();
        jsonArray = jsonParser.parse(jsonArrayStr).getAsJsonArray();
        for (JsonElement jsonElement : jsonArray) {
            mobileList3.add(gson2.fromJson(jsonElement,Mobile.class));
        }
        System.out.println("\n将数组的JSON格式字符串转换为集合：\n" + mobileList3);

        //3.将一个JSON格式字符串解析为Map：使用类的class对象和对象的getClass()方法
        System.out.println("====================================将一个JSON格式字符串解析为Map：使用类的class对象和对象的getClass()方法====================================");
        Map<String, Object> mapByJson = gson2.fromJson(jsonStr, Map.class);
        System.out.println("\n将JSON格式字符串使用Gson的fromJson方法进行转换：\n" + mapByJson);
        Map<String, Object> mapByJson2 = gson2.fromJson(jsonStr, new LinkedHashMap<String, Object>().getClass());
        System.out.println("\n将JSON格式字符串使用Gson的fromJson方法进行转换：\n" + mapByJson2);
        String jsonStr2 = "{}";
        Map mapByJson3 = gson2.fromJson(jsonStr2, Map.class);
        System.out.println("\n将JSON格式字符串使用Gson的fromJson方法进行转换：\n" + mapByJson3);

        //4.将一个JSON格式字符串解析为List<Map>
        System.out.println("====================================将一个JSON格式字符串解析为List<Map>====================================");
        List<Map<String,Object>> mapList = new ArrayList<>();
        jsonArray = jsonParser.parse(jsonSpaceArray).getAsJsonArray();
        for (JsonElement jsonElement : jsonArray) {
            mapList.add(gson2.fromJson(jsonElement,Map.class));
        }
        System.out.println("\n将JSON格式字符串使用Gson的fromJson方法进行转换：\n" + mapList);
        List<Map<String,Object>> mapList2 = new ArrayList<>();
        jsonArray = jsonParser.parse(jsonSpaceArray2).getAsJsonArray();
        for (JsonElement jsonElement : jsonArray) {
            mapList2.add(gson2.fromJson(jsonElement,Map.class));
        }
        System.out.println("\n将JSON格式字符串使用Gson的fromJson方法进行转换：\n" + mapList2);
        List<Map<String,Object>> mapList3 = new ArrayList<>();
        jsonArray = jsonParser.parse(jsonArrayStr).getAsJsonArray();
        for (JsonElement jsonElement : jsonArray) {
            mapList3.add(gson2.fromJson(jsonElement,Map.class));
        }
        System.out.println("\n将JSON格式字符串使用Gson的fromJson方法进行转换：\n" + mapList3);

        System.out.println("====================================测试JsonElement的toString()和getAsString()方法====================================");
        String json = "{\"chase\":\"freedom\"}";
        com.google.gson.JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(json);
        System.out.println(String.format("Json:【%s】", json));
        System.out.println("调用JsonElement的toString():" + jsonElement.toString());
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        System.out.println("调用JsonElement的getAsString():" + jsonObject.get("chase").getAsString());
        System.out.println("调用JsonElement的toString():" + jsonObject.get("chase").toString());
        System.out.println();

        String json2 = "{\"chase\":100}";
        com.google.gson.JsonParser parser2 = new JsonParser();
        JsonElement jsonElement2 = parser2.parse(json2);
        System.out.println(String.format("Json:【%s】", json2));
        System.out.println("调用JsonElement的toString():" + jsonElement2.toString());
        JsonObject jsonObject2 = jsonElement2.getAsJsonObject();
        System.out.println("调用JsonElement的getAsString():" + jsonObject2.get("chase").getAsString());
        System.out.println("调用JsonElement的toString():" + jsonObject2.get("chase").toString());


    }
}
