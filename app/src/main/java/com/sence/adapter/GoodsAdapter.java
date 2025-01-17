package com.sence.adapter;

import android.graphics.Paint;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sence.R;
import com.sence.bean.response.PContentDetailBean;
import com.sence.net.Urls;
import com.sence.utils.GlideUtils;

/**
 * Created by zwy on 2019/3/25.
 * package_name is com.sence.adapter
 * 描述:SenceGit
 */
public class GoodsAdapter extends BaseQuickAdapter<PContentDetailBean.NoteInfoBean.GoodsInfoBean, BaseViewHolder> {
    public GoodsAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, PContentDetailBean.NoteInfoBean.GoodsInfoBean item) {
        GlideUtils.getInstance().loadNormal(item.getImg(), (ImageView) helper.getView(R.id.item_img));
        helper.setText(R.id.item_content, item.getName());
        helper.setText(R.id.item_price, item.getVprice());
        helper.setText(R.id.item_pre_price, item.getPrice());
        TextView item_pre_price_describe = helper.getView(R.id.item_pre_price_describe);
        TextView item_pre_price = helper.getView(R.id.item_pre_price);
        item_pre_price_describe.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        item_pre_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        helper.addOnClickListener(R.id.item_bus);
    }
}
