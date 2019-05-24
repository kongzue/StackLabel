package com.kongzue.stacklabelview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
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
public class StackLayout extends RelativeLayout {
    
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
        Log.d(">>>", "maxWidth: " + maxWidth);
        
        items = new ArrayList<>();
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == VISIBLE) {
                items.add(getChildAt(i));
            }
        }
        
        newHeight = 0;
        if (items != null && !items.isEmpty()) {
            for (int i = 0; i < items.size(); i++) {
                View item = items.get(i);
                
                int n_x = 0;
                int n_y = 0;
                int o_y = 0;
                
                if (i != 0) {
                    n_x = (int) items.get(i - 1).getX() + items.get(i - 1).getMeasuredWidth() + itemMargin;
                    n_y = (int) items.get(i - 1).getY() + items.get(i - 1).getMeasuredHeight() + itemMargin;
                    o_y = (int) items.get(i - 1).getY();
                }
                
                if (n_x + item.getMeasuredWidth() > maxWidth) {
                    n_x = 0;
                    o_y = n_y;
                }
                
                item.setY(o_y);
                item.setX(n_x);
                
                newHeight = (int) (item.getY() + item.getMeasuredHeight());
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
