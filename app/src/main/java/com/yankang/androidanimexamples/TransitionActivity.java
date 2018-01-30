package com.yankang.androidanimexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yankang.androidanimexamples.AppCompatTransition.AppCompatTransitionActivity;
import com.yankang.androidanimexamples.Transitions.SceneChangeActivity;
import com.yankang.androidanimexamples.Transitions.ViewTransitionActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yankang on 2018/1/25.
 */

public class TransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_transition_layout);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.change_scene)
    public void toChangeScene() {
        startActivity(new Intent(this, SceneChangeActivity.class));
    }

    @OnClick(R.id.change_view_property)
    public void toViewTransition() {
        startActivity(new Intent(this, ViewTransitionActivity.class));
    }

    @OnClick(R.id.to_appcompat_transition)
    public void toAppCompatTransition()
    {
        startActivity(new Intent(this , AppCompatTransitionActivity.class));
    }

}
