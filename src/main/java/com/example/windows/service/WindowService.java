package com.example.windows.service;

import com.example.windows.entity.Window;
import com.example.windows.model.WindowModel;

public interface WindowService {
    Window getWindowById(Long id);

    //Page<Book> getBooks(PageDto pageDto);

    Window addWindow(WindowModel windowModel);

    Window updateWindow(Long id, WindowModel bookModel);

    void deleteWindowById(Long id);
}
