package com.example.customizedview.customizedView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.customizedview.R;


public class MyFirstView extends View {
    private boolean mShowText;
    private int textPos;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);

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
        // widthMeasureSpec and heightMeasureSpec are the size given by parent view,
        // which is the size that parent doesn't want to be exceeded
        int minw = getPaddingLeft() + getPaddingRight() + 500;
        int w = resolveSizeAndState(500, widthMeasureSpec, 0);
        int minh = getPaddingBottom() + getPaddingTop() + 700;
        int h = resolveSizeAndState(500, heightMeasureSpec, 0);
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

        // Draw a Rectangle
//        float left =  getLeft();
//        float right = getRight();
//        float top = getTop();
//        float bottom = getBottom();
//        canvas.drawRect(left, top, right, bottom, paint);

        // Draw a Circle
//        float width = getWidth();
//        float height = getHeight();
//        float radius = Math.min(width, height) / 2;
//        canvas.drawCircle(width / 2, height / 2, radius, paint);

        // Draw a Arc
//        float limit = Math.min(getWidth(), getHeight());
//        RectF rectf = new RectF(0f, 0f, limit, limit);
//        canvas.drawArc(rectf, 0, 60, true, paint);
//        canvas.drawArc(rectf, 60, 103, true, paint2);

        // Draw a picture(bmp)
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
//        float width = (getWidth() - bitmap.getWidth()) / 2;
//        float height = (getHeight() - bitmap.getHeight()) / 2;
//        canvas.drawBitmap(bitmap, width, height, paint);

        // Draw a text
//        canvas.drawText("HelloWorld", 0f, 100f, paint);

        // Draw a path
        Path p = new Path();
        p.moveTo(100, 100);
        p.lineTo(200, 50);
        p.lineTo(300, 100);
        p.lineTo(200, 400);
        canvas.drawPath(p, paint);
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
        paint.setTextSize(90f);
        paint2.setColor(Color.parseColor("#FF3347"));
    }
}
