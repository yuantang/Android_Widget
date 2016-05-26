package com.coder.tom.android_widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tangyuan on 2016/5/26.
 */
public class CHAdapter extends BaseAdapter {
    private List<DataBean> datas;
    private Context context;
    protected List<CHScrollView> mHScrollViews;
    public CHAdapter(Context context, List<DataBean> datas, List<CHScrollView> mHScrollViews ) {
        this.context = context;
        this.datas = datas;
        this.mHScrollViews=mHScrollViews;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.list_item, null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        mHScrollViews.add(holder.itemChscrollScroll);
        DataBean dataItem=datas.get(position);
        holder.itemTitlev.setText(dataItem.name);
        holder.itemTitlevCode.setText(dataItem.code);
        holder.itemDatav1.setText(dataItem.data1);
        holder.itemDatav2.setText(dataItem.data2);
        holder.itemDatav3.setText(dataItem.data3);
        holder.itemDatav4.setText(dataItem.data4);
        holder.itemDatav5.setText(dataItem.data5);


        holder.rlDatav1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"item",Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemDatav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"item",Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemDatav3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"item",Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemDatav4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"item",Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    public class ViewHolder {
        @Bind(R.id.item_titlev)
        TextView itemTitlev;
        @Bind(R.id.item_titlev_code)
        TextView itemTitlevCode;
        @Bind(R.id.item_datav1)
        TextView itemDatav1;
        @Bind(R.id.item_datav5)
        TextView itemDatav5;
        @Bind(R.id.rl_datav1)
        RelativeLayout rlDatav1;
        @Bind(R.id.item_datav2)
        TextView itemDatav2;
        @Bind(R.id.item_datav3)
        TextView itemDatav3;
        @Bind(R.id.item_datav4)
        TextView itemDatav4;
        @Bind(R.id.item_chscroll_scroll)
        CHScrollView itemChscrollScroll;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
