package com.kongzue.stacklabelview.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * @author: Kongzue
 * @github: https://github.com/kongzue/
 * @homepage: http://kongzue.com/
 * @mail: myzcxhh@live.cn
 * @createTime: 2019/10/17 21:47
 */
public class LabelConstraint extends LinearLayout {
    
    private float mMaxHeight = -1f;// 优先级低
    private float mMaxWidth = -1f;// 优先级低
    
    public LabelConstraint(Context context) {
        super(context);
    }
    
    public LabelConstraint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    
    public LabelConstraint(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        
        int maxHeightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize <= mMaxHeight ? heightSize : (int) mMaxHeight, heightMode);
        
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        
        int maxWidthMeasureSpec = MeasureSpec.makeMeasureSpec(widthSize <= mMaxWidth ? widthSize : (int) mMaxWidth, widthMode);
        
        super.onMeasure(maxWidthMeasureSpec, maxHeightMeasureSpec);
    }
    
    public float getmMaxHeight() {
        return mMaxHeight;
    }
    
    public LabelConstraint setmMaxHeight(float mMaxHeight) {
        this.mMaxHeight = mMaxHeight;
        return this;
    }
    
    public float getmMaxWidth() {
        return mMaxWidth;
    }
    
    public LabelConstraint setmMaxWidth(float mMaxWidth) {
        this.mMaxWidth = mMaxWidth;
        return this;
    }
}
