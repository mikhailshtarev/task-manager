package com.example.taskmanager.parser;

import com.example.taskmanager.entity.ParserEnum;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class YandexParser {
    private final String URL = "https://yandex.ru/news";
    private final String SELECT = "h2.mg-card__title";

    public Document getDocument() {
        final Document documetn;
        try {
            documetn = Jsoup.connect(URL)
                    .userAgent(ParserEnum.CLIENT.getValue())
                    .referrer(ParserEnum.REFERER.getValue())
                    .get();
        } catch (IOException e) {
//           Создать либу с исключениями
            throw new RuntimeException(e);
        }
        return documetn;
    }

    public List<String> getTitles(Document document) {
        Elements listNews = document.select(SELECT);
        List<String> listTitles = listNews.eachText();
        return listTitles;
    }


}
