package com.example.yetong.skribblewifidatastructure;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Yetong on 2017/9/24.
 */

public class Drawing_Option_Fragment extends Fragment{
    public static Drawing_Option_Fragment newInstance() {
        return new Drawing_Option_Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.draw_option_fragment, container, false);

    }
}
