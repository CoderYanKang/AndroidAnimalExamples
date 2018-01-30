package com.yankang.androidanimexamples.Evaluators;

import android.animation.TypeEvaluator;

/**
 * Created by yankang on 2018/1/25.
 */

public class PointEvaluator implements TypeEvaluator<Point>
{

    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue)
    {
        float currentX = startValue.getX() + fraction * (float) Math.PI * 3 * (endValue.getX() - startValue.getX());
        float currentY = startValue.getY() * ((float) Math.sin(fraction * Math.PI * 3) + 1);

        return new Point(currentX , currentY);
    }
}
