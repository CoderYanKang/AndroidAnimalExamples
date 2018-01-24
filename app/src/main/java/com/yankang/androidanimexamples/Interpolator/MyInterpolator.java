package com.yankang.androidanimexamples.Interpolator;

import android.util.Log;
import android.view.animation.Interpolator;

/**
 * Created by yankang on 2018/1/23.
 * 插值器用于控制动画支持的加速度 ，根据getInterpolation（）返回的数据变化加速度。函数的导数
 */

public class MyInterpolator implements Interpolator
{
    @Override
    public float getInterpolation(float v)
    {
        Log.e("MyInterpolator" , "input: " + v);
        Log.e("MyInterpolator" , "value: " + (float) Math.cos(v*Math.PI));
        return (float) Math.sin(v*Math.PI);
    }

}
