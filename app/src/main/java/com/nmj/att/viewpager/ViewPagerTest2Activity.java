package com.nmj.att.viewpager;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.nmj.att.R;
import com.nmj.att.util.Logger;

/**
 * ViewPager test.
 * ViewPager에다가 Fragment를 붙임. 이를 위해 PagerAdapter의 서브클래스인 FragmentPagerAdapter 를 사용함.
 * FragmentPagerAdapter는 PagerAdapter 보다는 사용이 간편한거 같음.
 *
 * Created by nmj on 15. 6. 20..
 */
public class ViewPagerTest2Activity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_viewpager_2);

        ViewPager pager = (ViewPager)findViewById(R.id.pager);

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("tab 3"));

        tabLayout.setupWithViewPager(pager);

        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setBackgroundColor(Color.BLUE);
//        tabLayout.setBackground(getResources().getDrawable(R.drawable.profile_sample1));

//        tabLayout.setBackgroundResource(R.drawable.profile_sample1);
    }

    public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        final int PAGE_COUNT = 5;
        private Context mContext;

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
            Logger.log("MyFragmentPagerAdapter create");
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public Fragment getItem(int position) {
            Logger.log("MyFragmentPagerAdapter getItem : " + position);
            ViewPagerFragment fragment = new ViewPagerFragment();
            fragment.uid = position * 100;

            return fragment;

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "PAGE" + position;
        }
    }

}
