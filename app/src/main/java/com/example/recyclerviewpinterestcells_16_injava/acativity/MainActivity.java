package com.example.recyclerviewpinterestcells_16_injava.acativity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;

import com.example.recyclerviewpinterestcells_16_injava.R;
import com.example.recyclerviewpinterestcells_16_injava.adapter.CustomAdapter;
import com.example.recyclerviewpinterestcells_16_injava.helper.SpacesItemDecoration;
import com.example.recyclerviewpinterestcells_16_injava.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        List<Member> members = prepareMemerList();
        refreshAdapter(members);
    }

    private List<Member> prepareMemerList() {
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 30; i++){
            members.add(new Member("Ilhombek" + i, "Ubaydullayev" + i));
        }
        return members;
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        SpacesItemDecoration decoration = new SpacesItemDecoration(10);
        recyclerView.addItemDecoration(decoration);
    }

}