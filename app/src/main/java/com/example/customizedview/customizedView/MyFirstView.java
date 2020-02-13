package com.example.customizedview.customizedView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.customizedview.R;


public class MyFirstView extends View {
    private boolean mShowText;
    private int textPos;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public MyFirstView(Context context) {
        super(context);
        initPaint();
    }

    // This constructor interface is necessary to build a customized view
    public MyFirstView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
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
        int minw = getPaddingLeft() + getPaddingRight() + 500;
        int w = resolveSizeAndState(5000, widthMeasureSpec, 0);
        int minh = getPaddingBottom() + getPaddingTop() + 700;
        int h = resolveSizeAndState(5000, heightMeasureSpec, 0);
        setMeasuredDimension(w, h);
        /**
         *  resolveSizeAndState():
         *      The first parameter is the minimum size of the view, it may not be more smaller than the first parameter,
         *      but if the first parameter is bigger than the size given by MeasureSpec, then the size will be set to match MeasureSpec.
         */
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // This method is used to draw the item inside the view.
        // Before codding this method, you must create some Paint first.
        // Never init the Paint object here, it will make app work slow.
        super.onDraw(canvas);

        float left =  getLeft();
        float right = getRight();
        float top = getTop();
        float bottom = getBottom();
        canvas.drawRect(left, top, right, bottom, paint);
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

    private void initPaint() {
        paint.setColor(Color.parseColor("#FF4081"));
    }
}
