package com.coder.tom.android_widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {
    private String TAG="Main2Activity";
    @Bind(R.id.exlist)
    ExpandableListView exList;
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
    @Bind(R.id.tab_lly)
    LinearLayout tabLly;


    private Adapter2 adapter2;
    private List<GroupData> datas;
    protected List<CHScrollView> mHScrollViews = new ArrayList<CHScrollView>();
    /** 1为乱序，2为降序，3为升序，第一次选择降序排列 */
    private int srot_type_1=1;
    private int srot_type_2=1;
    private int srot_type_3=1;
    private int srot_type_4=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        BusProvider.getInstance().register(this);
        initData();
        initView();
    }

    private void initView() {
        mHScrollViews.clear();
        mHScrollViews.add(itemScrollTitle);
        exList.setGroupIndicator(null);//将控件默认的左边箭头去掉，
        adapter2 = new Adapter2(this, datas, mHScrollViews);
        exList.setAdapter(adapter2);
        //展示所有子项
        for (int i = 0; i < datas.size(); i++) {
            exList.expandGroup(i);
        }

        exList.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Log.e("ssssss","firstVisibleItem="+firstVisibleItem +"  visibleItemCount="+visibleItemCount+"  totalItemCount="+totalItemCount);
                int iTotalCount = 0;
                for(int i=0;i<datas.size();i++){
                    iTotalCount+= (datas.get(i).getChilds().size()+1);
                    Log.e("iTotalCount","iTotalCount:"+iTotalCount);
                    Log.e("firstVisibleItem","firstVisibleItem:"+firstVisibleItem);
                    if(i==0){
                        if(firstVisibleItem<iTotalCount){
                            productNameTxt.setText(datas.get(0).name);
                            productNameTxt.setTag(0);
                        }
                    }
                    if((firstVisibleItem)>=iTotalCount){
                        productNameTxt.setText(datas.get(i+1).name);
                        productNameTxt.setTag(i+1);
                    }
                }
            }
        });

    }

    @Subscribe
    public void onScrollChange(OnScrollEvent event) {
        Log.d("OnScrollEvent", "OnScrollEvent");
        for (CHScrollView scrollView : mHScrollViews) {
            scrollView.smoothScrollTo(event.getL(), event.getT());
        }
    }
    @Subscribe
    public void onSortChange(OnSortPosEvent onSortPosEvent){
        int sortTag=onSortPosEvent.sortTag;
        int postion= onSortPosEvent.postion;
        int sortWay=onSortPosEvent.sortWay;
        Log.e(TAG,"sortTag:"+sortTag);
        Log.e(TAG,"postion:"+postion);
        Log.e(TAG,"sortWay:"+sortWay);

        if (sortWay==2){//降序
            Collections.reverse(datas.get(postion).getChilds());
        }else if(sortWay==3){//升序
            Collections.reverse(datas.get(postion).getChilds());
        }
        adapter2.notifyDataSetChanged();
    }

    private void initData() {
        mHScrollViews.clear();
        datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            GroupData data = new GroupData();
            data.setName("基金名称"+i);
            data.setA("GroupA" + i);
            data.setB("GroupB" + i);
            data.setC("GroupC" + i);
            ArrayList<GroupData.Child> childList = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                GroupData.Child child = new GroupData.Child("宝马X" + j, "00" + j, "AA" + j, "BB" + j, "CC" + j, "DD" + j, "EE" + j, "FF" + j);
                childList.add(child);
            }
            data.setChilds(childList);
            datas.add(data);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BusProvider.getInstance().unregister(this);
    }

    @OnClick({R.id.ll_B_1, R.id.ll_B_2, R.id.ll_B_3, R.id.ll_B_4})
    public void onClick(View view) {
        int groupPostion;
        switch (view.getId()) {
            case R.id.ll_B_1:
                imgB2.setVisibility(View.GONE);
                imgB3.setVisibility(View.GONE);
                imgB4.setVisibility(View.GONE);
                imgB1.setVisibility(View.VISIBLE);
                if (srot_type_1==1){
                    srot_type_1=2;
                    imgB1.setImageResource(R.mipmap.arrow_fund_product_sort_desc);
                }else if (srot_type_1==2) {
                    srot_type_1=3;
                    imgB1.setImageResource(R.mipmap.arrow_fund_product_sort_asc);
                }else if(srot_type_1==3){
                    srot_type_1=2;
                    imgB1.setImageResource(R.mipmap.arrow_fund_product_sort_desc);
                }
                groupPostion= (int) productNameTxt.getTag();
                BusProvider.getInstance().post(new OnSortPosEvent(Constant.TAG_ONE,groupPostion,srot_type_1));
                break;
            case R.id.ll_B_2:
                imgB1.setVisibility(View.GONE);
                imgB3.setVisibility(View.GONE);
                imgB4.setVisibility(View.GONE);
                imgB2.setVisibility(View.VISIBLE);
                if (srot_type_2==1){
                    srot_type_2=2;
                    imgB2.setImageResource(R.mipmap.arrow_fund_product_sort_desc);
                }else if (srot_type_2==2) {
                    srot_type_2=3;
                    imgB2.setImageResource(R.mipmap.arrow_fund_product_sort_asc);
                }else if(srot_type_2==3){
                    srot_type_2=2;
                    imgB2.setImageResource(R.mipmap.arrow_fund_product_sort_desc);
                }
                groupPostion= (int) productNameTxt.getTag();
                BusProvider.getInstance().post(new OnSortPosEvent(Constant.TAG_TWO,groupPostion,srot_type_2));
                break;
            case R.id.ll_B_3:
                imgB2.setVisibility(View.GONE);
                imgB1.setVisibility(View.GONE);
                imgB4.setVisibility(View.GONE);
                imgB3.setVisibility(View.VISIBLE);
                if (srot_type_3==1){
                    srot_type_3=2;
                    imgB3.setImageResource(R.mipmap.arrow_fund_product_sort_desc);
                }else if (srot_type_3==2) {
                    srot_type_3=3;
                    imgB3.setImageResource(R.mipmap.arrow_fund_product_sort_asc);
                }else if(srot_type_3==3){
                    srot_type_3=2;
                    imgB3.setImageResource(R.mipmap.arrow_fund_product_sort_desc);
                }
                groupPostion= (int) productNameTxt.getTag();
                BusProvider.getInstance().post(new OnSortPosEvent(Constant.TAG_THREE,groupPostion,srot_type_3));

                break;
            case R.id.ll_B_4:
                imgB2.setVisibility(View.GONE);
                imgB3.setVisibility(View.GONE);
                imgB1.setVisibility(View.GONE);
                imgB4.setVisibility(View.VISIBLE);
                if (srot_type_4==1){
                    srot_type_4=2;
                    imgB4.setImageResource(R.mipmap.arrow_fund_product_sort_desc);
                }else if (srot_type_4==2) {
                    srot_type_4=3;
                    imgB4.setImageResource(R.mipmap.arrow_fund_product_sort_asc);
                }else if(srot_type_4==3){
                    srot_type_4=2;
                    imgB4.setImageResource(R.mipmap.arrow_fund_product_sort_desc);
                }
                groupPostion= (int) productNameTxt.getTag();
                BusProvider.getInstance().post(new OnSortPosEvent(Constant.TAG_FOURE,groupPostion,srot_type_4));
                break;
        }
    }
}
