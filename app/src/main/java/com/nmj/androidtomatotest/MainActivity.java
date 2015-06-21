package com.nmj.androidtomatotest;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

import com.nmj.androidtomatotest.coordinator.Coordinator1Activity;
import com.nmj.androidtomatotest.coordinator.Coordinator3Activity;
import com.nmj.androidtomatotest.coordinator.Coordinator4Activity;
import com.nmj.androidtomatotest.recyclerview.RecyclerViewTest1Activity;
import com.nmj.androidtomatotest.recyclerview.RecyclerViewTest2Activity;
import com.nmj.androidtomatotest.recyclerview.RecyclerViewTest3Activity;
import com.nmj.androidtomatotest.recyclerview.RecyclerViewTest4Activity;
import com.nmj.androidtomatotest.viewpager.ViewPagerTest1Activity;
import com.nmj.androidtomatotest.viewpager.ViewPagerTest2Activity;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);

        startActivity(new Intent(this, Coordinator4Activity.class));

        {
            Button btn = new Button(this);
            btn.setText("ViewPager1");
            root.addView(btn);
            btn.setOnClickListener(v -> {
                startActivity(new Intent(this, ViewPagerTest1Activity.class));
            });
        }
        {
            Button btn = new Button(this);
            btn.setText("ViewPager2");
            root.addView(btn);
            btn.setOnClickListener(v -> {
                startActivity(new Intent(this, ViewPagerTest2Activity.class));
            });
        }
        {
            Button btn = new Button(this);
            btn.setText("recyclerview1");
            root.addView(btn);
            btn.setOnClickListener(v -> {
                startActivity(new Intent(this, RecyclerViewTest1Activity.class));
            });
        }
        {
            Button btn = new Button(this);
            btn.setText("recyclerview2");
            root.addView(btn);
            btn.setOnClickListener(v -> {
                startActivity(new Intent(this, RecyclerViewTest2Activity.class));
            });
        }
        {
            Button btn = new Button(this);
            btn.setText("recyclerview3");
            root.addView(btn);
            btn.setOnClickListener(v -> {
                startActivity(new Intent(this, RecyclerViewTest3Activity.class));
            });
        }
        {
            Button btn = new Button(this);
            btn.setText("recyclerview4");
            root.addView(btn);
            btn.setOnClickListener(v -> {
                startActivity(new Intent(this, RecyclerViewTest4Activity.class));
            });
        }
        {
            Button btn = new Button(this);
            btn.setText("Coordinator1");
            root.addView(btn);
            btn.setOnClickListener(v -> {
                startActivity(new Intent(this, Coordinator1Activity.class));
            });
        }
        {
            Button btn = new Button(this);
            btn.setText("Coordinator2");
            root.addView(btn);
            btn.setOnClickListener(v -> {
                startActivity(new Intent(this, Coordinator3Activity.class));
            });
        }
        {
            Button btn = new Button(this);
            btn.setText("Coordinator4");
            root.addView(btn);
            btn.setOnClickListener(v -> {
                startActivity(new Intent(this, Coordinator4Activity.class));
            });
        }
        {
            Button btn = new Button(this);
            btn.setText("test");
            root.addView(btn);
            btn.setOnClickListener(v -> {

            });
        }
        {
            Button btn = new Button(this);
            btn.setText("test");
            root.addView(btn);
            btn.setOnClickListener(v -> {

            });
        }
        setContentView(root);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
