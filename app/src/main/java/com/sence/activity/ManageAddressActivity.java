package com.sence.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sence.R;
import com.sence.adapter.ManageAddressAdapter;
import com.sence.bean.request.RManageAddressBean;
import com.sence.bean.response.PManageAddressBean;
import com.sence.net.HttpCode;
import com.sence.net.HttpManager;
import com.sence.net.manager.ApiCallBack;
import com.sence.utils.StatusBarUtil;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ManageAddressActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ManageAddressAdapter mManageAddressAdapter;
    private int page=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manageaddress);
        StatusBarUtil.setLightMode(this);
        mRecyclerView = findViewById(R.id.rlv_address_manageaddress);
        TextView mTitle = findViewById(R.id.pub_title);
        mTitle.setText("管理收货地址");
        ImageView mBack = findViewById(R.id.pub_back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mManageAddressAdapter = new ManageAddressAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mManageAddressAdapter);
        dohttp();

    }

    private void dohttp() {
        HttpManager.getInstance().PlayNetCode(HttpCode.ADDRESS_LIST, new RManageAddressBean("1",page+"","10")).request(new ApiCallBack<List<PManageAddressBean>>() {
            @Override
            public void onFinish() {

            }

            @Override
            public void Message(int code, String message) {

            }

            @Override
            public void onSuccess(final List<PManageAddressBean> o, String msg) {
                mManageAddressAdapter.setList(o);
                mManageAddressAdapter.result(new ManageAddressAdapter.DeleteAddressListener() {
                    @Override
                    public void delete(int i) {
                        o.remove(i);
                        mManageAddressAdapter.setList(o);
                    }
                });
            }
        });
    }


}
