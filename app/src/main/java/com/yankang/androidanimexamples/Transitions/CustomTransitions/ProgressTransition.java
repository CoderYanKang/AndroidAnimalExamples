package com.yankang.androidanimexamples.Transitions.CustomTransitions;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.IntProperty;
import android.util.Property;
import android.view.ViewGroup;
import android.widget.ProgressBar;

/**
 * Created by yankang on 2018/1/29.
 */

@TargetApi(19)
public class ProgressTransition extends Transition
{

    private final String PROGRESS_KEY_VALUE = "com.yankang.transition:progress";
    private static final Property<ProgressBar , Integer> PROGRESS_BAR_PROPERTY = new IntProperty<ProgressBar>("") {
        @Override
        public void setValue(ProgressBar object, int value) {
                object.setProgress(value);
        }
        @Override
        public Integer get(ProgressBar object) {
            return object.getProgress();
        }
    };

    private void captureValues(TransitionValues transitionValues)
    {
        if (transitionValues.view instanceof ProgressBar)
        {
            transitionValues.values.put(PROGRESS_KEY_VALUE , ((ProgressBar) transitionValues.view).getProgress());
        }
    }

    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues)
    {
        if (!(startValues.view instanceof ProgressBar) || !(endValues.view instanceof ProgressBar))
            return null;
        int startProgress = (int) startValues.values.get(PROGRESS_KEY_VALUE);
        int endProgress = (int) endValues.values.get(PROGRESS_KEY_VALUE);

        return ObjectAnimator.ofInt((ProgressBar) endValues.view , PROGRESS_BAR_PROPERTY , startProgress , endProgress);
    }

}
