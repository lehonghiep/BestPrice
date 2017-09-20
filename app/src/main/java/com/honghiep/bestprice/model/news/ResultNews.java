package com.honghiep.bestprice.model.news;

import java.util.List;

/**
 * Created by honghiep on 11/09/2017.
 */
public class ResultNews {
    private List<News>newsList;

    public ResultNews(List<News> newsList) {
        this.newsList = newsList;
    }

    public List<News> getNewsList() {
        return newsList;
    }
}
