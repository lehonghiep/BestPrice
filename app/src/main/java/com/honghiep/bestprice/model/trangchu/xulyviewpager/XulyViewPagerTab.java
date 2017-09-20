package com.honghiep.bestprice.model.trangchu.xulyviewpager;

import com.google.gson.Gson;
import com.honghiep.bestprice.model.news.News;
import com.honghiep.bestprice.model.news.ResultNews;


import java.util.List;

/**
 * Created by honghiep on 13/09/2017.
 */

public class XulyViewPagerTab {
    public List<News> parserJSONNews(String dulieujson){
        Gson gson=new Gson();
        ResultNews result=gson.fromJson(dulieujson,ResultNews.class);
        return result.getNewsList();
    }
}
