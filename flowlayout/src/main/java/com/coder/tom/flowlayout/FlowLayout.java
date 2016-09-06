package com.coder.tom.flowlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tangyuan on 2016/6/2.
 */
public class FlowLayout extends ViewGroup {
    public int  verticalSpacing = 20;

    public FlowLayout(Context context, int verticalSpacing) {
        super(context);
    }
    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr, int verticalSpacing) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();

        int widthUsed = paddingLeft + paddingRight;
        int heightUsed = paddingTop + paddingBottom;

        int childMaxHeightOfThisLine = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                int childUsedWidth = 0;
                int childUsedHeight = 0;
                measureChild(child,widthMeasureSpec,heightMeasureSpec);
                childUsedWidth += child.getMeasuredWidth();
                childUsedHeight += child.getMeasuredHeight();

                LayoutParams childLayoutParams = child.getLayoutParams();

                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childLayoutParams;

                childUsedWidth += marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                childUsedHeight += marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;

                if (widthUsed + childUsedWidth < widthSpecSize) {
                    widthUsed += childUsedWidth;
                    if (childUsedHeight > childMaxHeightOfThisLine) {
                        childMaxHeightOfThisLine = childUsedHeight;
                    }
                } else {
                    heightUsed += childMaxHeightOfThisLine + verticalSpacing;
                    widthUsed = paddingLeft + paddingRight + childUsedWidth;
                    childMaxHeightOfThisLine = childUsedHeight;
                }

            }

        }

        heightUsed += childMaxHeightOfThisLine;
        setMeasuredDimension(widthSpecSize, heightUsed);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();

        int childStartLayoutX = paddingLeft;
        int childStartLayoutY = paddingTop;

        int widthUsed = paddingLeft + paddingRight;

        int childMaxHeight = 0;

        int childCount = getChildCount();

        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                int childNeededWidth, childNeedHeight;
                int left, top, right, bottom;

                int childMeasuredWidth = child.getMeasuredWidth();
                int childMeasuredHeight = child.getMeasuredHeight();

                LayoutParams childLayoutParams = child.getLayoutParams();
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childLayoutParams;
                int childLeftMargin = marginLayoutParams.leftMargin;
                int childTopMargin = marginLayoutParams.topMargin;
                int childRightMargin = marginLayoutParams.rightMargin;
                int childBottomMargin = marginLayoutParams.bottomMargin;
                childNeededWidth = childLeftMargin + childRightMargin + childMeasuredWidth;
                childNeedHeight = childTopMargin + childBottomMargin + childMeasuredHeight;

                if (widthUsed + childNeededWidth <= r - l) {
                    if (childNeedHeight > childMaxHeight) {
                        childMaxHeight = childNeedHeight;
                    }
                    left = childStartLayoutX + childLeftMargin;
                    top = childStartLayoutY + childTopMargin;
                    right = left + childMeasuredWidth;
                    bottom = top + childMeasuredHeight;
                    widthUsed += childNeededWidth;
                    childStartLayoutX += childNeededWidth;
                } else {
                    childStartLayoutY += childMaxHeight + verticalSpacing;
                    childStartLayoutX = paddingLeft;
                    widthUsed = paddingLeft + paddingRight;
                    left = childStartLayoutX + childLeftMargin;
                    top = childStartLayoutY + childTopMargin;
                    right = left + childMeasuredWidth;
                    bottom = top + childMeasuredHeight;
                    widthUsed += childNeededWidth;
                    childStartLayoutX += childNeededWidth;
                    childMaxHeight = childNeedHeight;
                }
                child.layout(left, top, right, bottom);
            }
        }
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int widthSpecMode=MeasureSpec.getMode(widthMeasureSpec);
//        int heightSpecMode=MeasureSpec.getMode(heightMeasureSpec);
//        int widthSpceSize=MeasureSpec.getSize(widthMeasureSpec);
//        int heightSpceSize=MeasureSpec.getSize(heightMeasureSpec);
//
//
//        int paddingLeft=getPaddingLeft();
//        int paddingRight=getPaddingRight();
//        int paddingTop=getPaddingTop();
//        int paddingBottom=getPaddingBottom();
//
//        int widthUsed=paddingLeft+paddingRight;
//        int heightUsed=paddingBottom+paddingTop;
//
//
//        //子view在一行占据的宽度
//        int childMaxHeightofThisLine=0;
//        //子view的总数
//        int childCount=getChildCount();
//        for (int i = 0; i <childCount ; i++) {
//            View child=getChildAt(i);
//            //子view可见
//            if (child.getVisibility()!=GONE){
//                int childWidhtUsed=0;
//                int childHeightUsed=0;
//                measureChild(child,widthMeasureSpec,heightMeasureSpec);
//                childWidhtUsed+=child.getMeasuredWidth();
//                childHeightUsed+=child.getMeasuredHeight();
//
//                LayoutParams childLayoutParams=child.getLayoutParams();
//                MarginLayoutParams marginLayoutParams= (MarginLayoutParams) childLayoutParams;
//
//                childWidhtUsed+=marginLayoutParams.leftMargin+marginLayoutParams.rightMargin;
//                childHeightUsed+=marginLayoutParams.topMargin+marginLayoutParams.bottomMargin;
//
//                if (widthUsed+childWidhtUsed<widthSpceSize){
//                    widthUsed+=childHeightUsed;
//                    if (childHeightUsed>childMaxHeightofThisLine){
//                        childMaxHeightofThisLine=childHeightUsed;
//                    }
//                }else {
//                    heightUsed+=childMaxHeightofThisLine+verticalSpacing;
//                    widthUsed=paddingLeft+paddingRight+childWidhtUsed;
//                    childMaxHeightofThisLine=childHeightUsed;
//                }
//            }
//        }
//        heightUsed+=childMaxHeightofThisLine;
//        setMeasuredDimension(widthUsed,heightUsed);
//    }
//
//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        int paddingLeft=getPaddingLeft();
//        int paddingRight=getPaddingRight();
//        int paddingTop=getPaddingTop();
//        int paddingBottom=getPaddingBottom();
//
//        int childStartLayoutX=paddingLeft;
//        int childStartLayoutY=paddingTop;
//
//        int widthUsed = paddingLeft + paddingRight;
//
//        int childMaxHeight = 0;
//
//        int childCount=getChildCount();
//        for (int i = 0; i <childCount ; i++) {
//            View child=getChildAt(i);
//            int childNeededWidth,childNeededHeight;
//            int left,top,right,bottom;
//            int childMeasureWidth=child.getMeasuredWidth();
//            int childMeasureHeight=child.getMeasuredHeight();
//            LayoutParams childLayoutParams=child.getLayoutParams();
//            MarginLayoutParams childLayoutMargin= (MarginLayoutParams) childLayoutParams;
//            int childLeftMargin=childLayoutMargin.leftMargin;
//            int childTopMargin=childLayoutMargin.topMargin;
//            int childRightMargin=childLayoutMargin.rightMargin;
//            int childBottomMargin=childLayoutMargin.bottomMargin;
//
//            childNeededHeight=childTopMargin+childBottomMargin+childMeasureHeight;
//            childNeededWidth=childLeftMargin+childRightMargin+childMeasureWidth;
//
//            if (widthUsed+childNeededWidth<=r-1){
//                if (childNeededHeight>childMaxHeight){
//                    childMaxHeight=childNeededHeight;
//                }
//                left=childStartLayoutX+childLeftMargin;
//                top=childStartLayoutY+childTopMargin;
//                right=left+childRightMargin;
//                bottom=top+childBottomMargin;
//                widthUsed+=childMeasureWidth;
//                childStartLayoutX+=childNeededWidth;
//            }else{
//                childStartLayoutY+=childMaxHeight+verticalSpacing;
//                childStartLayoutX=paddingLeft;
//                widthUsed=paddingLeft+paddingRight;
//                left = childStartLayoutX + childLeftMargin;
//                top = childStartLayoutY + childTopMargin;
//                right = left + childMeasureWidth;
//                bottom = top + childMeasureHeight;
//                widthUsed += childNeededWidth;
//                childStartLayoutX += childNeededWidth;
//                childMaxHeight = childNeededHeight;
//            }
//            child.layout(left,top,right,bottom);
//        }
//    }
}
