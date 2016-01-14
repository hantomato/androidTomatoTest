package com.nmj.att.view;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.nmj.att.R;

/**
 *
 * font color 안에 <h3> 태그는 하면.. font color가 안먹음.
 * font color
 * font size tag 안됨.
 * font color
 * Created by nmj on 15. 7. 9..
 */
public class ControlTestActivity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_control_test1);

        TextView tv1 = (TextView) findViewById(R.id.tv_text1);
        TextView tv2 = (TextView) findViewById(R.id.tv_text2);
        TextView tv3 = (TextView) findViewById(R.id.tv_text3);
        TextView tv4 = (TextView) findViewById(R.id.tv_text4);
        TextView tv5 = (TextView) findViewById(R.id.tv_text5);
        TextView tv6 = (TextView) findViewById(R.id.tv_text6);

//        String text = "<h2>Title</h2><br><p>Description here</p>";
        String text1 = "<font face=\"바탕\">안녕하세요</font>";
        String text2 = "<font color=\"#757575\"><b>1.</b>하루 세번 교환 가능합니다.<br>" +
                "<b>2.</b>보관함에서 확인가능합니다.(유효기간 교환후 30일이내).<br>" +
                "<b>3.</b>교환하신 포인트 및 피망캐쉬는 환불이 불가능합니다.<br>" +
                "<b>4.</b>교환하신 피망캐쉬는 월 충전한도 및 구매한도에 포함됩니다.<font>";
        String text3 = "<ol><li>하루 세번 교환 가능합니다.</li><li>li 태그 사용</li></ol>";

//        String text3 = "<font color=\"#757575\">1. 지정된 요일과 시간에 1번 응모가능합니다.<br>2. 응모하기는 해당 날이 지나면 종료됩니다.<br>3. 수량이 모두 소진될 경우에 조기종료됩니다.</font>";
//        String text4 = "<h3>꼭 확인하세요!</h3><br>1. 지정된 요일과 시간에 1번 응모가능합니다.<br>2. 응모하기는 해당 날이 지나면 종료됩니다.<br>3. 수량이 모두 소진될 경우에 조기종료됩니다.";
        String text4 = "<font color=\"red\">꼭 <h3>확인하세요!</h3><br>1. 지정된 요일과 시간에 1번 응모가능합니다.<br>2. 응모하기는 해당 날이 지나면 종료됩니다.<br>3. 수량이 모두 소진될 경우에 조기종료됩니다.</font>";
//        String text4 = "<font color=\"red\">hello <br><h3>world</h3></font>";
//

        String text5 = "<h1>h1 이다</h1><h2>h2 이다</h2><h3>h3 이다</h3><h4>h4 이다</h4><h5>h5 이다</h5><h6>h6 이다</h6><h7>h7 이다</h7><h8>h8 이다</h8><h2>h2 이다</h2>";
        String text6 = "<h3>확인하세요!</h3><font color=\"red\">1. 지정된 요일과 시간에 1번 응모가능합니다.</font><h3>haha</h3><font color=\"blue\"><br>2. 응모하기는 해당 날이 지나면 종료됩니다.<br>3. 수량이 모두 소진될 경우에 조기종료됩니다.</font>";

        tv1.setText(Html.fromHtml(text1));
        tv2.setText(Html.fromHtml(text2));
        tv3.setText(Html.fromHtml(text3));
        tv4.setText(Html.fromHtml(text4));
//        tv5.setText(Html.fromHtml(text5));
        tv6.setText(Html.fromHtml(text6));
    }
}
