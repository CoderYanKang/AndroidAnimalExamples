package com.yankang.androidanimexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yankang on 2018/1/19.
 */

public class TweenActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{

    private final int TWEEN_XML = 123;
    private final int TWEEN_JAVA = 234;

    @BindView(R.id.animal_view)
    ImageView animalView;
    @BindView(R.id.choice_interpolator)
    Spinner choiceInterpolator;
    @BindView(R.id.choice_way)
    Button choiceWay;

    private int[] translateAnimal = new int[]{
            R.anim.translate_anim_accelerate, R.anim.translate_anim_overshoot
            , R.anim.translate_anim_accelerate_decelerate, R.anim.translate_anim_anticipate
            , R.anim.translate_anim_anticipate_overshoot, R.anim.translate_anim_bounce
            , R.anim.translate_anim_cycle, R.anim.translate_anim_decelerate
            , R.anim.translate_anim_linear, R.anim.translate_anim_linear};

    private int posi = 0;
    private int nowType = TWEEN_XML;
    private boolean isFillAfter = true;
    private boolean isShareInterPolator = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_tween_animal_layout);
        ButterKnife.bind(this);
        initView();
    }

    @OnClick({R.id.go_translate, R.id.go_scale , R.id.go_alpha , R.id.go_rotate})
    public void transAnimal(View view) {
        startAnimal(view.getId(), nowType, posi);
    }

    @OnClick(R.id.choice_way)
    public void changeWay()
    {
        if (nowType == TWEEN_XML)
        {
            nowType = TWEEN_JAVA;
            choiceWay.setText("JAVA");
        }
        else
        {
            nowType = TWEEN_XML;
            choiceWay.setText("XML");
        }
    }

    @OnClick(R.id.fill_after)
    public void toFillAfter()
    {
        isFillAfter = !isFillAfter;
    }

    @OnClick(R.id.use_animal_set)
    public void goAnimalSet()
    {
        startAnimalSet(isShareInterPolator);
    }

    @OnClick(R.id.use_share_interpolator)
    public void AnimationSetShareInterPolator()
    {
        isShareInterPolator = !isShareInterPolator;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        this.posi = i;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    private void initView() {
        choiceInterpolator.setOnItemSelectedListener(this);
    }


    private void startAnimal(int btnId, int doType, int posi) {
        Animation tweenAnimal = null;

        switch (btnId) {
            default:
            case R.id.go_translate:

                if (doType == TWEEN_XML) {
                    tweenAnimal = AnimationUtils.loadAnimation(this, translateAnimal[posi]);
                } else {
                    tweenAnimal = new TranslateAnimation(0, 400, 0, 400);
                    tweenAnimal.setInterpolator(getInterplotar(posi));
                }

                break;

            case R.id.go_alpha:

                if (doType == TWEEN_XML)
                {
                    tweenAnimal = AnimationUtils.loadAnimation(this , R.anim.alpha_anim);
                }
                else
                {
                    tweenAnimal = new AlphaAnimation(1f , 0f);
                }

                tweenAnimal.setInterpolator(getInterplotar(posi));
                break;

            case R.id.go_scale:

                if (doType == TWEEN_XML) {
                    tweenAnimal = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
                } else {
                    tweenAnimal = new ScaleAnimation(1, 0.5f, 1, 0.5f);
                }

                tweenAnimal.setInterpolator(getInterplotar(posi));

                break;

            case R.id.go_rotate:

                if (doType == TWEEN_XML) {
                    tweenAnimal = AnimationUtils.loadAnimation(this, R.anim.roate_anim);
                } else {
                    tweenAnimal = new RotateAnimation(0f, 360f, 100f, 100f);
                }

                tweenAnimal.setInterpolator(getInterplotar(posi));
                break;
        }

        tweenAnimal.setFillAfter(isFillAfter);
        tweenAnimal.setDuration(1000);
        animalView.startAnimation(tweenAnimal);
    }

    private Interpolator getInterplotar(int posi)
    {
        Interpolator interpolator;
        switch (posi) {
            default:
            case 0:

                interpolator = new AccelerateInterpolator();

                break;

            case 1:
                interpolator = new OvershootInterpolator();

                break;

            case 2:
                interpolator = new AccelerateDecelerateInterpolator();

                break;

            case 3:
                interpolator = new AnticipateInterpolator();

                break;

            case 4:
                interpolator = new AnticipateOvershootInterpolator();

                break;

            case 5:
                interpolator = new BounceInterpolator();

                break;

            case 6:
                interpolator = new CycleInterpolator(2);

                break;

            case 7:
                interpolator = new DecelerateInterpolator();

                break;

            case 8:
                interpolator = new LinearInterpolator();
                break;

            case 9:
                interpolator = new LinearInterpolator();
                break;
        }

        return interpolator;
    }

    private void startAnimalSet(boolean isShareInterPolator)
    {
        AnimationSet animationSet = null;
        if (nowType == TWEEN_JAVA)
        {
            animationSet = new AnimationSet(isShareInterPolator);

            TranslateAnimation translateAnimation = new TranslateAnimation(0f, 200f, 0f, 200f);
            translateAnimation.setDuration(2000);
            if (!isShareInterPolator) translateAnimation.setInterpolator(getInterplotar(1));

            RotateAnimation rotateAnimation = new RotateAnimation(0, 180, 0, 0);
            rotateAnimation.setDuration(4000);
            if (!isShareInterPolator) translateAnimation.setInterpolator(getInterplotar(6));

            ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 0.2f, 1f, 0.2f);
            scaleAnimation.setDuration(2000);
            if (!isShareInterPolator) translateAnimation.setInterpolator(getInterplotar(7));

            AlphaAnimation alphaAnimation = new AlphaAnimation(1f, 0.3f);
            alphaAnimation.setDuration(2000);
            if (!isShareInterPolator) translateAnimation.setInterpolator(getInterplotar(5));

            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(rotateAnimation);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(alphaAnimation);
            animationSet.setFillAfter(isFillAfter);
            animalView.startAnimation(animationSet);
        }
        else
        {
            Animation animation = AnimationUtils.loadAnimation(this , R.anim.tween_set);
            animation.setFillAfter(isFillAfter);
            animation.setDuration(3000);
            animalView.startAnimation(animation);
        }
    }

}
