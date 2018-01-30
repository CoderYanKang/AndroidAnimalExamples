package com.yankang.androidanimexamples.Transitions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.yankang.androidanimexamples.R;
import com.yankang.androidanimexamples.Transitions.CustomTransitions.AlphaTransition;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by yankang on 2018/1/26.
 */

public class TransitionSetFragment extends Fragment
{


    @BindView(R.id.icon)
    ImageView icon;
    Unbinder unbinder;
    @BindView(R.id.container)
    FrameLayout container;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.frag_transition_set_layout, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick(R.id.transition_set_code)
    public void transtionSetCode()
    {

        TransitionSet set = new TransitionSet();
        set.addTransition(new ChangeBounds());
        set.addTransition(new ChangeImageTransform());
        set.addTransition(new AlphaTransition());
        set.setDuration(2000);

        TransitionManager.beginDelayedTransition(container , set);
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) icon.getLayoutParams();
        if (params.gravity == (Gravity.TOP|Gravity.LEFT)) {
            params.gravity = Gravity.BOTTOM | Gravity.RIGHT;
            params.width = 500;
            params.height = 500;
            icon.setScaleType(ImageView.ScaleType.CENTER_CROP);
            icon.setAlpha(1.f);
        }
        else
        {
            params.gravity = Gravity.TOP|Gravity.LEFT;
            params.width = 200;
            params.height = 200;
            icon.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            icon.setAlpha(0.1f);
        }

        icon.setLayoutParams(params);

    }

    @OnClick(R.id.transition_set_xml)
    public void transitionSetXml()
    {

        Transition transitionSet = TransitionInflater.from(getActivity()).inflateTransition(R.transition.transition_set);
        TransitionManager.beginDelayedTransition(container , transitionSet);
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) icon.getLayoutParams();
        if (params.gravity == (Gravity.TOP|Gravity.LEFT))
        {
            params.gravity = Gravity.BOTTOM|Gravity.RIGHT;
            params.width = 500;
            params.height = 500;
            icon.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        else
        {
            params.gravity = Gravity.TOP|Gravity.LEFT;
            params.width = 200;
            params.height = 200;
            icon.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }

        icon.setLayoutParams(params);

    }

}
