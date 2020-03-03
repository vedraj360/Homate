package com.vdx.homate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.vdx.homate.Adapters.ButtonAdapter;
import com.vdx.homate.Adapters.RoomAdapter;

public class RoomsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView roomname;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        String room_name = getIntent().getStringExtra("room_name");
        initView();
        roomname.setText(room_name);
        setRecyclerView();
        backButtonOnClick();
    }

    private void initView() {
        recyclerView = findViewById(R.id.room_activity_recycler);
        roomname = findViewById(R.id.activity_room_name);
        back = findViewById(R.id.room_activity_back);
    }

    private void backButtonOnClick() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }

    private void setRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RoomAdapter adapter = new RoomAdapter(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(false);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);
    }
}
