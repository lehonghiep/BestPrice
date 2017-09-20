package com.honghiep.bestprice.view.trangchu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.honghiep.bestprice.R;

/**
 * Created by honghiep on 04/09/2017.
 */

public class FragmentLamDep extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_lamdep,container,false);
        return view;
    }
}