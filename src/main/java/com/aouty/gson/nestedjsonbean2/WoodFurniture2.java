package com.aouty.gson.nestedjsonbean2;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

/**
 * 木器家具
 * Picture2$Response2$TagCategory2$WoodFurniture2
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
public class WoodFurniture2 {
    @SerializedName("材质")
    private List<String> material;

    @SerializedName("器型")
    private List<String> shage;

    @Override
    public String toString() {
        return "WoodFurniture2{" +
                "material=" + material +
                ", shage=" + shage +
                '}';
    }
}
