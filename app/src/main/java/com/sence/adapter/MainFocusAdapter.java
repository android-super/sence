package com.sence.adapter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.ActivityOptionsCompat;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sence.R;
import com.sence.activity.ContentDetailActivity;
import com.sence.bean.response.PMainFocusBean;
import com.sence.net.Urls;

/**
 * Created by zwy on 2019/3/12.
 * package_name is com.sence.adapter
 * 描述:Sence
 */
public class MainFocusAdapter extends BaseQuickAdapter<PMainFocusBean, BaseViewHolder> {
    public MainFocusAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, final PMainFocusBean item) {
        final Activity activity = (Activity) helper.itemView.getContext();
        final ImageView item_img = helper.getView(R.id.item_img);
        Glide.with(activity).load(Urls.base_url + item.getAlbum_url()).into((ImageView) helper.getView(R.id.item_img));
        helper.setText(R.id.item_describe, item.getContent());
        Glide.with(activity).load(Urls.base_url + item.getAvatar()).into((ImageView) helper.getView(R.id.item_head));
        helper.setText(R.id.item_name, item.getNick_name());
        TextView item_support = helper.getView(R.id.item_support);
        item_support.setText(item.getPraise_count());
        if (item.getIs_like().equals("1")) {
            item_support.setSelected(true);
        } else {
            item_support.setSelected(false);
        }
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
                        item_img, activity.getResources().getString(R.string.translation_recommend_name));
                Intent intent = new Intent(activity, ContentDetailActivity.class);
                intent.putExtra("nid",item.getNid());
                activity.startActivity(intent, activityOptions.toBundle());
            }
        });
        helper.addOnClickListener(R.id.item_support);
    }
}
