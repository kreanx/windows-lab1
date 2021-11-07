package com.example.windows.dto;

import lombok.*;

import java.sql.Date;

@Data
@AllArgsConstructor
public class ErrorDto {

    private String message;

    private Date timestamp;

}
