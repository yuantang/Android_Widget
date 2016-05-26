package com.coder.tom.android_widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
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
    @Bind(R.id.hlistview_scroll_list)
    ListView hlistviewScrollList;


    /** 1为乱序，2为降序，3为升序，第一次选择降序排列 */
    private int srot_type_1=1;
    private int srot_type_2=1;
    private int srot_type_3=1;
    private int srot_type_4=1;

    // 装入所有的HScrollView
    protected List<CHScrollView> mHScrollViews = new ArrayList<CHScrollView>();
    private ArrayList<DataBean> lists = new ArrayList<DataBean>();
    private CHAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    public void onStart() {
        super.onStart();
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        BusProvider.getInstance().unregister(this);
    }
    private void initData() {
        mHScrollViews.clear();
        itemScrollTitle.scrollTo(0, 0);
        // 添加头滑动事件
        mHScrollViews.add(itemScrollTitle);
        for (int i = 0; i < 100; i++) {
            lists.add(new DataBean("宝马X"+i,"00"+i,"AA"+i,"BB"+i,"CC"+i,"DD"+i,"EE"+i,"FF"+i));
        }
    }

    private void initView() {
        adapter=new CHAdapter(this,lists,mHScrollViews);
        hlistviewScrollList.setAdapter(adapter);
    }
    @Subscribe
    public void onScrollChange(OnScrollEvent event){
        Log.d("OnScrollEvent","OnScrollEvent");
        for (CHScrollView scrollView : mHScrollViews) {
            scrollView.smoothScrollTo(event.getL(), event.getT());
        }
    }
    @OnClick({R.id.ll_B_1, R.id.ll_B_2, R.id.ll_B_3, R.id.ll_B_4})
    public void onClick(View view) {
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
                break;
        }
    }
}
