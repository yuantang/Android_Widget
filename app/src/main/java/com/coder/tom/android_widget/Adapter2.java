package com.coder.tom.android_widget;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tangyuan on 2016/9/5.
 */
public class Adapter2 extends BaseExpandableListAdapter {
    /** 1为乱序，2为降序，3为升序，第一次选择降序排列 */
    private int srot_type_1=1;
    private int srot_type_2=1;
    private int srot_type_3=1;
    private int srot_type_4=1;


    private Context context;
    private List<GroupData> groupDatas;
    protected List<CHScrollView> mHScrollViews;

    public Adapter2(Context context, List<GroupData> groups, List<CHScrollView> mHScrollViews) {
        this.context = context;
        this.groupDatas = groups;
        this.mHScrollViews = mHScrollViews;
    }

    @Override
    public int getGroupCount() {
        return groupDatas.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groupDatas.get(groupPosition).getChilds().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupDatas.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        Log.d("getChild", groupDatas.get(groupPosition).getChilds().get(childPosition) + "");
        return groupDatas.get(groupPosition).getChilds().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                             ViewGroup parent) {
        //加载组布局
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.group_item, null);
            groupViewHolder = new GroupViewHolder(convertView);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        mHScrollViews.add(groupViewHolder.itemScrollTitle);
        groupViewHolder.productNameTxt.setText(groupDatas.get(groupPosition).getName());
        setOnclick(groupViewHolder,groupDatas.get(groupPosition),groupPosition);

