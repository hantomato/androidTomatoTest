package com.nmj.att.recyclerview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.stream.BaseGlideUrlLoader;
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
//        mLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        ArrayList<String> tempList = new ArrayList<String>();
//        tempList.add("http://cfile169.uf.daum.net/image/2578B54B5500E270049961"); //
//        tempList.add("http://cfile70.uf.daum.net/image/2533AE495500E3ED167287");   //
//        tempList.add("http://cfile167.uf.daum.net/image/2154613E55385DCF083C3C");   //
//        tempList.add("http://cfile167.uf.daum.net/image/214E88505500E2DA058897");   //
//        tempList.add("http://cfile169.uf.daum.net/image/222421475500E320192141");   //
        tempList.add("http://pmgapp.devmdl.pmang.com/slh/img/test/test_rectangle.png");   //
        tempList.add("http://pmgapp.devmdl.pmang.com/slh/img/test/test_rectangle.png");   //

        tempList.add("http://pmgapp.devmdl.pmang.com/slh/img/test/test_roundrect.png");   //
        tempList.add("http://cfile66.uf.daum.net/image/2470F64B5500E65E13CB20");   //
        tempList.add("http://cfile66.uf.daum.net/image/2749A94C5472B78905796F");   //


        mAdapter = new MyAdapter(tempList);
        mRecyclerView.setAdapter(mAdapter);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        ArrayList<String> tempList;
        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder

        public class ViewHolder extends RecyclerView.ViewHolder {
            public FrameLayout frame;
            public ImageView imageView;

            public ViewHolder(View itemView) {
                super(itemView);
//                frame = (FrameLayout) itemView;
                imageView = (ImageView) itemView.findViewById(R.id.slh_sample_item);
            }
        }
        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(ArrayList<String> myDataset) {
            tempList = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recyclerview7, parent, false);
            FrameLayout laLayout = (FrameLayout)v.findViewById(R.id.ll_container);
//            laLayout.setMinimumWidth(mRecyclerView.getWidth()/2);
//            int width = laLayout.getWidth();
//            int height = laLayout.getHeight();
//            Logger.log("nmjj : width " + width);
//            Logger.log("nmjj : height " + height);
//
//            laLayout.setMinimumWidth(400);
//            Logger.log("nmjj after : width " + width);

            Logger.log("nmjj mRecyclerView.getWidth() : width " + mRecyclerView.getWidth());


            return new ViewHolder(v);
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            switch (position) {
                case 0:
                    holder.imageView.setImageResource(R.drawable.profile_sample5);
                    break;
//                case 1:
//                    holder.imageView.setImageResource(R.drawable.image_error);
//                    break;
//
//                case 2:
//                    holder.imageView.setImageResource(R.drawable.profile_sample4);
//                    break;
//                case 3:
//                    holder.imageView.setImageResource(R.drawable.profile_sample2);
//                    break;

                default:

                    String yourUrl = tempList.get(position);
                    ImageView yourView = holder.imageView;


                Glide.with(RecyclerViewTest7Activity.this)
//                        .using(new MyUrlLoader(RecyclerViewTest7Activity.this))
//                        .load
                        .load(yourUrl)
//                        .override(mRecyclerView.getWidth()/2, 1000)
                        .placeholder(R.drawable.test_roundrect)
                        .error(R.drawable.test_roundrect)
//                        .override(100, 500)
                        .fitCenter()
                        .into(yourView);


//                    Glide.with(RecyclerViewTest7Activity.this)
//                            .load(yourUrl)
////                            .asBitmap()
//                            .fitCenter()
//                            .into(yourView);

                break;
            }
//            holder.frame.setMinimumWidth(mRecyclerView.getWidth() / 2);
//            FrameLayout laLayout = (FrameLayout)holder.itemView.findViewById(R.id.ll_container);
//            int width = laLayout.getWidth();
//            int height = laLayout.getHeight();
//            Logger.log("nmjj : width " + width);
//            Logger.log("nmjj : height " + height);
//
////            laLayout.setMinimumWidth(1000);
//            Logger.log("nmjj after : width " + width);


            View container = (View)holder.itemView.findViewById(R.id.ll_container);
            if ( position == 0 || position == 1 ) {
                container.setBackgroundColor(Color.GRAY);
            } else {
                container.setBackgroundColor(Color.BLUE);
            }

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return tempList.size();
        }
    }

    public interface MyDataModel {
        public String buildUrl(int width, int height);
    }

    public class MyUrlLoader extends BaseGlideUrlLoader<MyDataModel> {
        @Override
        protected String getUrl(MyDataModel model, int width, int height) {
            // Construct the url for the correct size here.
            return model.buildUrl(width, height);
        }

        public MyUrlLoader(Context context) {
            super(context);
        }
    }
}
