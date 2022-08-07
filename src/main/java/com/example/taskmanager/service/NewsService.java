package com.example.taskmanager.service;

import com.example.taskmanager.parser.YandexParser;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {


    public List<String> getNews(){
        YandexParser yandexParser = new YandexParser();
        Document document = yandexParser.getDocument();
        return yandexParser.getTitles(document);
    }
}
