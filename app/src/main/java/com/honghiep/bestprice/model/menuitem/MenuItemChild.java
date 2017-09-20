package com.honghiep.bestprice.model.menuitem;

/**
 * Created by honghiep on 07/09/2017.
 */

public class MenuItemChild {
    private String title;
    private String link;

    public MenuItemChild(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }
}
