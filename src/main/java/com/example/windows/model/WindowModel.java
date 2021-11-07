package com.example.windows.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
public class WindowModel {
    @JsonProperty(value = "brandID")
    private Long brandId;

    @JsonProperty(value = "typeID")
    private Long typeId;

    @JsonProperty(value = "openingTypeID")
    private Long openingTypeId;

    @JsonProperty(value = "width")
    private int width;

    @JsonProperty(value = "height")
    private int height;

    @JsonProperty(value = "hasChildLock")
    private boolean hasChildLock;

    @JsonProperty(value = "colorID")
    private Long colorId;

    @JsonProperty(value = "materialID")
    private Long materialId;

    @JsonProperty(value = "glazingTypeID")
    private Long glazingTypeId;

    @JsonProperty(value = "yearsGuaranteed")
    private Long yearsGuaranteed;
}
