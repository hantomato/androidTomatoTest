package com.nmj.androidtomatotest.coordina;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nmj.androidtomatotest.R;
import com.nmj.androidtomatotest.util.Logger;

/**
 * CoordinatorLayout : FrameLayout 의 스페셜 버전
 *   - 최상위에서 장식을 위해 사용
 *   - child View간의 interaction을 위한 컨터이너로 사용
 *
 * 샘플
 *
 *      RecyclerView에서 layout_behavior 빼면 화면에 RecyclerView 만 나오고, 나머지 사라짐.
 *
 * 중요
 *      app:layout_behavior
 *          appbar_scrolling_view_behavior
 *
 *      app:layout_scrollFlags
 *          https://developer.android.com/reference/android/support/design/widget/AppBarLayout.LayoutParams.html#SCROLL_FLAG_SCROLL
 *              scroll              : The view will be scroll in direct relation to scroll events.
 *                                    This flag needs to be set for any of the other flags to take effect.
 *                                    If any sibling views before this one do not have this flag, then this value has no effect.
 *                     * 위쪽 view들도 함께 scroll 플래그가 세팅되있어야 한다. 안그러면 효과 없다.
 *
 *              exitUntilCollapsed  : When exiting (scrolling off screen) the view will be scrolled until it is 'collapsed'.
 *                                    The collapsed height is defined by the view's minimum height.
 *
 *              enterAlways         : When entering (scrolling on screen) the view will scroll on any downwards scroll event,
 *                                    regardless of whether the scrolling view is also scrolling.
 *                                    This is commonly referred to as the 'quick return' pattern.
 *                      * 이거 없으면, 스크롤되서 위로 올라간 view가 다시 아래로는 스크롤 되지 않음.
 *                      * 3개의 뷰가 있고, 높이가 순서대로 100dp, 40dp, 30dp 이고, 이중에 30짜리만 enterAlways 안하면..
 *                      * 위로 스크롤은 다 되지만, 스크롤 내릴때 맨위 30dp 만큼은 스크롤 안됨.
 *
 *              enterAlwaysCollapsed : An additional flag for 'enterAlways' which modifies the returning view
 *                                     to only initially scroll back to it's collapsed height.
 *                                     Once the scrolling view has reached the end of it's scroll range,
 *                                     the remainder of this view will be scrolled into view.
 *                                     The collapsed height is defined by the view's minimum height.
 **
 *
 *      app:layout_collapseMode
 *          pin
 *          parallax
 *
 *
 * ******
 * 이것의 Theme는 Theme.AppCompat.Light.DarkActionBar 임.
 * Activity를 AppCompatActivity로 바꾸면.. 상단에 액션바(타이틀바) 생김.
 *
 * Created by nmj on 15. 6. 21..
 */
//public class Coordinator1Activity extends AppCompatActivity {
public class Coordinator1Activity extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator1);


        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsingtoolbarlayout);
        collapsingToolbarLayout.setTitle("Hello World");




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
