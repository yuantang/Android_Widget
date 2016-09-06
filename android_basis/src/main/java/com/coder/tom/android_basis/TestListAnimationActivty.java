package com.coder.tom.android_basis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TestListAnimationActivty extends AppCompatActivity {

    @Bind(R.id.listview)
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_list_animation_activty);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        Animation animation= AnimationUtils.loadAnimation(this, R.anim.anim_item);
        LayoutAnimationController controller=new LayoutAnimationController(animation);
        controller.setDelay(0.5f);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        listview.setLayoutAnimation(controller);   }
}
