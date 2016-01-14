package com.nmj.att.coordina;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nmj.att.R;
import com.nmj.att.util.Logger;

/**
 *
 * manifest에서 SecondTheme 테마( 액션바 없는 테마로 바꿈). 그래야 setSupportActionBar 이용해서 액션바를 toolbar로 바꿀수 있음.
 * 이게 액션바를 커스타마이징 하는 방법인듯..
 *
 * 주요 설명은 layout xml 파일을 보아라.
 *
 * Created by nmj on 15. 6. 21..
 */
public class Coordinator4Activity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator4);


        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Hello World");

        setSupportActionBar(toolbar);                 // 이거 하면 에러남. 이미 ActionBar가 있다고 에러남.
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setHomeAsUpIndicator(R.drawable.profile_sample1);

        // 아래부터는 RecyclerView 코드
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);        // item이 고정사이즈이라면 이걸 해라. 성능 좋아진다.

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        String[] myDataset = {"hello", "world", "good morning", "good afternoon", "good evening", "how are you",
                "hello", "world", "good morning", "good afternoon", "good evening", "how are you",
                "hello", "world", "good morning", "good afternoon", "good evening", "how are you",
                "hello", "world", "good morning", "good afternoon", "good evening", "how are you",
                "hello", "world", "good morning", "good afternoon", "good evening", "how are you",
                "hello", "world", "good morning", "good afternoon", "good evening", "how are you",
                "hello", "world", "good morning", "good afternoon", "good evening", "how are you",
                "hello", "world", "good morning", "good afternoon", "good evening", "how are you",
                "hello", "world", "good morning", "good afternoon", "good evening", "how are you"
        };
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private String[] mDataset;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView mTextView;
            public ViewHolder(TextView v) {
                super(v);
                mTextView = v;
                Logger.log("RecyclerViewTest1Activity ViewHolder create");
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(String[] myDataset) {
            mDataset = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Logger.log("RecyclerViewTest1Activity ViewHolder onCreateViewHolder");

            // create a new view
            TextView tv = (TextView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_recyclerview1, parent, false);
            // set the view's size, margins, paddings and layout parameters

            ViewHolder vh = new ViewHolder(tv);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Logger.log("RecyclerViewTest1Activity onBindViewHolder : " + position);

            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.mTextView.setText(mDataset[position]);

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.length;
        }
    }
}
