package com.yankang.androidanimexamples.AppCompatTransition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yankang.androidanimexamples.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yankang on 2018/1/27.
 * https://github.com/andkulikov/Transitions-Everywhere
 */

public class AppCompatTransitionActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_appcompat_transition_layout);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.change_slide , R.id.change_bounds
            , R.id.change_clip_bounds , R.id.change_image_transform
            , R.id.change_transform , R.id.change_scroll
            , R.id.transition_set , R.id.transition_custom})
    public void goFrag(View view)
    {
        switch (view.getId())
        {
            case R.id.change_slide:

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container , new SlideFragment())
                        .commit();
                break;

            case R.id.change_bounds:

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container , new ChangeBoundsFragment())
                        .commit();
                break;


            case R.id.change_clip_bounds:

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container , new ChangeClipBoundsFragment())
                        .commit();
                break;

            case R.id.change_image_transform:

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container , new ChangeImageTransformFragment())
                        .commit();
                break;

            case R.id.change_transform:

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container , new ChangeTransfromFragment())
                        .commit();
                break;

            case R.id.change_scroll:

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container , new ChangeScrollFragment())
                        .commit();
                break;

            case R.id.transition_set:

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container , new TransitionSetFragment())
                        .commit();
                break;

            case R.id.transition_custom:

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container , new CustomTransitionFragment())
                        .commit();
                break;

            default:
                break;
        }
    }

}
