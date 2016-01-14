package com.nmj.att.dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.nmj.att.R;

/**
 * STYLE_NORMAL     : 타이틀 영역을 갖고있음. 흰색 배경. dim.
 * STYLE_NO_TITLE   : 타이틀 영역 제거. 흰색 배경. dim
 * STYLE_NO_FRAME   : 타이틀 영역 제거. 완전 투명 배경. not dim.
 *
 * Created by nmj on 15. 7. 7..
 */
public class MyDialogFragment extends DialogFragment {
    int mNum;
    int style;
    int theme;

    static MyDialogFragment newInstance(int num) {
        MyDialogFragment f = new MyDialogFragment();

        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments().getInt("num");

        style = DialogFragment.STYLE_NORMAL;
        theme = 0;
        switch ((mNum-1)%6) {
            case 1: style = DialogFragment.STYLE_NO_TITLE; break;       // 투명
            case 2: style = DialogFragment.STYLE_NO_FRAME; break;       // 투명
            case 3: style = DialogFragment.STYLE_NO_INPUT; break;
            case 4: style = DialogFragment.STYLE_NORMAL; break;
            case 5: style = DialogFragment.STYLE_NORMAL; break;
            case 6: style = DialogFragment.STYLE_NO_TITLE; break;       // 투명
            case 7: style = DialogFragment.STYLE_NO_FRAME; break;       // 투명
            case 8: style = DialogFragment.STYLE_NORMAL; break;         // 투명
        }
        switch ((mNum-1)%6) {
            case 4: theme = android.R.style.Theme_Holo; break;
            case 5: theme = android.R.style.Theme_Holo_Light_Dialog; break;
            case 6: theme = android.R.style.Theme_Holo_Light; break;
            case 7: theme = android.R.style.Theme_Holo_Light_Panel; break;
            case 8: theme = android.R.style.Theme_Holo_Light; break;
        }
        setStyle(style, 0);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_test1, container, false);
        View tv = v.findViewById(R.id.text);
        ((TextView)tv).setText("style:" + convertTitleString(style) + ", using theme " + theme);

        Button button = (Button)v.findViewById(R.id.show);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                ((DialogCallerActivity1)getActivity()).showDialog();
//            }
//        });

        return v;
    }

    private String convertTitleString(int style) {
        switch (style) {
            case DialogFragment.STYLE_NORMAL:       return "STYLE_NORMAL";
            case DialogFragment.STYLE_NO_TITLE:     return "STYLE_NO_TITLE";
            case DialogFragment.STYLE_NO_FRAME:     return "STYLE_NO_FRAME";
            case DialogFragment.STYLE_NO_INPUT:     return "STYLE_NO_INPUT";
            default:                                return "";
        }
    }


}