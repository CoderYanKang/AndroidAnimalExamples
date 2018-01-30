package com.yankang.androidanimexamples.Evaluators;

import android.animation.TypeEvaluator;

/**
 * Created by yankang on 2018/1/25.
 */

public class ColorEvaluator implements TypeEvaluator<String>
{

    @Override
    public String evaluate(float fraction, String startValue, String endValue)
    {
        int startRed = Integer.parseInt(startValue.substring(1, 3), 16);
        int startGreen = Integer.parseInt(startValue.substring(3, 5), 16);
        int startBlue = Integer.parseInt(startValue.substring(5, 7), 16);

        int endRed = Integer.parseInt(endValue.substring(1, 3), 16);
        int endGreen = Integer.parseInt(endValue.substring(3, 5), 16);
        int endBlue = Integer.parseInt(endValue.substring(5, 7), 16);

        int diffRed = (int)(fraction * (endRed - startRed));
        int diffGreen = (int)(fraction * (endGreen - startGreen));
        int diffBlue = (int)(fraction * (endBlue - startBlue));

        int currentRed = startRed + diffRed;
        int currentGreen = startGreen + diffGreen;
        int currentBlue = startBlue + diffBlue;

        return "#" + getHexString(currentRed) + getHexString(currentGreen) + getHexString(currentBlue);
    }


    /**
     * 将10进制颜色值转换成16进制。
     */
    private String getHexString(int value)
    {
        String hexString = Integer.toHexString(value);
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        return hexString;
    }


}
