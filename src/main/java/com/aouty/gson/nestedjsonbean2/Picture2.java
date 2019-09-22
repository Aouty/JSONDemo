package com.aouty.gson.nestedjsonbean2;

import lombok.Data;

/**
 * 自定义的Json实体
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
public class Picture2 {
    private int ret2;
    private Response2 response2;

    @Override
    public String toString() {
        return "Picture2{" +
                "ret2=" + ret2 +
                ", response2=" + response2 +
                '}';
    }
}
