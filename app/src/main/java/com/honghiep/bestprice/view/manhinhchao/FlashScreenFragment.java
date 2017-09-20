package com.honghiep.bestprice.view.manhinhchao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.honghiep.bestprice.R;

/**
 * Created by honghiep on 06/09/2017.
 */

public class FlashScreenFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_flashscreen,container,false);
        return view;
    }
}
