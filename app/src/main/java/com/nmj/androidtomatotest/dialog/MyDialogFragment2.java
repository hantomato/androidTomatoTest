package com.nmj.androidtomatotest.dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.nmj.androidtomatotest.R;

/**
 * Created by nmj on 15. 7. 7..
 */
public class MyDialogFragment2 extends DialogFragment {
    int mNum;

    static MyDialogFragment2 newInstance(int num) {
        MyDialogFragment2 f = new MyDialogFragment2();

        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments().getInt("num");


        int style = 0;
        int theme = 0;
        style = DialogFragment.STYLE_NO_TITLE;       // 투명
//        style = DialogFragment.STYLE_NO_FRAME;       // 투명
//        style = DialogFragment.STYLE_NO_INPUT;
//        style = DialogFragment.STYLE_NORMAL;
//        style = DialogFragment.STYLE_NORMAL;
//        style = DialogFragment.STYLE_NO_TITLE;       // 투명
//        style = DialogFragment.STYLE_NO_FRAME;       // 투명
//        style = DialogFragment.STYLE_NORMAL;         // 투명

//        theme = android.R.style.Theme_Holo;
//        theme = android.R.style.Theme_Holo_Light_Dialog;
//        theme = android.R.style.Theme_Holo_Light;
//        theme = android.R.style.Theme_Holo_Light_Panel;
//        theme = android.R.style.Theme_Holo_Light;

        setStyle(style, theme);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_test2, container, false);
        View tv = v.findViewById(R.id.text);

        return v;
    }


}