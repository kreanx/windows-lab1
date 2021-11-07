package com.example.windows.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
public class ColorModel {
    @JsonProperty(value = "name")
    private String name;
}
