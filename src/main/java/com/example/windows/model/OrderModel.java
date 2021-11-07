package com.example.windows.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.sql.Date;

@Data
@AllArgsConstructor
public class OrderModel {
    @JsonProperty(value = "windowID")
    private Long windowId;

    @JsonProperty(value = "customerID")
    private Long customerId;

    @JsonProperty(value = "date")
    private Date date;

    @JsonProperty(value = "cost")
    private int cost;
}
