package com.nmj.att.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nmj.att.R;
import com.nmj.att.util.Logger;

import java.util.ArrayList;

/** 더보기 버튼 있는 형식의 RecyclerView를 구현해보자.
 * http://developer.android.com/intl/ko/training/material/lists-cards.html
 *
 * 3개의 LayoutManager 중에 기본형식인 LinearLayoutManager을 사용하자.
 *
 * ViewHolder 를 상속받은 2개의 서버 ViewHolder를 만들었다.
 *
 *
 *
 * Created by tomatomb on 2015. 12. 28..
 */
public class DynamicRecyclerActivity1 extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.log("DynamicRecyclerActivity1 create");

        setContentView(R.layout.activity_recyclerview1);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(false);        // item이 고정사이즈이라면 true 해라 이해라. 성능 좋아진다.
        // 하지만 난 가변이다.

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        ArrayList<String> dataSet = new ArrayList<>();
        dataSet.add("aaa1");
        dataSet.add("aaa2");
        dataSet.add("aaa3");
        dataSet.add("aaa4");
        dataSet.add("aaa5");

        mAdapter = new MyAdapter(dataSet);
        mRecyclerView.setAdapter(mAdapter);

    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.BaseViewHolder> {
        private ArrayList<String> mDataset;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder

        public class BaseViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public BaseViewHolder(View v) {
                super(v);
                Logger.log("DynamicRecyclerActivity1 BaseViewHolder create");
            }
        }

        public class NormalViewHolder extends BaseViewHolder {
            // each data item is just a string in this case
            public ImageView iv;
            public TextView title;
            public TextView subTitle;

            public NormalViewHolder(View v) {
                super(v);

                iv = (ImageView)v.findViewById(R.id.imageview);
                title = (TextView)v.findViewById(R.id.text1);
                subTitle = (TextView)v.findViewById(R.id.text2);

                Logger.log("DynamicRecyclerActivity1 ViewHolder create");
            }
        }

        public class ExpandViewHolder extends BaseViewHolder {
            public Button btnExpand;
            public ExpandViewHolder(View v) {
                super(v);
                btnExpand = (Button)v.findViewById(R.id.btn_expand);
                Logger.log("DynamicRecyclerActivity1 ExpandViewHolder create");

                btnExpand.setOnClickListener(vv -> {
                    Logger.log("expand click!!");

                    for (int i=0; i<5; ++i) {
                        mDataset.add("aaa" + mDataset.size());
                    }

                    mRecyclerView.getAdapter().notifyDataSetChanged();
                });
            }
        }


        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(ArrayList<String> myDataset) {
            mDataset = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Logger.log("DynamicRecyclerActivity1 onCreateViewHolder : viewType : " + viewType);

            // create a new view
            if (viewType == 5) {
                View view = (View) LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.row_dyna_recyclerview2, parent, false);
                ExpandViewHolder vh = new ExpandViewHolder(view);
                return vh;
            } else {
                View view = (View) LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.row_dyna_recyclerview1, parent, false);
                NormalViewHolder vh = new NormalViewHolder(view);
                return vh;
            }
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(BaseViewHolder holder, int position) {
            Logger.log("DynamicRecyclerActivity1 onBindViewHolder : " + position);

            // - replace the contents of the view with that element
            if (holder instanceof NormalViewHolder) {
                NormalViewHolder ho = (NormalViewHolder)holder;
                ho.iv.setImageResource(R.drawable.profile_sample1);
                ho.title.setText("Title : " + position);
                ho.subTitle.setText(mDataset.get(position));

            } else if (holder instanceof ExpandViewHolder) {
                ExpandViewHolder ho = (ExpandViewHolder)holder;
                ho.btnExpand.setText("[더보기]");

                // 더보기 버튼 누르면
                // 1. 더보기 항목을 동글뱅이로 변경
                // 2. 데이타 쿼리 시작
                // 3. 데이타 쿼리 완료되면, 더보기 항목 제거후
                // 4.1. 쿼리된게 없으면 그냥 끝냄.
                // 4.2. 쿼리한 데이타를 뒤에 붙이기.
                // 5. 더보기 버튼 맨뒤에 붙이기.
                //
            }

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.size();
        }

        @Override
        public int getItemViewType(int position) {
//            if ((position+1) % 5 == 0 && position != 0)
//                return 5;   // 5번째마다 더보기 버튼 나오도록
//            else
//                return 0;

            if (position==(getItemCount()-1)) {
                return 5;
            } else {
                return 0;
            }
        }
    }
}
