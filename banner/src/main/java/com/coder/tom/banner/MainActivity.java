package com.coder.tom.banner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ConvenientBanner banner;
    List<String> imgs=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banner= (ConvenientBanner) findViewById(R.id.banner1);
        imgs.add("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1464593078&di=f169abdfbb40ab115479ef4887cea614&src=http://img.igdzc.com/pics/2016/0415/20160415115852742.jpg");
        imgs.add("http://img3.redocn.com/tupian/20140708/weidianyingxuanchuanhaibaoshiliangmoban_2691745.jpg");
        imgs.add("http://b.hiphotos.baidu.com/zhidao/pic/item/0bd162d9f2d3572c8801239e8e13632763d0c395.jpg");
        imgs.add("http://img.sucai.redocn.com/attachments/images/201203/20120331/Redocn_2012033107052171.jpg");
        imgs.add("http://img.aiimg.com/uploads/allimg/150704/1-150F4213440.jpg");

        banner.setPages(new CBViewHolderCreator<LocalImageHolderview>(){
            @Override
            public LocalImageHolderview createHolder() {
                return new LocalImageHolderview();
            }
        },imgs)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.mipmap.home_loggedin_dot_clicked,R.mipmap.home_loggedin_dot_normal})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
        .setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this,position+"",Toast.LENGTH_SHORT).show();
            }
        })
        ;
    }

    @Override
    protected void onResume() {
        super.onResume();
        //自动滑动
        banner.startTurning(3000);
    }
    @Override
    protected void onPause() {
        super.onPause();
        banner.stopTurning();
    }
}
