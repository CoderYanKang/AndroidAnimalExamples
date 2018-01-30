package com.yankang.androidanimexamples.Transitions;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.ArcMotion;
import android.transition.AutoTransition;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.yankang.androidanimexamples.R;
import com.yankang.androidanimexamples.Transitions.CustomTransitions.ColorTransition;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by yankang on 2018/1/26.
 */

public class ChangeBoundsFragment extends Fragment
{

    @BindView(R.id.icon)
    ImageView icon;
    Unbinder unbinder;
    @BindView(R.id.container)
    FrameLayout container;

    private int[] colors = {Color.RED , Color.BLACK , Color.BLUE , Color.CYAN , Color.GRAY};
    private int posi = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_change_bounds_layout, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.change_bounds_1)
    public void changeBounds()
    {
        goTransition(new ChangeBounds() , new BounceInterpolator() , false);
    }

    @OnClick(R.id.auto_transition)
    public void autoTransition()
    {
        goTransition(new AutoTransition() , new AnticipateOvershootInterpolator() , false);
    }

    @OnClick(R.id.path_motion)
    public void pathMotion()
    {
        TransitionSet set = new TransitionSet();
        ChangeBounds autoTransition = new ChangeBounds();
        autoTransition.setPathMotion(new ArcMotion());
        set.addTransition(autoTransition);
        set.addTransition(new ColorTransition());
        goTransition(set , new AccelerateDecelerateInterpolator() , true);
    }

    private void goTransition(Transition transition, Interpolator interpolator , boolean isChange)
    {
        transition.setDuration(2000L);
        transition.setInterpolator(interpolator);
        TransitionManager.beginDelayedTransition(container , transition);
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) icon.getLayoutParams();
        if ((params.gravity & Gravity.TOP )== Gravity.TOP)
        {
            params.gravity = Gravity.BOTTOM|Gravity.END;
            params.width = 100;
            params.height = 100;
        }
        else
        {
            params.gravity = Gravity.TOP|Gravity.START;
            params.width = 300;
            params.height = 300;
        }

        icon.setLayoutParams(params);

        if (isChange)
        {
            icon.setBackgroundColor(colors[posi % colors.length]);
            posi++;
        }
    }

}
