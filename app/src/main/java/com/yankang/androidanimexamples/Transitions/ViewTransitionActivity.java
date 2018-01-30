package com.yankang.androidanimexamples.Transitions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yankang.androidanimexamples.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yankang on 2018/1/26.
 */

public class ViewTransitionActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_view_transition_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.change_bounds)
    public void sceneFade(){

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container , new ChangeBoundsFragment())
                .addToBackStack(null).commit();
    }

    @OnClick(R.id.change_clip_bounds)
    public void changeClip(){

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container , new ChangeClipBoundsFragment())
                .addToBackStack(null).commit();
    }

    @OnClick(R.id.change_image_transform)
    public void changeImage(){

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container , new ChangeImageTransformFragment())
                .addToBackStack(null).commit();
    }


    @OnClick(R.id.change_transform)
    public void changeTransform(){

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container , new ChangeTransformFragment())
                .addToBackStack(null).commit();
    }

    @OnClick(R.id.change_scroll)
    public void changeScroll(){

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container , new ChangeScrollFragment())
                .addToBackStack(null).commit();
    }

    @OnClick(R.id.transition_set)
    public void transitionSet(){

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container , new TransitionSetFragment())
                .addToBackStack(null).commit();
    }

    @OnClick(R.id.transition_custom)
    public void customTransition()
    {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container , new CustomTransitionFragment())
                .addToBackStack(null).commit();
    }

}
