package com.kongzue.stacklabelview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: @Kongzue
 * Github: https://github.com/kongzue/
 * Homepage: http://kongzue.com/
 * Mail: myzcxhh@live.cn
 * CreateTime: 2019/4/15 01:13
 */
public class StackLayout extends ViewGroup {
    
    private Context context;
    private int itemMargin = 0;
    
    public StackLayout(Context context) {
        super(context);
        this.context = context;
    }
    
    public StackLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        loadAttrs(context, attrs);
    }
    
    public StackLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        loadAttrs(context, attrs);
    }
    
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    
    }
    
    private void loadAttrs(Context context, AttributeSet attrs) {
        try {
            //默认值
            itemMargin = dp2px(4);
            
            //加载值
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.StackLabel);
            itemMargin = typedArray.getDimensionPixelOffset(R.styleable.StackLabel_itemMargin, itemMargin);
            typedArray.recycle();
        } catch (Exception e) {
        }
    }
    
    private List<View> items;
    private int newHeight = 0;
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        
        refreshViews();
        
        setMeasuredDimension(getMeasuredWidth(), newHeight);//设置宽高
    }
    
    private void refreshViews() {
        int maxWidth = getMeasuredWidth();
        
        items = new ArrayList<>();
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == VISIBLE) {
                items.add(getChildAt(i));
            }
        }
        
        newHeight = 0;
        if (items != null && !items.isEmpty()) {
            int l = 0, t = 0, r = 0, b = 0;
            for (int i = 0; i < items.size(); i++) {
                View item = items.get(i);
                
                int mWidth = View.MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);           //AT_MOST：先按照最大宽度计算，如果小于则按实际值，如果大于，按最大宽度
                int mHeight = View.MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);         //UNSPECIFIED：不确定，根据实际情况计算
                item.measure(mWidth, mHeight);
                
                int childWidth = item.getMeasuredWidth();
                int childHeight = item.getMeasuredHeight();
                
                if ((l + childWidth) > maxWidth) {
                    l = 0;
                    t = t + childHeight + itemMargin;
                }
                
                r = l + childWidth ;
                
                if (childWidth > maxWidth) {
                    r = maxWidth;
                }
                
                b = t + childHeight;
                
                item.layout(l, t, r, b);
                
                l = l + childWidth + itemMargin;
                
                newHeight = t + childHeight;
            }
        }
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
    
    private int dp2px(float dpValue) {
        return (int) (0.5f + dpValue * Resources.getSystem().getDisplayMetrics().density);
    }
}
