package com.example.windows.serviceimpl;

import com.example.windows.entity.*;
import com.example.windows.repository.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.windows.model.ColorModel;
import com.example.windows.service.ColorService;

@Service
@AllArgsConstructor
public class ColorServiceImpl implements ColorService {
    private final ColorRepository colorRepository;

    @Override
    public Color addColor(ColorModel colorModel) {
        Color color = Color.builder()
                .name(colorModel.getName())
                .build();
        colorRepository.save(color);
        return color;
    }
}
