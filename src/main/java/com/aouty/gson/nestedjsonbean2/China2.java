package com.aouty.gson.nestedjsonbean2;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/**
 * 瓷器
 * Picture2$Response2$TagCategory2$China2
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
public class China2 {
    @SerializedName("年代")
    private List<String> ages;

    @SerializedName("分类")
    private List<String> classification;

    @Override
    public String toString() {
        return "China2{" +
                "ages=" + ages +
                ", classification=" + classification +
                '}';
    }
}
