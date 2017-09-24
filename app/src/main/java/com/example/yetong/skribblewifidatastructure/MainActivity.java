package com.example.yetong.skribblewifidatastructure;

import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Context context = this;
    private String[] list_of_all_words;
    private ArrayList<String> ran_chosen_words = new ArrayList<>();
    private String chosen_word;
    private int screen_width;
    private static DrawingView dv;
    public static String mScreenOrientation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        screen_width = displaymetrics.widthPixels;

        list_of_all_words = getApplicationContext().getResources().getStringArray(R.array.List_Of_Words);

        setWordChoice(list_of_all_words);

        //setScreenOrientation();

        initVar();
    }

    private void initVar() {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        screen_width = displaymetrics.widthPixels;

        list_of_all_words = getApplicationContext().getResources().getStringArray(R.array.List_Of_Words);

        LinearLayout textView_Frame = (LinearLayout) findViewById(R.id.textview_fragment_container);
        textView_Frame.getLayoutParams().width = (screen_width / 5);
        textView_Frame.requestLayout();

        dv= new DrawingView(this);
        RelativeLayout rootLayout = (RelativeLayout) findViewById(R.id.rootFrame);
        rootLayout.addView(dv);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        dv.init(metrics);

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if(transaction.isEmpty()) {
            transaction.add(R.id.textview_fragment_container, TextView_Fragment.newInstance(), "TextView_Fragment");
            transaction.addToBackStack(null);
            transaction.commit();
        }

        textView_Frame.bringToFront();
    }

    private void setWordChoice(String[] list_of_all_words) {
        ArrayList<String> list_of_all_words_clone = new ArrayList<>();
        for (int x = 0; x < list_of_all_words.length; x++) {
            list_of_all_words_clone.add(list_of_all_words[x]);
        }
        int i;
        Random r = new Random();
        while (ran_chosen_words.size() < 3) {
            i = r.nextInt(list_of_all_words_clone.size() - 0) + 0;
            ran_chosen_words.add(list_of_all_words_clone.get(i));
            list_of_all_words_clone.remove(i);
        }

        final Dialog dialog = new Dialog(context);                  // Creating custom Dialog to get Player's Word Choice

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.wordchoice_dialog);

        Button leftButton = (Button) dialog.findViewById(R.id.wordChoice_leftButton);
        Button middleButton = (Button) dialog.findViewById(R.id.screenChoice_middleButton);
        Button rightButton = (Button) dialog.findViewById(R.id.wordChoice_rightButton);

        leftButton.setText(ran_chosen_words.get(0));
        middleButton.setText(ran_chosen_words.get(1));
        rightButton.setText(ran_chosen_words.get(2));

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chosen_word = ran_chosen_words.get(0);
                dialog.dismiss();
            }
        });

        middleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chosen_word = ran_chosen_words.get(1);
                dialog.dismiss();
            }
        });
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chosen_word = ran_chosen_words.get(2);
                dialog.dismiss();
            }
        });


        dialog.show();
    }

//    private void setScreenOrientation() {
//        final Dialog dialog = new Dialog(context);                  // Creating custom Dialog to set Screen Orientation
//
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.screenorientation_dialog);
//
//        Button potraitButton = (Button) dialog.findViewById(R.id.screenOrientation_portraitButton);
//        Button landscapeButton = (Button) dialog.findViewById(R.id.screenOrientation_landscapeButton);
//
//        potraitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mScreenOrientation = "PORTRAIT";
//                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//                dialog.dismiss();
//            }
//        });
//
//        landscapeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mScreenOrientation = "LANDSCAPE";
//                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//    }
}
