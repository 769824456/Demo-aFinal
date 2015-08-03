package com.syl.demo.FinalActivity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.syl.demo.R;

import net.tsz.afinal.FinalActivity;
/*
 * PACKAGE_NAME :com.syl.demo.FinalActivity
 * VERSION :[V 1.0.0]
 * AUTHOR :  yulongsun
 * CREATE AT : 7/27/2015 5:17 PM
 * COPYRIGHT : InSigma HengTian Software Ltd.
 * NOTE :在Fragment中使用AFinal框架
 */
public class FinalFragment extends Fragment {

    private View rootView;

    public FinalFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_final, null);
        //在Fragment中使用
        FinalActivity.initInjectedView(this,rootView);
        return rootView;
    }


}
