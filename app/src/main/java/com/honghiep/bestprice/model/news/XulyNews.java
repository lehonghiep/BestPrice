package com.honghiep.bestprice.model.news;

import com.honghiep.bestprice.connectinternet.DownloadJSON;
import com.honghiep.bestprice.model.news.News;
import com.honghiep.bestprice.model.trangchu.xulyviewpager.XulyViewPagerTab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by honghiep on 13/09/2017.
 */

public class XulyNews {
    private List<News>newsListThongTinThiTruong=new ArrayList<>();
    private List<News>newsListXuTheTieuDung=new ArrayList<>();
    private List<News>newsListReviews=new ArrayList<>();
    private List<News>newsListTuVanMuaSam=new ArrayList<>();
    private List<News> newsListDienLanh=new ArrayList<>();
    private List<News>newsListOtoXemayXedap=new ArrayList<>();
    private List<News>newsListMeoVat=new ArrayList<>();
    private List<News>newsListSanPhamChoMe=new ArrayList<>();


    public void downloadNews(){
        String contentThongTinThiTruong= DownloadJSON.getJson("/user/getNewsThongTinThiTruong");
        String contentXuTheTieuDung= DownloadJSON.getJson("/user/getNewsXuTheTieuDung");
        String contentReviews= DownloadJSON.getJson("/user/getNewsReviews");
        String contentTuVanMuaSam= DownloadJSON.getJson("/user/getNewsTuVanMuaSam");
        String contentDienLanh= DownloadJSON.getJson("/user/getNewsDienLanh");
        String contentOtoXeMayXeDap= DownloadJSON.getJson("/user/getNewsOtoXeMayXeDap");
        String contentMeoVat= DownloadJSON.getJson("/user/getNewsMeoVat");
        String contentSanPhamChoMe= DownloadJSON.getJson("/user/getNewsSanPhamChoMe");

        XulyViewPagerTab xulyViewPagerTab=new XulyViewPagerTab();
        if(contentThongTinThiTruong!=null){
            newsListThongTinThiTruong.addAll(xulyViewPagerTab.parserJSONNews(contentThongTinThiTruong));
        }
        if(contentXuTheTieuDung!=null){
            newsListXuTheTieuDung.addAll(xulyViewPagerTab.parserJSONNews(contentXuTheTieuDung));
        }
        if(contentReviews!=null){
            newsListReviews.addAll(xulyViewPagerTab.parserJSONNews(contentReviews));
        }
        if(contentTuVanMuaSam!=null){
            newsListTuVanMuaSam.addAll(xulyViewPagerTab.parserJSONNews(contentTuVanMuaSam));
        }
        if(contentDienLanh!=null){
            newsListDienLanh.addAll(xulyViewPagerTab.parserJSONNews(contentDienLanh));
        }
        if(contentOtoXeMayXeDap!=null){
            newsListOtoXemayXedap.addAll(xulyViewPagerTab.parserJSONNews(contentOtoXeMayXeDap));
        }
        if(contentMeoVat!=null){
            newsListMeoVat.addAll(xulyViewPagerTab.parserJSONNews(contentMeoVat));
        }
        if(contentSanPhamChoMe!=null){
            newsListSanPhamChoMe.addAll(xulyViewPagerTab.parserJSONNews(contentSanPhamChoMe));
        }
    }

    public List<News> getNewsListThongTinThiTruong() {
        return newsListThongTinThiTruong;
    }

    public List<News> getNewsListXuTheTieuDung() {
        return newsListXuTheTieuDung;
    }

    public List<News> getNewsListReviews() {
        return newsListReviews;
    }

    public List<News> getNewsListTuVanMuaSam() {
        return newsListTuVanMuaSam;
    }

    public List<News> getNewsListDienLanh() {
        return newsListDienLanh;
    }

    public List<News> getNewsListOtoXemayXedap() {
        return newsListOtoXemayXedap;
    }

    public List<News> getNewsListMeoVat() {
        return newsListMeoVat;
    }

    public List<News> getNewsListSanPhamChoMe() {
        return newsListSanPhamChoMe;
    }

}
