package com.aouty.gson.nestedjsonbean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

/**
 * 测试JsonBean
 */
public class TestPicture {
    public static void main(String[] args) {
        String jsonValue = "{'ret':0, " +
                "    'response':{ " +
                "        'tagCategory':{ " +
                "            '中国画':{ " +
                "                '年代':['先秦两汉','战国楚国','魏晋南北','隋唐五代','南宋北宋','元代','明清','近现代','年代不详','其他'], " +
                "                '技法':['泼墨','工笔','写意','白描','写生','皴法','没骨','指头画','其他']" +
                "            }, " +
                "            '书法':{ " +
                "                '分类':['书法','碑帖','写本写经','书札文牍','其他'], " +
                "                '书体':['篆书','隶书','楷书','草书','行书','其他']" +
                "            }" +
                "        } " +
                "    } " +
                "}";


        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        System.out.println("Picture");
        Picture picture = gson.fromJson(jsonValue, Picture.class);
        System.out.println(picture);
        System.out.println();

        System.out.println("Picture.Response");
        Picture.Response response = picture.getResponse();
        System.out.println(response.toString());
        System.out.println();

        //中国画：年代、技法
        System.out.println("中国画-年代：");
        Picture.Response.TagCategory.ChinaPicture chinaPicture = response.getTagCategory().getChinaPicture();
        List<String> ages = chinaPicture.getAges();
        ages.forEach(i-> System.out.print(i+"\t\t"));
        System.out.println();

        System.out.println("中国画-技法：");
        List<String> techniques = chinaPicture.getTechniques();
        techniques.forEach(i-> System.out.print(i+"\t\t"));
        System.out.println();
    }
}
