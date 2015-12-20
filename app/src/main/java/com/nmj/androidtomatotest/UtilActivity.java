package com.nmj.androidtomatotest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nmj.androidtomatotest.coordina.Coordinator1Activity;
import com.nmj.androidtomatotest.coordina.Coordinator3Activity;
import com.nmj.androidtomatotest.coordina.Coordinator4Activity;
import com.nmj.androidtomatotest.layout.RelativeLayoutTestActivity1;
import com.nmj.androidtomatotest.layout.RelativeLayoutTestActivity2;
import com.nmj.androidtomatotest.layout.RelativeLayoutTestActivity3;
import com.nmj.androidtomatotest.layout.RelativeLayoutTestActivity4;
import com.nmj.androidtomatotest.recyclerview.RecyclerViewTest1Activity;
import com.nmj.androidtomatotest.recyclerview.RecyclerViewTest2Activity;
import com.nmj.androidtomatotest.recyclerview.RecyclerViewTest3Activity;
import com.nmj.androidtomatotest.recyclerview.RecyclerViewTest4Activity;
import com.nmj.androidtomatotest.recyclerview.RecyclerViewTest5Activity;
import com.nmj.androidtomatotest.recyclerview.RecyclerViewTest6Activity;
import com.nmj.androidtomatotest.recyclerview.RecyclerViewTest7Activity;
import com.nmj.androidtomatotest.util.Logger;
import com.nmj.androidtomatotest.util.Utils;
import com.nmj.androidtomatotest.viewpager.ViewPagerTest1Activity;
import com.nmj.androidtomatotest.viewpager.ViewPagerTest2Activity;
import com.nmj.androidtomatotest.viewpager.ViewPagerTest3Activity;

import rx.functions.Action0;

/**
 * Created by nmj on 15. 7. 4..
 */
public class UtilActivity extends Activity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recylerview);


//        startActivity(new Intent(this, RecyclerViewTest2Activity.class));


        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);        // item이 고정사이즈이라면 이걸 해라. 성능 좋아진다.

        // use a linear layout manager
        mLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);


        TestItem[] testItems = new TestItem[] {
                new TestItem("앱설치여부 체크", () -> {

                    Logger.log("com.nmj.test => " + Utils.checkAppInstalled(getApplicationContext(), "com.nmj.test"));
                    Logger.log("com.nmj.androidtomatotest => " + Utils.checkAppInstalled(getApplicationContext(), "com.nmj.androidtomatotest"));
                    Logger.log("com.neowiz.slhclient => " + Utils.checkAppInstalled(getApplicationContext(), "com.neowiz.slhclient"));
                    Logger.log("com.nmj.test => " + Utils.checkAppInstalled(getApplicationContext(), "com.nmj.test"));
                    Logger.log("com.nmj.test => " + Utils.checkAppInstalled(getApplicationContext(), "com.nmj.test"));

                    Utils.launchApp(getApplicationContext(), "com.nmj.test");
                    Utils.launchApp(getApplicationContext(), "com.android.vending");        // package nameof google play market
                }),
                new TestItem("test", () -> {
                    ;
                }),
                new TestItem("test", () -> {
                    ;
                }),
                new TestItem("test", () -> {
                    ;
                }),
                new TestItem("test", () -> {
                    ;
                }),
                new TestItem("test", () -> {
                    ;
                }),
                new TestItem("test", () -> {
                    ;
                }),

        };

        mAdapter = new MyAdapter(testItems);
        mRecyclerView.setAdapter(mAdapter);


    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        TestItem[] myData;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public Button btn1;
            public ViewHolder(View v, Button btn) {
                super(v);

                btn1 = btn;
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(TestItem[] data) {
            myData = data;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // create a new view
            View container = (View) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_main_recyclerview, parent, false);
            // set the view's size, margins, paddings and layout parameters

            Button btn = (Button)container.findViewById(R.id.btn1);
            return new ViewHolder(container, btn);
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element

            holder.btn1.setText(myData[position].name);
            holder.btn1.setOnClickListener(v -> myData[position].action.call());
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return myData.length;
        }
    }

    class TestItem {
        String name;
        Action0 action;

        public TestItem(String name, Action0 action) {
            this.name = name;
            this.action = action;
        }
    }

}
