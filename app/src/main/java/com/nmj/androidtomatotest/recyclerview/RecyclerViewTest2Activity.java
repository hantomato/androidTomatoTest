package com.nmj.androidtomatotest.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nmj.androidtomatotest.R;
import com.nmj.androidtomatotest.util.Logger;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * RecyclerView - LinearLayout
 *
 * https://developer.android.com/training/material/lists-cards.html#RecyclerView
 *
 * Created by nmj on 15. 6. 20..
 */
public class RecyclerViewTest2Activity extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.log("RecyclerViewTest1Activity create");

        setContentView(R.layout.activity_recyclerview1);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);        // item이 고정사이즈이라면 이걸 해라. 성능 좋아진다.

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
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

        tempList.add("http://cfile169.uf.daum.net/image/2578B54B5500E270049961"); // 초아
        tempList.add("http://cfile70.uf.daum.net/image/2533AE495500E3ED167287");   // 설현
        tempList.add("http://cfile167.uf.daum.net/image/2154613E55385DCF083C3C");   //
        tempList.add("http://cfile167.uf.daum.net/image/214E88505500E2DA058897");   //
        tempList.add("http://cfile169.uf.daum.net/image/222421475500E320192141");   //
        tempList.add("http://cfile66.uf.daum.net/image/272641485500E3591B0739");   //
        tempList.add("http://cfile66.uf.daum.net/image/2470F64B5500E65E13CB20");   //
        tempList.add("http://cfile66.uf.daum.net/image/2749A94C5472B78905796F");   //
        tempList.add("http://cfile66.uf.daum.net/image/2531724A5472B73A2CDF22");   //
        tempList.add("http://cfile167.uf.daum.net/image/2768614F5472B6ED1A008D");   //
        tempList.add("http://cfile66.uf.daum.net/image/217D3F3E5472B068187477");   //
        tempList.add("http://cfile166.uf.daum.net/image/2260CD3A5472B29F0279CF");   //
        tempList.add("http://cfile167.uf.daum.net/image/2546C7355472B24927BD67");   //
        tempList.add("http://cfile67.uf.daum.net/image/15355B4C4D54F83E323DD1");   //
        tempList.add("http://cfile270.uf.daum.net/image/15196B0E4ABF1EDA016179");   //

        tempList.add("http://blogfiles.naver.net/20130514_25/ilovepostbox_1368493722018OK6ko_JPEG/%B0%C9%B1%D7%B7%EC_%B9%CC%B8%F0_1%C0%A7_%283%29.jpg");   //
        tempList.add("http://postfiles3.naver.net/20130514_178/hyeonseonkim_1368465272083Yv1JE_GIF/%B0%C9%B1%D7%B7%EC_%B9%CC%B8%F0_1%C0%A7_%B9%CC%BE%B2%BF%A1%C0%CC_%BC%F6%C1%F62.gif?type=w1");   //

        tempList.add("https://t4.search.daumcdn.net/argon/0x200_85_hr/1xjUkbJwi31");
        tempList.add("https://t2.search.daumcdn.net/argon/0x200_85_hr/11QDnZBBqC9");
        tempList.add("https://t4.search.daumcdn.net/argon/0x200_85_hr/Ifc3Lm3nsf5");
        tempList.add("https://t3.search.daumcdn.net/argon/0x200_85_hr/3b4YqC5jDlI");
        tempList.add("https://t4.search.daumcdn.net/argon/0x200_85_hr/9zd3DI5J4xr");
        tempList.add("https://t3.search.daumcdn.net/argon/0x200_85_hr/LGBWEOzV0so");
        tempList.add("https://t3.search.daumcdn.net/argon/0x200_85_hr/8UrI2IB7Za4");
        tempList.add("https://t3.search.daumcdn.net/argon/0x200_85_hr/2vo0RXgywrk");
        tempList.add("https://t3.search.daumcdn.net/argon/0x200_85_hr/98dgiMXJYju");
        tempList.add("https://t4.search.daumcdn.net/argon/0x200_85_hr/1J3oB6YHREj");
        tempList.add("https://t3.search.daumcdn.net/argon/0x200_85_hr/5fM8T418M7u");
        tempList.add("http://postfiles10.naver.net/20140411_73/nachure_1397204655857IkwQW_GIF/%B0%AD%BE%C6%C1%F6_%BF%F2%C1%F7%C0%CC%B4%C2%BB%E7%C1%F8_%282%29.gif?type=w2");
        tempList.add("http://postfiles9.naver.net/20140411_264/nachure_1397204656848l5F4T_GIF/%B0%AD%BE%C6%C1%F6_%BF%F2%C1%F7%C0%CC%B4%C2%BB%E7%C1%F8_%283%29.gif?type=w2");
        tempList.add("http://postfiles2.naver.net/20140411_129/nachure_1397204658613nKfu1_GIF/%B0%AD%BE%C6%C1%F6_%BF%F2%C1%F7%C0%CC%B4%C2%BB%E7%C1%F8_%2810%29.gif?type=w2");
        tempList.add("http://postfiles1.naver.net/20140411_128/nachure_1397204659632I5aec_GIF/%B0%AD%BE%C6%C1%F6_%BF%F2%C1%F7%C0%CC%B4%C2%BB%E7%C1%F8_%2813%29.gif?type=w2");
        tempList.add("http://postfiles2.naver.net/20140411_81/nachure_1397204659957Daxfp_GIF/%B0%AD%BE%C6%C1%F6_%BF%F2%C1%F7%C0%CC%B4%C2%BB%E7%C1%F8_%289%29.gif?type=w2");         // 이거는 파일 사이즈 큰 파일임.



        mAdapter = new MyAdapter(tempList);
        mRecyclerView.setAdapter(mAdapter);


//        RecyclerItemClickListener
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override public void onItemClick(View view, int position) {
                // do whatever
                Logger.log("mRecyclerView onItemClick:: " + position);
            }
        }));
    }


    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private ArrayList<String> mDataset;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            public ImageView mImageView;
            public TextView mTextView1;
            public TextView mTextView2;

            public ViewHolder(View v) {
                super(v);

                mImageView = (ImageView)v.findViewById(R.id.imageview);
                mTextView1 = (TextView)v.findViewById(R.id.text1);
                mTextView2 = (TextView)v.findViewById(R.id.text2);

                Logger.log("RecyclerViewTest1Activity ViewHolder create");
            }

            @Override
            public void onClick(View view) {
                Logger.log("onClick getPosition " + getPosition());
                Logger.log("onClick getAdapterPosition " + getAdapterPosition());
                Logger.log("onClick getLayoutPosition " + getLayoutPosition());
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
                    .inflate(R.layout.row_recyclerview2, parent, false);

            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Logger.log("RecyclerViewTest1Activity onBindViewHolder : " + position);

            String url = mDataset.get(position);
//            holder.mImageView.setImageResource(R.drawable.profile_sample4);
            Glide.with(RecyclerViewTest2Activity.this).load(url).diskCacheStrategy(DiskCacheStrategy.SOURCE).fitCenter().into(holder.mImageView);

            holder.mTextView1.setText("연예인");
            holder.mTextView2.setText(url);

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            Logger.log("RecyclerViewTest1Activity getItemCount");
            return mDataset.size();
        }
    }
}
