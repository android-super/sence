package com.sence.adapter;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sence.R;
import com.sence.bean.response.PBankCardBean;
import com.sence.net.Urls;


/**
 * Created by zwy on 2019/4/8.
 * package_name is com.sence.adapter
 * 描述:SenceGit
 */
public class CardAdapter extends BaseQuickAdapter<PBankCardBean, BaseViewHolder> {
    public CardAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, PBankCardBean item) {
        Glide.with(helper.itemView.getContext()).load(Urls.base_url+item.getBank_img()).into((ImageView) helper.getView(R.id.item_img));
        helper.setText(R.id.item_name,item.getBank_name());
    }
}
