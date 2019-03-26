package com.sence.activity;

import android.os.Bundle;
import android.view.View;

import com.sence.R;
import com.sence.adapter.ServiceDetailsAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ServiceDetailsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ServiceDetailsAdapter mServiceDetailsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_servicedetails);
      initData();
    }

    private void initData() {
        mRecyclerView = findViewById(R.id.recycle_servicedetails);
        mServiceDetailsAdapter = new ServiceDetailsAdapter(ServiceDetailsActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ServiceDetailsActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mServiceDetailsAdapter);
        findViewById(R.id.iv_back_servicedetails).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}