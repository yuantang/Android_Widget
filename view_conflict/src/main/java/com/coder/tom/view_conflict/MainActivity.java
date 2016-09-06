package com.coder.tom.view_conflict;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private HorizontalScrollViewEx horizontalScrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        horizontalScrollView= (HorizontalScrollViewEx) findViewById(R.id.HorizontalScrollView);
        LayoutInflater inflater=LayoutInflater.from(this);
        WindowManager windowManger =(WindowManager)getBaseContext().getSystemService(Context.WINDOW_SERVICE);
        final int screenWidth=windowManger.getDefaultDisplay().getWidth();
        final int  screenHeight=windowManger.getDefaultDisplay().getHeight();

        for (int i = 0; i < 3; i++) {
            ViewGroup layout= (ViewGroup) inflater.inflate(R.layout.content_lyout,horizontalScrollView,false);
            layout.getLayoutParams().width=screenWidth;
//            layout.getLayoutParams().height=screenHeight;
            TextView text= (TextView) layout.findViewById(R.id.text);
            layout.setBackgroundColor(Color.rgb(255 / (i + 1), 255 / (i + 1), 0));
            text.setText("page"+i);
            creatList(layout);
            horizontalScrollView.addView(layout);
        }
    }

    private void creatList(ViewGroup layout) {
        List<String> datas=new ArrayList<>();
        for (int i = 0; i <30 ; i++) {
            datas.add("wwwwwwwwwwwwwwwwwwwwwww"+i);
        }
        ListView list= (ListView) layout.findViewById(R.id.list);
        ArrayAdapter adapter=new ArrayAdapter<String>(this,R.layout.content_lyout_item,R.id.text,datas);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "click item", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
