package com.nmj.androidtomatotest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nmj.androidtomatotest.util.Logger;

/**
 * Created by nmj on 15. 6. 20..
 */
public class ViewPagerTest1Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_viewpager_1);

        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        pager.setAdapter(adapter);
    }

    public class ViewPagerAdapter extends PagerAdapter {

        // 4번째로 이동하려고 하면 죽네. 왜죽는지 모르겠음.

        private String[] names = {"John", "Mike", "Sean", "John", "Mike", "Sean"};
        private int[] resIds = {R.drawable.profile_sample1, R.drawable.profile_sample2, R.drawable.profile_sample3, R.drawable.profile_sample4, R.drawable.profile_sample5, R.drawable.profile_sample6};
        private String[] callNumbers = {"010-7777-1234", "010-7788-1234", "010-7799-1234", "010-7777-1234", "010-7788-1234", "010-7799-1234"};

        private Context mContext;

        public ViewPagerAdapter(Context context) {
            Logger.log("ViewPagerAdapter create");
            mContext = context;
        }

        public int getCount() {
//            Logger.log("ViewPagerAdapter getCount");
            return names.length;
        }

        public Object instantiateItem(View pager, int position) {
            Logger.log("ViewPagerAdapter instantiateItem : " + position);
            PersonPage page = new PersonPage(mContext);
            page.uid = position * 100;

            page.setNameText(names[position]);
            page.setImage(resIds[position]);
            page.setCallNumber(callNumbers[position]);

            ViewPager curPager = (ViewPager) pager;
            curPager.addView(page, position);
            return page;
        }

        public void destroyItem(View pager, int position, Object view) {
            Logger.log("ViewPagerAdapter destroyItem : " + position);

            ((ViewPager) pager).removeView((PersonPage) view);
        }

        public boolean isViewFromObject(View view, Object object) {
            Logger.log("ViewPagerAdapter isViewFromObject");
            PersonPage left = (PersonPage)view;
            PersonPage right = (PersonPage)object;
            Logger.log("left : " + left.uid  + ", right : " + right.uid + " res : " + view.equals(object));

            return view.equals(object);
        }

        public void finishUpdate(View view) {
//            Logger.log("ViewPagerAdapter finishUpdate");

        }

        public void restoreState(Parcelable p, ClassLoader c) {
//            Logger.log("ViewPagerAdapter restoreState");

        }

        public Parcelable saveState() {
//            Logger.log("ViewPagerAdapter saveState");
            return null;
        }

        public void startUpdate(View view) {
//            Logger.log("ViewPagerAdapter startUpdate");
        }
    }

    public class PersonPage extends LinearLayout {
        public int uid = -1;
        Context mContext;
        TextView nameText;
        Button callButton;
        ImageView iconImage;
        public static final int CALL_NUMBER = 1001;
        public PersonPage(Context context) {
            super(context);
            init(context);
        }
        public PersonPage(Context context, AttributeSet attrs) {
            super(context, attrs);
            init(context);
        }
        private void init(Context context) {
            mContext = context;
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            inflater.inflate(R.layout.viewpager_1_person_page, this, true);
            iconImage = (ImageView) findViewById(R.id.iconImage);
            nameText = (TextView) findViewById(R.id.nameText);
            callButton = (Button) findViewById(R.id.callButton);

            callButton.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    String callNumber = (String) callButton.getTag();
                    Toast.makeText(mContext, "전화번호 : " + callNumber, Toast.LENGTH_LONG).show();
                }
            });
        }
        public void setImage(int resId) {
            iconImage.setImageResource(resId);
        }
        public void setCallNumber(String number) {
            callButton.setTag(number);
        }
        public String getNameText() {
            return nameText.getText().toString();
        }
        public void setNameText(String nameStr) {
            nameText.setText(nameStr);
        }
    }
}
