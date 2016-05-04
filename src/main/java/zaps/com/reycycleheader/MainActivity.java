/*
 * Copyright (c) 2016. Subhash Kumar
 */

package zaps.com.reycycleheader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HashMap<String, ArrayList<String>> listMap = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        list.add("item 1");
        list.add("item 2");
        list.add("item 3");
        list.add("item 4");
        list.add("item 5");
        listMap.put("Section 1", list);
        listMap.put("Section 2", list);
        listMap.put("Section 3", list);
        listMap.put("Section 4", list);
        listMap.put("Section 5", list);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.mainview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(new MainAdapter(listMap));

    }
}
