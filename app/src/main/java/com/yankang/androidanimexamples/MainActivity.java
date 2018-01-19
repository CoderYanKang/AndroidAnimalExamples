package com.yankang.androidanimexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_to_tween)
    Button btnToTween;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_to_tween)
    public void toTween() {
        startActivity(new Intent(this, TweenActivity.class));
    }

    @OnClick(R.id.btn_to_frame)
    public void toFrame() {

    }

}
