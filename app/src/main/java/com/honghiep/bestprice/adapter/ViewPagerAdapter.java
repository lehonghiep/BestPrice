package com.honghiep.lazada.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.honghiep.lazada.view.trangchu.fragment.FragmentChuongTrinhKhuyenMai;
import com.honghiep.lazada.view.trangchu.fragment.FragmentDienTu;
import com.honghiep.lazada.view.trangchu.fragment.FragmentLamDep;
import com.honghiep.lazada.view.trangchu.fragment.FragmentMeVaBe;
import com.honghiep.lazada.view.trangchu.fragment.FragmentNhaCuaVaDoiSong;
import com.honghiep.lazada.view.trangchu.fragment.FragmentNoiBat;
import com.honghiep.lazada.view.trangchu.fragment.FragmentTheThaoVaDuLich;
import com.honghiep.lazada.view.trangchu.fragment.FragmentThoiTrang;
import com.honghiep.lazada.view.trangchu.fragment.FragmentThuongHieu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by honghiep on 04/09/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> listFragment = new ArrayList<>();
List<String>titleFragment=new ArrayList<>();
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        listFragment.add(new FragmentNoiBat());
        listFragment.add(new FragmentChuongTrinhKhuyenMai());
        listFragment.add(new FragmentDienTu());
        listFragment.add(new FragmentNhaCuaVaDoiSong());
        listFragment.add(new FragmentMeVaBe());
        listFragment.add(new FragmentLamDep());
        listFragment.add(new FragmentThoiTrang());
        listFragment.add(new FragmentTheThaoVaDuLich());
        listFragment.add(new FragmentThuongHieu());
        titleFragment.add("Nổi bật");
        titleFragment.add("Chương trình khuyến mại");
        titleFragment.add("Điện tử");
        titleFragment.add("Nhà cửa và đời sống");
        titleFragment.add("Mẹ và bé");
        titleFragment.add("Làm đẹp");
        titleFragment.add("Thời trang");
        titleFragment.add("Thể thao và du lịch");
        titleFragment.add("Thương hiệu");
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
