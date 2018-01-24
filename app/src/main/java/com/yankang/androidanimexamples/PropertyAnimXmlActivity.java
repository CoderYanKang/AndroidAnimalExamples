package com.yankang.androidanimexamples;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.TimeInterpolator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.yankang.androidanimexamples.Interpolator.MyInterpolator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yankang on 2018/1/24.
 */

public class PropertyAnimXmlActivity extends AppCompatActivity {


    @BindView(R.id.act_property_property_value_tips)
    TextView actPropertyPropertyValueTips;
    @BindView(R.id.act_property_property_value)
    EditText actPropertyPropertyValue;
    @BindView(R.id.property_view)
    ImageView propertyView;
    @BindView(R.id.act_property_interpolator)
    Spinner actPropertyInterpolator;
    @BindView(R.id.act_property_property_name)
    Spinner actPropertyPropertyName;
    @BindView(R.id.act_property_go_value_animator)
    Button actPropertyGoValueAnimator;
    @BindView(R.id.act_property_animator_set)
    Button actPropertyAnimatorSet;

    private int interploatorPosi = 0;
    private int propertyPosi = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_property_anim_layout);
        ButterKnife.bind(this);

        initView();
    }


    @OnClick({R.id.act_property_go_object_animator
            , R.id.act_property_animator_set_together
            , R.id.act_property_animator_set_Sequentially})
    public void toClickView(View view) {
        switch (view.getId()) {
            default:
            case R.id.act_property_go_object_animator:

                loadAnimatorFormXml(propertyPosi);

                break;

            case R.id.act_property_animator_set_together:

                Animator animator = AnimatorInflater.loadAnimator(this , R.animator.property_anim_together_set);
                animator.setTarget(propertyView);
                animator.setInterpolator(getInterPolator(interploatorPosi));
                animator.start();
                break;

            case R.id.act_property_animator_set_Sequentially:

                Animator animator1 = AnimatorInflater.loadAnimator(this , R.animator.property_anim_sequentially_set);
                animator1.setTarget(propertyView);
                animator1.setInterpolator(getInterPolator(interploatorPosi));
                animator1.start();

                break;
        }
    }


    private void initView()
    {
        actPropertyAnimatorSet.setVisibility(View.GONE);
        actPropertyPropertyValueTips.setVisibility(View.GONE);
        actPropertyPropertyValue.setVisibility(View.GONE);
        actPropertyGoValueAnimator.setVisibility(View.GONE);
        actPropertyInterpolator.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                interploatorPosi = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        actPropertyPropertyName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                propertyPosi = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }

    private void loadAnimatorFormXml(int propertyPosi) {

        Animator animator = null;
        switch (propertyPosi) {
            default:
            case Constant.PRO_TRANSLATIONX:
                animator = AnimatorInflater.loadAnimator(this, R.animator.property_anim_translatex);
                break;

            case Constant.PRO_TRANSLATIONY:
                animator = AnimatorInflater.loadAnimator(this, R.animator.property_anim_translatey);
                break;

            case Constant.PRO_SCALEX:
                animator = AnimatorInflater.loadAnimator(this, R.animator.property_anim_scalex);
                break;

            case Constant.PRO_SCALEY:
                animator = AnimatorInflater.loadAnimator(this, R.animator.property_anim_scaley);
                break;

            case Constant.PRO_ALPHA:
                animator = AnimatorInflater.loadAnimator(this, R.animator.property_anim_alpha);
                break;

            case Constant.PRO_ROTATION:
                animator = AnimatorInflater.loadAnimator(this, R.animator.property_anim_rotation);
                break;

            case Constant.PRO_ROTATIONX:
                animator = AnimatorInflater.loadAnimator(this, R.animator.property_anim_rotationx);
                break;

            case Constant.PRO_ROTATIONY:
                animator = AnimatorInflater.loadAnimator(this, R.animator.property_anim_rotationy);
                break;
        }

        animator.setInterpolator(getInterPolator(interploatorPosi));
        animator.setTarget(propertyView);
        animator.start();
    }


    /**
     * 获得插值器
     *
     * @param interPolatorPosi
     */
    private TimeInterpolator getInterPolator(int interPolatorPosi) {

        TimeInterpolator timeInterpolator = null;
        switch (interPolatorPosi) {
            default:
            case Constant.INTERPOLATOR_ACEELERATE:

                timeInterpolator = new AccelerateInterpolator();
                break;
            case Constant.INTERPOLATOR_OVERSHOOT:
                timeInterpolator = new OvershootInterpolator();
                break;

            case Constant.INTERPOLATOR_ACCELERATE_DECELERATE:
                timeInterpolator = new AccelerateDecelerateInterpolator();
                break;

            case Constant.INTERPOLATOR_ANTICIPATE:
                timeInterpolator = new AnticipateInterpolator();
                break;

            case Constant.INTERPOLATOR_ANTICITPATE_OVERSHOOT:
                timeInterpolator = new AnticipateOvershootInterpolator();
                break;

            case Constant.INTERPOLATOR_BOUNCE:
                timeInterpolator = new BounceInterpolator();
                break;

            case Constant.INTERPOLATOR_CYCLE:
                timeInterpolator = new CycleInterpolator(2f);
                break;

            case Constant.INTERPOLATOR_DECELERATE:
                timeInterpolator = new DecelerateInterpolator();
                break;

            case Constant.INTERPOLATOR_LINEAR:
                timeInterpolator = new LinearInterpolator();
                break;

            case Constant.INTERPOLATOR_CUSTOM:
                timeInterpolator = new MyInterpolator();
                break;
        }

        return timeInterpolator;
    }

}
