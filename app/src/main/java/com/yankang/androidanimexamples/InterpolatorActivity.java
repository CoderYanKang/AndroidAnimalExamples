package com.yankang.androidanimexamples;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import com.yankang.androidanimexamples.Interpolator.MyInterpolator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yankang on 2018/1/25.
 */

public class InterpolatorActivity extends AppCompatActivity
{

    @BindView(R.id.AccelerateInterpolator)
    TextView AccelerateInterpolator;
    @BindView(R.id.OvershootInterpolator)
    TextView OvershootInterpolator;
    @BindView(R.id.AccelerateDecelerateInterpolator)
    TextView AccelerateDecelerateInterpolator;
    @BindView(R.id.AnticipateInterpolator)
    TextView AnticipateInterpolator;
    @BindView(R.id.AnticipateOvershootInterpolator)
    TextView AnticipateOvershootInterpolator;
    @BindView(R.id.BounceInterpolator)
    TextView BounceInterpolator;
    @BindView(R.id.CycleInterpolator)
    TextView CycleInterpolator;
    @BindView(R.id.DecelerateInterpolator)
    TextView DecelerateInterpolator;
    @BindView(R.id.LinearInterpolator)
    TextView LinearInterpolator;
    @BindView(R.id.MyInterpolator)
    TextView MyInterpolator;


    private List<ObjectAnimator> animatorList = new ArrayList<>();
    private List<TextView> textViews = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_interpolator_layout);
        ButterKnife.bind(this);
        initView();
    }


    /**
     * 开始
     */
    @OnClick(R.id.start)
    public void toStart()
    {
        for (ObjectAnimator animator : animatorList)
        {
            animator.start();
        }
    }

    private void initView()
    {
        textViews.add(AccelerateInterpolator);
        textViews.add(OvershootInterpolator);
        textViews.add(AccelerateDecelerateInterpolator);
        textViews.add(AnticipateInterpolator);
        textViews.add(AnticipateOvershootInterpolator);
        textViews.add(BounceInterpolator);
        textViews.add(CycleInterpolator);
        textViews.add(DecelerateInterpolator);
        textViews.add(LinearInterpolator);
        textViews.add(MyInterpolator);

        for (int i = 0; i < 10 ; i++)
        {
            ObjectAnimator animator = ObjectAnimator.ofFloat(textViews.get(i) , "translationX" , 0f , 500f);
            animator.setInterpolator(getInterPolator(i));
            animator.setDuration(3000);
            animatorList.add(animator);
        }
    }


    /**
     * 获得插值器
     *
     * @param interPolatorPosi
     */
    private Interpolator getInterPolator(int interPolatorPosi) {

        Interpolator interpolator = null;
        switch (interPolatorPosi) {
            default:
            case Constant.INTERPOLATOR_ACEELERATE:

                interpolator = new AccelerateInterpolator();
                break;
            case Constant.INTERPOLATOR_OVERSHOOT:
                interpolator = new OvershootInterpolator();
                break;

            case Constant.INTERPOLATOR_ACCELERATE_DECELERATE:
                interpolator = new AccelerateDecelerateInterpolator();
                break;

            case Constant.INTERPOLATOR_ANTICIPATE:
                interpolator = new AnticipateInterpolator();
                break;

            case Constant.INTERPOLATOR_ANTICITPATE_OVERSHOOT:
                interpolator = new AnticipateOvershootInterpolator();
                break;

            case Constant.INTERPOLATOR_BOUNCE:
                interpolator = new BounceInterpolator();
                break;

            case Constant.INTERPOLATOR_CYCLE:
                interpolator = new CycleInterpolator(2f);
                break;

            case Constant.INTERPOLATOR_DECELERATE:
                interpolator = new DecelerateInterpolator();
                break;

            case Constant.INTERPOLATOR_LINEAR:
                interpolator = new LinearInterpolator();
                break;

            case Constant.INTERPOLATOR_CUSTOM:
                interpolator = new MyInterpolator();
                break;
        }

        return interpolator;
    }

}
