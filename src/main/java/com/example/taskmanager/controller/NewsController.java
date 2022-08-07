package com.example.taskmanager.controller;

import com.example.taskmanager.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<String> getNews() {
        return newsService.getNews();
    }
}
