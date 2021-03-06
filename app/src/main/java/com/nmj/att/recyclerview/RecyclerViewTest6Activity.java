package com.nmj.att.recyclerview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.nmj.att.R;
import com.nmj.att.util.Logger;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * RecyclerView - LinearLayout
 *
 * https://developer.android.com/training/material/lists-cards.html#RecyclerView
 *
 * Created by nmj on 15. 6. 20..
 */
public class RecyclerViewTest6Activity extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.log("RecyclerViewTest1Activity create");

        setContentView(R.layout.activity_recyclerview1);

        ImageView iv1 = (ImageView)findViewById(R.id.image1);
        ImageView iv2 = (ImageView)findViewById(R.id.image2);
        Picasso.with(RecyclerViewTest6Activity.this)
                .load("http://cfile66.uf.daum.net/image/2470F64B5500E65E13CB20")
                .placeholder(R.drawable.image_holder)
                .error(R.drawable.image_error)
                .into(iv1);

        Glide.with(RecyclerViewTest6Activity.this)
                .load("http://cfile66.uf.daum.net/image/2470F64B5500E65E13CB20")
                .placeholder(R.drawable.image_holder)
                .error(R.drawable.image_error)
                .into(iv2);


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);        // item이 고정사이즈이라면 이걸 해라. 성능 좋아진다.

        // use a Gride layout manager

        mLayoutManager = new GridLayoutManager(this, 2);
//        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

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
        private ArrayList<String> mDataset;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public class ViewHolder extends RecyclerView.ViewHolder {

            public ImageView mImageView;

            public ViewHolder(View v) {
                super(v);

                mImageView = (ImageView)v.findViewById(R.id.imageview);

                Logger.log("RecyclerViewTest1Activity ViewHolder create");
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(ArrayList<String> myDataset) {
            mDataset = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Logger.log("RecyclerViewTest1Activity ViewHolder onCreateViewHolder");

            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_recyclerview6, parent, false);
            // set the view's size, margins, paddings and layout parameters

            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Logger.log("RecyclerViewTest1Activity onBindViewHolder : " + position);

            String url = mDataset.get(position);
            Logger.log("RecyclerViewTest1Activity url : " + url);


//            if ( position == 0 || position == 5 ) {
                holder.mImageView.setImageResource(R.drawable.profile_sample5);
//            } else {
//                holder.mImageView.setImageResource(R.drawable.profile_sample4);
//            }

//            Logger.log("width : " + mRecyclerView.getWidth());
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)holder.mImageView.getLayoutParams();
            lp.width = mRecyclerView.getWidth()/2;
            Logger.log("width url : " + lp.width);
            holder.mImageView.setLayoutParams(lp);

            LinearLayout container = (LinearLayout)holder.itemView.findViewById(R.id.ll_container);
            if ( position == 0 || position == 1 ) {
                container.setBackgroundColor(Color.GRAY);
            } else {
                container.setBackgroundColor(Color.BLUE);
            }

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }
}
