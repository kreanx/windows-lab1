package com.example.windows.controller;

import com.example.windows.entity.Color;
import com.example.windows.model.ColorModel;
import com.example.windows.service.ColorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/colors")
public class ColorController {
    private final ColorService colorService;

    @PostMapping
    public ResponseEntity<Color> addColor(@RequestBody ColorModel colorModel) {
        return new ResponseEntity<>(colorService.addColor(colorModel), HttpStatus.CREATED);
    }
}
