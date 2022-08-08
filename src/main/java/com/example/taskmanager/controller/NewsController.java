package com.example.taskmanager.controller;

import com.example.taskmanager.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping
    @ResponseBody
    public List<String> getNews() {
        return newsService.getNews();
    }
}
