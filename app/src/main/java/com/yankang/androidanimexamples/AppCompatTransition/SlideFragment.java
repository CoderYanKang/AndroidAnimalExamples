package com.yankang.androidanimexamples.AppCompatTransition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.transitionseverywhere.Explode;
import com.transitionseverywhere.Fade;
import com.transitionseverywhere.Slide;
import com.transitionseverywhere.Transition;
import com.transitionseverywhere.TransitionManager;
import com.yankang.androidanimexamples.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by yankang on 2018/1/29.
 */

public class SlideFragment extends Fragment implements Transition.TransitionListener{


    @BindView(R.id.view_root)
    FrameLayout viewRoot;
    Unbinder unbinder;
    @BindView(R.id.iv_01)
    ImageView iv01;
    @BindView(R.id.iv_02)
    ImageView iv02;
    @BindView(R.id.iv_03)
    ImageView iv03;
    @BindView(R.id.iv_04)
    ImageView iv04;
    private ArrayList<ImageView> imageViews = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.frag_slide_fade_explode_layout, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        imageViews.add(iv01);
        imageViews.add(iv02);
        imageViews.add(iv03);
        imageViews.add(iv04);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.to_fade , R.id.to_slide , R.id.to_explode})
    public void toDo(View view)
    {
        switch (view.getId())
        {
            case R.id.to_fade:

                Fade fade = new Fade();
                fade.setDuration(1000);
                fade.addListener(this);
                fade.setInterpolator(new AnticipateOvershootInterpolator());
                TransitionManager.beginDelayedTransition(viewRoot , fade);

                break;

            case R.id.to_slide:

                Slide slide = new Slide(Gravity.RIGHT);
                slide.setDuration(1000);
                slide.addListener(this);
                slide.setInterpolator(new AccelerateDecelerateInterpolator());
                TransitionManager.beginDelayedTransition(viewRoot, slide);

                break;

            case R.id.to_explode:

                Explode explode = new Explode();
                explode.setDuration(1000);
                explode.addListener(this);
                explode.setInterpolator(new AnticipateInterpolator());
                TransitionManager.beginDelayedTransition(viewRoot , explode);

                break;
                default:
                    break;
        }

        for (ImageView imageView : imageViews)
        {
            if (imageView.getVisibility() == View.VISIBLE) {
                imageView.setVisibility(View.GONE);
            } else {
                imageView.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onTransitionStart(Transition transition) {
        Toast.makeText(getActivity() , "onTransitionStart" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTransitionEnd(Transition transition) {
        Toast.makeText(getActivity() , "onTransitionEnd" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTransitionCancel(Transition transition) {
        Toast.makeText(getActivity() , "onTransitionCancel" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTransitionPause(Transition transition) {
        Toast.makeText(getActivity() , "onTransitionPause" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTransitionResume(Transition transition) {
        Toast.makeText(getActivity() , "onTransitionResume" , Toast.LENGTH_SHORT).show();
    }
}
