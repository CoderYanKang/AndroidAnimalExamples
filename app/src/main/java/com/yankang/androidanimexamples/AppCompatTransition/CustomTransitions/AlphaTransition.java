package com.yankang.androidanimexamples.AppCompatTransition.CustomTransitions;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

import com.transitionseverywhere.Transition;
import com.transitionseverywhere.TransitionValues;
import com.transitionseverywhere.utils.FloatProperty;

/**
 * Created by yankang on 2018/1/29.
 */

public class AlphaTransition extends Transition
{

    private final String PROPERTY_ALPHA_KEY = "android.yankang.transition:alpha";

    private final static Property<View , Float> ALPAH_PRORERTY = new FloatProperty<View>() {
        @Override
        public void setValue(View object, float value)
        {
            object.setAlpha(value);
        }

        @Override
        public Float get(View object) {
            return object.getAlpha();
        }
    };

    private void captureValues(TransitionValues transitionValues)
    {
        transitionValues.values.put(PROPERTY_ALPHA_KEY , transitionValues.view.getAlpha());
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
        float  startAlpha = (float) startValues.values.get(PROPERTY_ALPHA_KEY);
        float  endAlpha = (float) endValues.values.get(PROPERTY_ALPHA_KEY);

        return  ObjectAnimator.ofFloat(endValues.view , ALPAH_PRORERTY , startAlpha , endAlpha);
    }
}
