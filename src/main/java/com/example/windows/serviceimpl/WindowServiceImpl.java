package com.example.windows.serviceimpl;

import com.example.windows.entity.WindowType;
import com.example.windows.entity.Color;
import com.example.windows.entity.Brand;
import com.example.windows.entity.GlazingType;
import com.example.windows.entity.Material;
import com.example.windows.entity.OpeningType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.windows.entity.Window;
import com.example.windows.exception.ResourceNotFoundException;
import com.example.windows.model.WindowModel;
import com.example.windows.repository.WindowRepository;
import com.example.windows.repository.WindowTypeRepository;
import com.example.windows.repository.ColorRepository;
import com.example.windows.repository.BrandRepository;
import com.example.windows.repository.GlazingTypeRepository;
import com.example.windows.repository.MaterialRepository;
import com.example.windows.repository.OpeningTypeRepository;
import com.example.windows.service.WindowService;

@Service
@AllArgsConstructor
public class WindowServiceImpl implements WindowService {

    private final WindowRepository windowRepository;
    private final WindowTypeRepository windowTypeRepository;
    private final ColorRepository colorRepository;
    private final BrandRepository brandRepository;
    private final GlazingTypeRepository glazingTypeRepository;
    private final MaterialRepository materialRepository;
    private final OpeningTypeRepository openingTypeRepository;

    @Override
    public Window getWindowById(Long id) {
        return windowRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The window with id " + id + " does not exist."));
    }

    @Override
    public Window addWindow(WindowModel windowModel) {
        WindowType type = windowTypeRepository
                .findById(windowModel.getTypeId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The window type with id " + windowModel.getTypeId() + " does not exist."));
        Color color = colorRepository
                .findById(windowModel.getColorId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The color with id " + windowModel.getColorId() + " does not exist."));
        Brand brand = brandRepository
                .findById(windowModel.getBrandId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The brand with id " + windowModel.getBrandId() + " does not exist."));
        GlazingType glazingType = glazingTypeRepository
                .findById(windowModel.getGlazingTypeId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The glazing type with id " + windowModel.getGlazingTypeId() + " does not exist."));
        Material material = materialRepository
                .findById(windowModel.getMaterialId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The material with id " + windowModel.getMaterialId() + " does not exist."));
        OpeningType openingType = openingTypeRepository
                .findById(windowModel.getOpeningTypeId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The opening type with id " + windowModel.getOpeningTypeId() + " does not exist."));

        Window window = Window.builder()
                .brand(brand)
                .type(type)
                .openingType(openingType)
                .width(windowModel.getWidth())
                .height(windowModel.getHeight())
                .hasChildLock(windowModel.isHasChildLock())
                .color(color)
                .material(material)
                .glazingType(glazingType)
                .yearsGuaranteed(windowModel.getYearsGuaranteed())
                .build();
        windowRepository.save(window);
        return window;
    }

    @Override
    public Window updateWindow(Long id, WindowModel windowModel) {
        if (!windowRepository.existsById(id)) {
            throw new ResourceNotFoundException("The window with id " + id + " does not exist.");
        }
        WindowType type = windowTypeRepository
                .findById(windowModel.getTypeId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The window type with id " + windowModel.getTypeId() + " does not exist."));
        Color color = colorRepository
                .findById(windowModel.getColorId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The color with id " + windowModel.getColorId() + " does not exist."));
        Brand brand = brandRepository
                .findById(windowModel.getBrandId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The brand with id " + windowModel.getBrandId() + " does not exist."));
        GlazingType glazingType = glazingTypeRepository
                .findById(windowModel.getGlazingTypeId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The glazing type with id " + windowModel.getGlazingTypeId() + " does not exist."));
        Material material = materialRepository
                .findById(windowModel.getMaterialId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The material with id " + windowModel.getMaterialId() + " does not exist."));
        OpeningType openingType = openingTypeRepository
                .findById(windowModel.getOpeningTypeId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The opening type with id " + windowModel.getOpeningTypeId() + " does not exist."));

        Window window = new Window(id,brand,type,openingType,windowModel.getWidth(),windowModel.getHeight(),windowModel.isHasChildLock(),color,material,glazingType,windowModel.getYearsGuaranteed());
        windowRepository.save(window);
        return window;
    }

    @Override
    public void deleteWindowById(Long id) {
        windowRepository.deleteById(id);
    }
}
