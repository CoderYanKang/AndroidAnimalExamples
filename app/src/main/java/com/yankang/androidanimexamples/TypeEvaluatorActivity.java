package com.yankang.androidanimexamples;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.yankang.androidanimexamples.Evaluators.ColorEvaluator;
import com.yankang.androidanimexamples.Evaluators.MyImageView;
import com.yankang.androidanimexamples.Evaluators.Point;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yankang on 2018/1/25.
 */

public class TypeEvaluatorActivity extends AppCompatActivity {

    @BindView(R.id.image)
    MyImageView image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_type_evaluator_layout);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.argb_evaluator , R.id.color_evaluator
            , R.id.point_evaluator , R.id.point_evaluator2})
    public void goEvaluator(View view)
    {
        ObjectAnimator objectAnimator = null;
        switch (view.getId())
        {
            default:
                break;
            case R.id.argb_evaluator:
                objectAnimator = ObjectAnimator.ofObject(image
                        , "BackgroundColor"
                        , new ArgbEvaluator()
                        , 0xffff00ff , 0xff0000ff , 0xffE5E5E5);
                break;

            case R.id.color_evaluator:

                objectAnimator = ObjectAnimator.ofObject(image , "color"
                        , new ColorEvaluator()
                        , "#ff0000" , "#0000ff" , "#00ff00");
                break;

            case R.id.point_evaluator:

                image.startMoveByOne(new Point(200 , 400));

                break;

            case R.id.point_evaluator2:

                image.startMoveByTwo(new Point(200 , 400));

                break;
        }

        if (objectAnimator != null)
        {
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimator.setDuration(5000);
            objectAnimator.start();
        }
    }
}
