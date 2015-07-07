package com.nmj.androidtomatotest.dialog;

import android.app.Activity;
//import android.app.Fragment;
//import android.app.FragmentTransaction;
//import android.app.Fragment;
//import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

import com.nmj.androidtomatotest.R;

/**
 * Created by nmj on 15. 7. 7..
 */
public class DialogCallerActivity1 extends FragmentActivity {

    int mStackLevel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        {
            Button btn = new Button(this);
            linearLayout.addView(btn);
            btn.setText("alertDialog");
            btn.setOnClickListener(v -> {
                showDialog1();
            });
        }
        {
            Button btn = new Button(this);
            linearLayout.addView(btn);
            btn.setText("popup dialog1");
            btn.setOnClickListener(v -> {
                showDialog2();
            });
        }
        {
            Button btn = new Button(this);
            linearLayout.addView(btn);
            btn.setText("popup dialog2");
            btn.setOnClickListener(v -> {
                showDialog3();
            });
        }

        setContentView(linearLayout);
    }


    void showDialog1() {
        DialogFragment newFragment = MyAlertDialogFragment.newInstance(R.string.hello_world);
        newFragment.show(getSupportFragmentManager(), "dialog");
    }

    void showDialog2() {

        mStackLevel++;

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        DialogFragment newFragment = MyDialogFragment.newInstance(mStackLevel);

        newFragment.show(ft, "dialog");
    }

    void showDialog3() {
        DialogFragment newFragment = MyDialogFragment2.newInstance(R.string.hello_world);
        newFragment.show(getSupportFragmentManager(), "dialog");
    }


}
