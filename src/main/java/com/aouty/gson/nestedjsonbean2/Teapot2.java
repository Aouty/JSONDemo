package com.aouty.gson.nestedjsonbean2;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/**
 * 紫砂壶
 * Picture2$Response2$TagCategory2$Teapot2
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
public class Teapot2 {
    @SerializedName("规格")
    private List<String> specification;

    @SerializedName("泥料")
    private List<String> pug;

    @SerializedName("工艺")
    private List<String> crafts;

    @SerializedName("行业")
    private List<String> industry;

    @Override
    public String toString() {
        return "Teapot2{" +
                "specification=" + specification +
                ", pug=" + pug +
                ", crafts=" + crafts +
                ", industry=" + industry +
                '}';
    }
}
