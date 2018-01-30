package com.yankang.androidanimexamples.Transitions.CustomTransitions;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.Log;
import android.view.ViewGroup;

/**
 * Created by yankang on 2018/1/27.
 */

@TargetApi(19)
public class ColorTransition extends Transition
{

    private final String COLOR_VALUE = "com.yankang.colorTransition:backgroundColor";

    private void captureValues(TransitionValues values)
    {
        Drawable drawable = values.view.getBackground();
        if (drawable instanceof ColorDrawable)
        {
            values.values.put(COLOR_VALUE , ((ColorDrawable) drawable).getColor());
        }
    }

    @Override
    public void captureStartValues(TransitionValues transitionValues)
    {
        captureValues(transitionValues);
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues)
    {
        captureValues(transitionValues);
    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues)
    {
        if (startValues.values == null || endValues.values == null) return null;

        int startColor = (int) startValues.values.get(COLOR_VALUE);
        int endColor = (int) endValues.values.get(COLOR_VALUE);
        if (startColor != endColor)
        {
            Log.e("startColor", Integer.toHexString(startColor));
            Log.e("endColor", Integer.toHexString(endColor));

            return ObjectAnimator.ofObject(endValues.view, "BackgroundColor"
                    , new ArgbEvaluator(), startColor, endColor);
        }
        return null;
    }
}
