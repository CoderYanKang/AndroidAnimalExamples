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

public class SceneChangeActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_scene_transition_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.scene_fade)
    public void sceneFade(){

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container , new SceneFadeFragment())
                .addToBackStack(null).commit();
    }

    @OnClick(R.id.scene_explode)
    public void sceneExplode(){

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container , new SceneExplodeFragment())
                .addToBackStack(null).commit();
    }

    @OnClick(R.id.scene_slide)
    public void sceneSlide(){

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container , new SceneSlideFragment())
                .addToBackStack(null).commit();
    }



}
