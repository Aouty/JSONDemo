package com.aouty.gson.nestedjsonbean2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

/**
 * 测试JsonBean
 */
public class TestPicture2 {
    public static void main(String[] args) {
        String jsonValue = "{'ret2':0, " +
                "    'response2':{ " +
                "        'tagCategory2':{ " +
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
        System.out.println("Picture2");
        Picture2 picture2 = gson.fromJson(jsonValue, Picture2.class);
        System.out.println(picture2);
        System.out.println();

        System.out.println("Picture2$Response2");
        Response2 response2 = picture2.getResponse2();
        System.out.println(response2);
        System.out.println();

        //中国画：年代、技法
        System.out.println("中国画-年代：");
        ChinaPicture2 chinaPicture2 = response2.getTagCategory2().getChinaPicture2();
        List<String> ages = chinaPicture2.getAges();
        ages.forEach(i-> System.out.print(i+"\t\t"));
        System.out.println();

        System.out.println("中国画-技法：");
        List<String> techniques= chinaPicture2.getTechniques();
        techniques.forEach(i-> System.out.print(i+"\t\t"));
        System.out.println();
    }
}
