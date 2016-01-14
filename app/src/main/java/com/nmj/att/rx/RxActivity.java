package com.nmj.att.rx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by tomatomb on 15. 8. 8..
 */
public class RxActivity extends FragmentActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        {
            Button btn = new Button(this);
            linearLayout.addView(btn);
            btn.setText("RxButtonClickActivity");
            btn.setOnClickListener(v -> {
                startActivity(new Intent(this, RxButtonClickActivity.class));
            });
        }
        {
            Button btn = new Button(this);
            linearLayout.addView(btn);
            btn.setText("popup dialog1");
            btn.setOnClickListener(v -> {
                startActivity(new Intent(this, RxTestActivity1.class));

            });
        }


        setContentView(linearLayout);
    }

}
