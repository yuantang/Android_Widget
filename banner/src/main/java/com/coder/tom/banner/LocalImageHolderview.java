package com.coder.tom.banner;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.squareup.picasso.Picasso;

/**
 * Created by tangyuan on 2016/5/30.
 */
public class LocalImageHolderview implements Holder<String>{
    private ImageView imageView;
    @Override
    public View createView(Context context) {
        imageView=new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }
    @Override
    public void UpdateUI(Context context, int position, String data) {
        Picasso.with(context).load(data).into(imageView);
    }
}
