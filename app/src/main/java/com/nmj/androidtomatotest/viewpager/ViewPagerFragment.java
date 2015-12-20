package com.nmj.androidtomatotest.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nmj.androidtomatotest.R;

/**
 * Created by nmj on 15. 6. 20..
 */
public class ViewPagerFragment extends Fragment {

    public int uid = 0;
    public ViewPagerFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);

        View rootView = inflater.inflate(R.layout.fragment_viewpager, container, false);
        TextView tv = (TextView)rootView.findViewById(R.id.textView);
        tv.setText("" + uid);

        return rootView;
    }
}
