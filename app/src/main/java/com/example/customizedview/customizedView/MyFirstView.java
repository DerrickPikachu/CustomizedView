package com.example.customizedview.customizedView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.example.customizedview.R;


public class MyFirstView extends View {
    private boolean mShowText;
    private int textPos;

    public MyFirstView(Context context) {
        super(context);
    }

    // This constructor interface is necessary to build a customized view
    public MyFirstView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.MyFirstView,
                0, 0);

        try {
            mShowText = a.getBoolean(R.styleable.MyFirstView_showText, false);
            textPos = a.getInteger(R.styleable.MyFirstView_labelPosition, 0);
        } finally {
            a.recycle();
        }
    }

//    @Override
//    protected void onSizeChanged(){}
//    This is the method to measure the size of the view, but onMeasure() is finer.

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // This method is used to measure the width and height of the view
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // This method is used to draw the item inside the view.
        // Before codding this method, you must create some Paint first.
        // Never init the Paint object here, it will make app work slow.
    }

    public boolean isShowTest() {
        return mShowText;
    }

    public void setShowText(boolean showText) {
        mShowText = showText;
        // invalidate and requestLayout must be called after any modified of attribute
        // do this to let the system redraw the view
        invalidate();
        requestLayout();
    }
}
