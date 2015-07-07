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
public class MyDialogFragment extends DialogFragment {
    int mNum;

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

        int style = DialogFragment.STYLE_NORMAL, theme = 0;
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
        setStyle(style, theme);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_test1, container, false);
        View tv = v.findViewById(R.id.text);
        ((TextView)tv).setText("Dialog #" + mNum + ": using style " + mNum);

        Button button = (Button)v.findViewById(R.id.show);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                ((DialogCallerActivity1)getActivity()).showDialog();
//            }
//        });

        return v;
    }


}