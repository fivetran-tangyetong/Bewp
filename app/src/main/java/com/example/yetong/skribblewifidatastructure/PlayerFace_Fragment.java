package com.example.yetong.skribblewifidatastructure;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Yetong on 2017/9/24.
 */

public class PlayerFace_Fragment extends Fragment{
    public static PlayerFace_Fragment newInstance() {
        return new PlayerFace_Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.textview_fragment, container, false);

    }
}
