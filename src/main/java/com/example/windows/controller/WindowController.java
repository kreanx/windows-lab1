package com.example.windows.controller;

import com.example.windows.entity.Window;
import com.example.windows.model.WindowModel;
import com.example.windows.service.WindowService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.windows.dto.PageDto;
import org.springframework.data.domain.Page;

@AllArgsConstructor
@Controller
@RequestMapping("/windows")
public class WindowController {
    private final WindowService windowService;

    @GetMapping("/{id}")
    public ResponseEntity<Window> getWindowById(@PathVariable Long id) {
        return new ResponseEntity<>(windowService.getWindowById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Window>> getWindows(PageDto pageDto) {
        return new ResponseEntity<>(windowService.getWindows(pageDto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Window> addWindow(@RequestBody WindowModel windowModel) {
        return new ResponseEntity<>(windowService.addWindow(windowModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Window> updateWindow(@PathVariable Long id, @RequestBody WindowModel windowModel) {
        return new ResponseEntity<>(windowService.updateWindow(id, windowModel), HttpStatus.OK);
    }

    /*@DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteWindowById(@PathVariable Long id) {
        windowService.deleteWindowById(id);
    }*/
}
