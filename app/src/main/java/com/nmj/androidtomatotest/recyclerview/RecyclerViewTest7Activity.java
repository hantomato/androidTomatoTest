package com.nmj.androidtomatotest.recyclerview;

import android.app.Activity;
import android.content.ClipData;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.nmj.androidtomatotest.R;
import com.nmj.androidtomatotest.util.Logger;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView - LinearLayout
 *
 * https://developer.android.com/training/material/lists-cards.html#RecyclerView
 *
 * Created by nmj on 15. 6. 20..
 */
public class RecyclerViewTest7Activity extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private StaggeredGridLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.log("RecyclerViewTest1Activity create");

        setContentView(R.layout.activity_recyclerview1);

        ImageView iv1 = (ImageView)findViewById(R.id.image1);
        ImageView iv2 = (ImageView)findViewById(R.id.image2);
        Picasso.with(RecyclerViewTest7Activity.this)
                .load("http://cfile66.uf.daum.net/image/2470F64B5500E65E13CB20")
                .placeholder(R.drawable.image_holder)
                .error(R.drawable.image_error)
                .into(iv1);

        Glide.with(RecyclerViewTest7Activity.this)
                .load("http://cfile66.uf.daum.net/image/2470F64B5500E65E13CB20")
                .placeholder(R.drawable.image_holder)
                .error(R.drawable.image_error)
                .into(iv2);


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
//        mRecyclerView.setHasFixedSize(true);        // item이 고정사이즈이라면 이걸 해라. 성능 좋아진다.

        // use a Gride layout manager

//        mLayoutManager = new GridLayoutManager(this, 2);
        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        ArrayList<String> tempList = new ArrayList<String>();
        tempList.add("http://cfile169.uf.daum.net/image/2578B54B5500E270049961"); //
        tempList.add("http://cfile70.uf.daum.net/image/2533AE495500E3ED167287");   //
        tempList.add("http://cfile167.uf.daum.net/image/2154613E55385DCF083C3C");   //
        tempList.add("http://cfile167.uf.daum.net/image/214E88505500E2DA058897");   //
        tempList.add("http://cfile169.uf.daum.net/image/222421475500E320192141");   //
        tempList.add("http://cfile66.uf.daum.net/image/272641485500E3591B0739");   //
        tempList.add("http://cfile66.uf.daum.net/image/2470F64B5500E65E13CB20");   //
        tempList.add("http://cfile66.uf.daum.net/image/2749A94C5472B78905796F");   //


        mAdapter = new MyAdapter(tempList);
        mRecyclerView.setAdapter(mAdapter);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder

        public class ViewHolder extends RecyclerView.ViewHolder {
            public FrameLayout frame;
            public ImageView imageView;

            public ViewHolder(View itemView) {
                super(itemView);
                frame = (FrameLayout) itemView;
                imageView = (ImageView) frame.findViewById(R.id.sample_item);
            }
        }
        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(ArrayList<String> myDataset) {

        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recyclerview7, parent, false);
            return new ViewHolder(v);
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            holder.imageView.setImageResource(R.drawable.profile_sample5);
            holder.frame.setMinimumWidth(mRecyclerView.getWidth() / 2);


            FrameLayout container = (FrameLayout)holder.itemView.findViewById(R.id.ll_container);
            if ( position == 0 || position == 1 ) {
                container.setBackgroundColor(Color.GRAY);
            } else {
                container.setBackgroundColor(Color.BLUE);
            }

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return 10;
        }
    }
}
