package com.aouty.gson.nestedjsonbean;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 自定义的Json实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Picture {
    private int ret;
    private Response response;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private TagCategory tagCategory;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class TagCategory {

            @SerializedName("中国画")
            //此注解不能用于外部类，即某个类无任何内部类时，此注解不用使用在类上
            private ChinaPicture chinaPicture;

            /**
             * 中国画
             */
            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            public static class ChinaPicture {
                @SerializedName("年代")
                private List<String> ages;
                @SerializedName("技法")
                private List<String> techniques;
                @SerializedName("题材")
                private List<String> topic;
                @SerializedName("规格")
                private List<String> specification;
            }

            @SerializedName("书法")
            private Calligraphy calligraphy;

            /**
             * 书法
             */
            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Calligraphy {
                @SerializedName("分类")
                private List<String> classification;
                @SerializedName("书体")
                private List<String> chirography;
                @SerializedName("规格")
                private List<String> specification;
            }

            @SerializedName("西方绘画")
            private WesternPicture westernPicture;

            /**
             * 西方绘画
             */
            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            public static class WesternPicture {
                @SerializedName("技法")
                private List<String> techniques;
                @SerializedName("题材")
                private List<String> topic;
            }

            @SerializedName("邮品")
            private Stamps stamps;

            /**
             * 邮品
             */
            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Stamps {
                @SerializedName("分类")
                private List<String> classification;
                @SerializedName("规格")
                private List<String> specification;
            }

            @SerializedName("钱币")
            private Money money;

            /**
             * 钱币
             */
            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Money {
                @SerializedName("分类")
                private List<String> classification;
                @SerializedName("国家")
                private List<String> country;
                @SerializedName("规格")
                private List<String> specification;
            }

            @SerializedName("瓷器")
            private China china;

            /**
             * 瓷器
             */
            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            public static class China {
                @SerializedName("年代")
                private List<String> ages;
                @SerializedName("分类")
                private List<String> classification;
            }

            @SerializedName("紫砂壶")
            private Teapot teapot;

            /**
             * 紫砂壶
             */
            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Teapot {
                @SerializedName("规格")
                private List<String> specification;
                @SerializedName("泥料")
                private List<String> pug;
                @SerializedName("工艺")
                private List<String> crafts;
                @SerializedName("行业")
                private List<String> industry;
            }

            @SerializedName("金银铜器")
            private MetalTool metalTool;

            /**
             * 金银铜器
             */
            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            public static class MetalTool {
                @SerializedName("年代")
                private List<String> years;
                @SerializedName("分类")
                private List<String> classification;
            }

            @SerializedName("木器家具")
            private WoodFurniture woodfurniture;

            /**
             * 木器家具
             */
            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            public static class WoodFurniture {
                @SerializedName("材质")
                private List<String> material;
                @SerializedName("器型")
                private List<String> shape;
            }

            @SerializedName("玉石翡翠")
            private Emerald emerald;

            /**
             * 玉石翡翠
             */
            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Emerald {
                @SerializedName("材质")
                private List<String> material;
                @SerializedName("镶嵌")
                private List<String> inlay;
                @SerializedName("分类")
                private List<String> classification;
            }

            @SerializedName("红木文玩")
            private RedWoodHeritage redWoodHeritage;

            /**
             * 红木文玩
             */
            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            public static class RedWoodHeritage {
                @SerializedName("分类")
                private List<String> classification;
                @SerializedName("材质")
                private List<String> material;
            }

            @SerializedName("杂项")
            private OtherItems otherItems;

            /**
             * 杂项
             */
            @Data
            @AllArgsConstructor
            @NoArgsConstructor
            public static class OtherItems {
                @SerializedName("年代")
                private List<String> ages;
            }
        }
    }
}
