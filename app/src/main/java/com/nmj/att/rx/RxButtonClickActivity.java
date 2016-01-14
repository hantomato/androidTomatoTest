package com.nmj.att.rx;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import com.nmj.att.R;
import com.nmj.att.util.Logger;
import com.nmj.att.util.Utils;

import rx.functions.Action1;

/**
 * 버튼 연타 클릭 막기. 하고보니 rx가 아니네..
 *
 * Created by tomatomb on 15. 8. 23..
 */
public class RxButtonClickActivity extends FragmentActivity {

    Action1 myBtnClick = (v) -> {

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_button);

        Button btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(v -> {
            v.setClickable(false);

            v.postDelayed(() -> {
                asyncClickAction(v);
            }, 500);

        });
    }

    private void asyncClickAction(View v) {
        Logger.log(getClass().toString(), "btn1 click");
        Utils.showAlert(this, "test", "ok", (dialog, which) -> {
            v.setClickable(true);
            Logger.log(getClass().toString(), "btn1 close..");
            dialog.dismiss();
        }, "", null, false);

    }
}
