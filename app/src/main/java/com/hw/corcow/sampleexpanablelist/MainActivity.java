package com.hw.corcow.sampleexpanablelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

public class MainActivity extends AppCompatActivity {

    ExpandableListView listView;
    MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ExpandableListView)findViewById(R.id.expandableListView);
        mAdapter = new MyAdapter();
        listView.setAdapter(mAdapter);

        initData();

    }

    private void initData() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5 ; j++) {
                mAdapter.add("group"+i, "group:"+i+":child:"+j);
            }
        }
    }
}
