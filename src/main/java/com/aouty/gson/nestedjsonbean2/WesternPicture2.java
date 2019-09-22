package com.aouty.gson.nestedjsonbean2;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/**
 * 西方绘画
 * Picture2$Response2$TagCategory2$WesternPicture2
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
public class WesternPicture2 {
    @SerializedName("技法")
    private List<String> techniques;

    @SerializedName("题材")
    private List<String> topic;

    @Override
    public String toString() {
        return "WesternPicture2{" +
                "techniques=" + techniques +
                ", topic=" + topic +
                '}';
    }
}
