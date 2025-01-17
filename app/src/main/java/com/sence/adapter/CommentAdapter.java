package com.sence.adapter;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sence.R;
import com.sence.bean.response.PCommentBean;
import com.sence.utils.DateUtils;
import com.sence.utils.GlideUtils;
import com.sence.view.MyTextView;

/**
 * Created by zwy on 2019/3/25.
 * package_name is com.sence.adapter
 * 描述:SenceGit
 */
public class CommentAdapter extends BaseQuickAdapter<PCommentBean, BaseViewHolder> {
    public CommentAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, PCommentBean item) {
        GlideUtils.getInstance().loadHead(item.getUser().getAvatar(), (ImageView) helper.getView(R.id.item_img));
        helper.setText(R.id.item_name, item.getUser().getNick_name());
        helper.setText(R.id.item_time,
                DateUtils.convertTimeNew(item.getDiff_time(), item.getNow_time(), item.getAdd_time()));
        helper.setText(R.id.item_content, item.getContent());
        helper.setText(R.id.item_replay_content, item.getOld_message());
        MyTextView item_content = helper.getView(R.id.item_content);
        MyTextView item_replay_content = helper.getView(R.id.item_replay_content);
        TextView item_support = helper.getView(R.id.item_support);
        if (item.getIs_like().equals("1")) {
            item_support.setSelected(true);
        } else {
            item_support.setSelected(false);
        }

        if (!TextUtils.isEmpty(item.getOld_message())) {
            item_replay_content.setVisibility(View.VISIBLE);
            item_replay_content.setText("@" + item.getUser().getNick_name() + "：" + item.getOld_message());
            item_replay_content.setSpecifiedTextsColor(item_replay_content.getText().toString(),
                    "@" + item.getUser().getNick_name(),
                    Color.parseColor(
                            "#507daf"));
            item_content.setText("回复" + "@" + item.getUser().getNick_name() + "：" + item.getContent());
            item_content.setSpecifiedTextsColor(item_content.getText().toString(),
                    "@" + item.getUser().getNick_name(),
                    Color.parseColor(
                            "#507daf"));
        } else {
            item_replay_content.setVisibility(View.GONE);
            item_content.setText(item.getContent());
        }
        helper.addOnClickListener(R.id.item_support);
    }
}
