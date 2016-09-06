package com.coder.tom.android_widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

import com.squareup.otto.Produce;

public class CHScrollView extends HorizontalScrollView {
	int lastL;
	int lastT;
	public CHScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	public CHScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CHScrollView(Context context) {
		super(context);
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		// 当前的CHSCrollView被触摸时，滑动其它
		lastL=l;
		lastT=t;
		BusProvider.getInstance().post(onScrollEvent());
	}
	@Produce
	public OnScrollEvent onScrollEvent(){
		return new OnScrollEvent(lastL,lastT);
	}
}
