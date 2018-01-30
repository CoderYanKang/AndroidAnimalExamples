package com.yankang.androidanimexamples.Transitions.CustomTransitions;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yankang on 2018/1/27.
 */
@TargetApi(19)
public class AlphaTransition extends Transition
{

    private final String ALPAHA_VALUE = "com.yankang.custom.transition:alpha_value";

//  capturevalue
    private void captureValues(TransitionValues transitionValues)
    {
        transitionValues.values.put(ALPAHA_VALUE , transitionValues.view.getAlpha());
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
        float startAlpha = (float) startValues.values.get(ALPAHA_VALUE);
        float endAlpha = (float) endValues.values.get(ALPAHA_VALUE);

//        return ObjectAnimator.ofFloat(startValues.view , "alpha" , startAlpha , endAlpha);
        return ObjectAnimator.ofFloat(startValues.view , View.ALPHA , startAlpha , endAlpha);
    }

}
