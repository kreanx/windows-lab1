package com.example.windows.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
public class CustomerModel {
    @JsonProperty(value = "fullName")
    private String fullName;

    @JsonProperty(value = "phone")
    private String phone;

    @JsonProperty(value = "address")
    private String address;
}
