package com.honghiep.bestprice.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.honghiep.bestprice.model.news.News;
import com.honghiep.bestprice.view.trangchu.fragment.FragmentXuTheTieuDung;
import com.honghiep.bestprice.view.trangchu.fragment.FragmentReviews;
import com.honghiep.bestprice.view.trangchu.fragment.FragmentOtoXeMayXeDap;
import com.honghiep.bestprice.view.trangchu.fragment.FragmentDienLanh;
import com.honghiep.bestprice.view.trangchu.fragment.FragmentTuVanMuaSam;
import com.honghiep.bestprice.view.trangchu.fragment.FragmentThongTinThiTruong;
import com.honghiep.bestprice.view.trangchu.fragment.FragmentSanPhamChoMe;
import com.honghiep.bestprice.view.trangchu.fragment.FragmentMeoVat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by honghiep on 04/09/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> listFragment = new ArrayList<>();
    private List<String>titleFragment=new ArrayList<>();
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        listFragment.add(new FragmentThongTinThiTruong());
        listFragment.add(new FragmentXuTheTieuDung());
        listFragment.add(new FragmentReviews());
        listFragment.add(new FragmentTuVanMuaSam());
        listFragment.add(new FragmentDienLanh());
        listFragment.add(new FragmentOtoXeMayXeDap());
        listFragment.add(new FragmentMeoVat());
        listFragment.add(new FragmentSanPhamChoMe());

        titleFragment.add("Thông tin thị trường");
        titleFragment.add("Xu thế tiêu dùng");
        titleFragment.add("REVIEWS");
        titleFragment.add("Tư vấn mua sắm");
        titleFragment.add("Điện lạnh");
        titleFragment.add("Ô Tô - Xe Máy- Xe Đạp");
        titleFragment.add("Mẹo vặt");
        titleFragment.add("Sản phẩm cho mẹ");

    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleFragment.get(position);
    }
}