        return convertView;
    }

    private void setOnclick(final GroupViewHolder groupViewHolder, final GroupData groupData, final int groupPosition) {
        groupViewHolder.llB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                groupViewHolder.imgB2.setVisibility(View.GONE);
                groupViewHolder.imgB3.setVisibility(View.GONE);
                groupViewHolder.imgB4.setVisibility(View.GONE);
                groupViewHolder.imgB1.setVisibility(View.VISIBLE);
                if (srot_type_1==1){
                    srot_type_1=2;
                    groupViewHolder.imgB1.setImageResource(R.mipmap.arrow_fund_product_sort_desc);
                }else if (srot_type_1==2) {
                    srot_type_1=3;
                    groupViewHolder.imgB1.setImageResource(R.mipmap.arrow_fund_product_sort_asc);
                }else if(srot_type_1==3){
                    srot_type_1=2;
                    groupViewHolder.imgB1.setImageResource(R.mipmap.arrow_fund_product_sort_desc);
                }
                BusProvider.getInstance().post(new OnSortPosEvent(Constant.TAG_ONE ,groupPosition,srot_type_1));

            }
        });
        groupViewHolder.llB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                groupViewHolder.imgB1.setVisibility(View.GONE);
                groupViewHolder.imgB3.setVisibility(View.GONE);
                groupViewHolder.imgB4.setVisibility(View.GONE);
                groupViewHolder.imgB2.setVisibility(View.VISIBLE);
                if (srot_type_2==1){
                    srot_type_2=2;
                    groupViewHolder.imgB2.setImageResource(R.mipmap.arrow_fund_product_sort_desc);
                }else if (srot_type_2==2) {
                    srot_type_2=3;
                    groupViewHolder.imgB2.setImageResource(R.mipmap.arrow_fund_product_sort_asc);
                }else if(srot_type_2==3){
                    srot_type_2=2;
                    groupViewHolder.imgB2.setImageResource(R.mipmap.arrow_fund_product_sort_desc);
                }
                BusProvider.getInstance().post(new OnSortPosEvent(Constant.TAG_TWO ,groupPosition,srot_type_2));

            }
        });
        groupViewHolder.llB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                groupViewHolder.imgB2.setVisibility(View.GONE);
                groupViewHolder.imgB1.setVisibility(View.GONE);
                groupViewHolder.imgB4.setVisibility(View.GONE);
                groupViewHolder.imgB3.setVisibility(View.VISIBLE);
                if (srot_type_3==1){
                    srot_type_3=2;
                    groupViewHolder.imgB3.setImageResource(R.mipmap.arrow_fund_product_sort_desc);
                }else if (srot_type_3==2) {
                    srot_type_3=3;
                    groupViewHolder.imgB3.setImageResource(R.mipmap.arrow_fund_product_sort_asc);
                }else if(srot_type_3==3){
                    srot_type_3=2;
                    groupViewHolder.imgB3.setImageResource(R.mipmap.arrow_fund_product_sort_desc);
                }
                BusProvider.getInstance().post(new OnSortPosEvent(Constant.TAG_THREE ,groupPosition,srot_type_3));

            }
        });
        groupViewHolder.llB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                groupViewHolder.imgB2.setVisibility(View.GONE);
                groupViewHolder.imgB3.setVisibility(View.GONE);
                groupViewHolder.imgB1.setVisibility(View.GONE);
                groupViewHolder.imgB4.setVisibility(View.VISIBLE);
                if (srot_type_4==1){
                    srot_type_4=2;
                    groupViewHolder.imgB4.setImageResource(R.mipmap.arrow_fund_product_sort_desc);
                }else if (srot_type_4==2) {
                    srot_type_4=3;
                    groupViewHolder.imgB4.setImageResource(R.mipmap.arrow_fund_product_sort_asc);
                }else if(srot_type_4==3){
                    srot_type_4=2;
                    groupViewHolder.imgB4.setImageResource(R.mipmap.arrow_fund_product_sort_desc);
                }
                BusProvider.getInstance().post(new OnSortPosEvent(Constant.TAG_FOURE ,groupPosition,srot_type_4));

            }
        });
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
            childViewHolder = new ChildViewHolder(convertView);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }

        mHScrollViews.add(childViewHolder.itemChscrollScroll);
        GroupData.Child dataItem=groupDatas.get(groupPosition).getChilds().get(childPosition);
        childViewHolder.itemTitlev.setText(dataItem.name);
        childViewHolder.itemTitlevCode.setText(dataItem.code);
        childViewHolder.itemDatav1.setText(dataItem.data1);
        childViewHolder.itemDatav2.setText(dataItem.data2);
        childViewHolder.itemDatav3.setText(dataItem.data3);
        childViewHolder.itemDatav4.setText(dataItem.data4);
        childViewHolder.itemDatav5.setText(dataItem.data5);


        childViewHolder.rlDatav1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"item",Toast.LENGTH_SHORT).show();
            }
        });
        childViewHolder.itemDatav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"item",Toast.LENGTH_SHORT).show();
            }
        });
        childViewHolder.itemDatav3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"item",Toast.LENGTH_SHORT).show();
            }
        });
        childViewHolder.itemDatav4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"item",Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    public class ChildViewHolder {
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

        ChildViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
    public class GroupViewHolder {
        @Bind(R.id.product_name_txt)
        TextView productNameTxt;
        @Bind(R.id.product_name_lly)
        LinearLayout productNameLly;
        @Bind(R.id.tv_B_1)
        TextView tvB1;
        @Bind(R.id.img_B_1)
        ImageView imgB1;
        @Bind(R.id.ll_B_1)
        LinearLayout llB1;
        @Bind(R.id.tv_B_2)
        TextView tvB2;
        @Bind(R.id.img_B_2)
        ImageView imgB2;
        @Bind(R.id.ll_B_2)
        LinearLayout llB2;
        @Bind(R.id.tv_B_3)
        TextView tvB3;
        @Bind(R.id.img_B_3)
        ImageView imgB3;
        @Bind(R.id.ll_B_3)
        LinearLayout llB3;
        @Bind(R.id.tv_B_4)
        TextView tvB4;
        @Bind(R.id.img_B_4)
        ImageView imgB4;
        @Bind(R.id.ll_B_4)
        LinearLayout llB4;
        @Bind(R.id.item_scroll_title)
        CHScrollView itemScrollTitle;

        GroupViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }


}





