package com.aouty.gson.nestedjsonbean2;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * 标签分类
 * Picture2$Response2$TagCategory2
 *
 * @see Picture2
 * @see Response2
 * @see TagCategory2
 * @see ChinaPicture2
 * @see Calligraphy2
 * @see WesternPicture2
 * @see Stamps2
 * @see Money2
 * @see China2
 * @see Teapot2
 * @see MetalTool2
 * @see WoodFurniture2
 * @see Emerald2
 * @see RedWoodHeritage2
 * @see OtherItems2
 */
@Data
public class TagCategory2 {
    @SerializedName("中国画")
    private ChinaPicture2 chinaPicture2;

    @SerializedName("书法")
    private Calligraphy2 calligraphy2;

    @Override
    public String toString() {
        return "TagCategory2{" +
                "chinaPicture2=" + chinaPicture2 +
                ", calligraphy2=" + calligraphy2 +
                '}';
    }
}
