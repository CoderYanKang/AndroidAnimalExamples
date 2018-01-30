package com.yankang.androidanimexamples.Evaluators;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by yankang on 2018/1/25.
 */

public class MyImageView extends AppCompatImageView
{

    private String color;
    private float defaultPosiX = 100;
    private float defaultPosiY = 400;
    private float defaultRadius = 50;
    private Paint paint;
    private Point currentPoint;

    public MyImageView(Context context)
    {
        super(context);
        initDraw();
    }

    public MyImageView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initDraw();
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        initDraw();
    }

    public void setColor(String color)
    {
        this.color = color;
        int red = Integer.parseInt(color.substring(1, 3), 16);
        int green = Integer.parseInt(color.substring(3, 5), 16);
        int blue = Integer.parseInt(color.substring(5, 7), 16);
        paint.setColor(Color.rgb(red , green , blue));
        invalidate();
    }

    public String getColor()
    {
        return color;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawCircle(currentPoint.getX() , currentPoint.getY() , defaultRadius , paint);
    }

    public void startMoveByOne(Point toPoint)
    {
        ObjectAnimator animator = ObjectAnimator.ofObject(this , "currentPoint"
                , new PointEvaluator() , new Point(defaultPosiX , defaultPosiY) ,toPoint);

        animator.setDuration(5000);
        animator.start();
    }

    public void startMoveByTwo(Point toPoint)
    {
        ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator() , currentPoint , toPoint);
        animator.setDuration(5000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                currentPoint = (Point) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.start();
    }


    public Point getCurrentPoint()
    {
        return currentPoint;
    }

    public void setCurrentPoint(Point currentPoint)
    {
        this.currentPoint = currentPoint;
        invalidate();
    }

    private void initDraw()
    {
        currentPoint = new Point(defaultPosiX , defaultPosiY);
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
    }
}
