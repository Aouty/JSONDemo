package com.aouty.gson.nestedjsonbean2;

import lombok.Data;

/**
 * 响应数据
 * Picture2$Response2
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
public class Response2 {

    private TagCategory2 tagCategory2;

    @Override
    public String toString() {
        return "Response2{" +
                "tagCategory2=" + tagCategory2 +
                '}';
    }
}
