package com.nmj.androidtomatotest.dialog;

//import android.app.Fragment;
//import android.app.FragmentTransaction;
//import android.app.Fragment;
//import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.nmj.androidtomatotest.R;
import com.nmj.androidtomatotest.util.Logger;

/**
 * 
 * Created by nmj on 15. 7. 7..
 */
public class DialogCallerActivity1 extends FragmentActivity implements CustomDialogFragment.ButtonClickListener {

    @Override
    public void OnClick(DialogFragment fragment, int btnId) {
        Logger.log("DialogCallerActivity1 onClick : " + btnId);
        if (btnId == R.id.btn_cancel) {
            Logger.log("DialogCallerActivity1 cancel");
        } else if (btnId == R.id.btn_ok) {
            Logger.log("DialogCallerActivity1 ok");
        }
            fragment.dismiss();
    }

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
            btn.setText("popup customDiag1");
            btn.setOnClickListener(v -> {
                showCustomDialog("", "오늘 하루 2배 이벤트 합니다!", "지금 바로 접속하세요.");
            });
        }
        {
            Button btn = new Button(this);
            linearLayout.addView(btn);
            btn.setText("popup customDiag2");
            btn.setOnClickListener(v -> {
                showCustomDialog("긴급점검", "12시부터 긴급 점검을 시작합니다.", "");
            });
        }

        {
            Button btn = new Button(this);
            linearLayout.addView(btn);
            btn.setText("popup customDiag3");
            btn.setOnClickListener(v -> {
                showCustomDialog("", "안녕하세요", "");
            });
        }

        {
            Button btn = new Button(this);
            linearLayout.addView(btn);
            btn.setText("popup customDiag4");
            btn.setOnClickListener(v -> {
                showCustomDialog2("", "안녕하세요", "", true, true);
            });
        }

        {
            Button btn = new Button(this);
            linearLayout.addView(btn);
            btn.setText("popup customDiag5");
            btn.setOnClickListener(v -> {
                showCustomDialog2("", "안녕하세요", "", false, false);
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

    void showCustomDialog(String header, String content, String subContent) {
        DialogFragment newFragment = CustomDialogFragment.newInstance(header, content, subContent);
        newFragment.show(getSupportFragmentManager(), "");
    }
    void showCustomDialog2(String header, String content, String subContent, boolean showCancelBtn, boolean cancelable) {
        DialogFragment newFragment = CustomDialogFragment.newInstance(header, content, subContent, showCancelBtn, cancelable);
        newFragment.show(getSupportFragmentManager(), "");
    }


}
