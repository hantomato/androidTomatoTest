package com.nmj.androidtomatotest.rx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Button;
import android.widget.LinearLayout;

import com.nmj.androidtomatotest.R;

/**
 * Created by tomatomb on 15. 8. 23..
 */
public class RxTestActivity1 extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        {
            Button btn = new Button(this);
            linearLayout.addView(btn);
            btn.setText("aaa");
            btn.setOnClickListener(v -> {

            });
        }
        {
            Button btn = new Button(this);
            linearLayout.addView(btn);
            btn.setText("bbb");
            btn.setOnClickListener(v -> {


            });
        }


        setContentView(linearLayout);

    }
}
