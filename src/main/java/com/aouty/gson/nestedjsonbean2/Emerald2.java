package com.aouty.gson.nestedjsonbean2;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/**
 * 玉石翡翠
 * Picture2$Response2$TagCategory2$Emerald2
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
public class Emerald2 {
    @SerializedName("材质")
    private List<String> material;

    @SerializedName("镶嵌")
    private List<String> inlay;

    @SerializedName("分类")
    private List<String> classification;

    @Override
    public String toString() {
        return "Emerald2{" +
                "material=" + material +
                ", inlay=" + inlay +
                ", classification=" + classification +
                '}';
    }
}
