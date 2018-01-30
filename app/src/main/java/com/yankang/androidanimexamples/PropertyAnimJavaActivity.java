package com.yankang.androidanimexamples;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.FloatProperty;
import android.util.Property;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.yankang.androidanimexamples.Interpolator.MyInterpolator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yankang on 2018/1/24.
 */

public class PropertyAnimJavaActivity extends AppCompatActivity
{

    @BindView(R.id.act_property_interpolator)
    Spinner actPropertyInterpolator;
    @BindView(R.id.act_property_property_name)
    Spinner actPropertyPropertyName;
    @BindView(R.id.act_property_property_value)
    EditText actPropertyPropertyValue;
    @BindView(R.id.property_view)
    ImageView propertyView;

    private int interPosi = 0;
    private int propertyPosi = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_property_anim_layout);
        ButterKnife.bind(this);

        initView();

        propertyView.animate().translationX(200f).alpha(0.1f)
                .rotation(360f).alpha(1f)
                .translationX(-200f)
                .setDuration(3000)
                .start();

    }


    @OnClick({R.id.act_property_go_value_animator , R.id.act_property_go_object_animator
            , R.id.act_property_animator_set , R.id.act_property_animator_set_together , R.id.act_property_animator_set_Sequentially})
    public void toClickView(View view)
    {
        String value = actPropertyPropertyValue.getText().toString();
        switch (view.getId())
        {
            case R.id.act_property_go_value_animator:

                goValueAnimator(Float.valueOf(value) , interPosi , propertyPosi);
                break;

            default:
            case R.id.act_property_go_object_animator:

                goObjectAnimator(Float.valueOf(value) , interPosi , propertyPosi);

                break;

            case R.id.act_property_animator_set:
                goAnimatorSet(interPosi);

                break;

            case R.id.act_property_animator_set_together:
                goAnimatorSetTogether(interPosi);
                break;

            case R.id.act_property_animator_set_Sequentially:
                goAnimatorSetSequentially(interPosi);
                break;
        }
    }

    private void initView()
    {
        actPropertyInterpolator.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                interPosi = i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        actPropertyPropertyName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                propertyPosi = i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

    }


    private void goValueAnimator(final float value , int interPolatorPosi , final int porpertyPosi)
    {

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0 , value);

//        valueAnimator = ValueAnimator.ofArgb(0xff00ff , 0x00ff00);
//        valueAnimator = ValueAnimator.ofInt(100 , 200);
//        valueAnimator = ValueAnimator.ofObject(typeEvaluator , 200);

        valueAnimator.setDuration(3000);
        valueAnimator.setInterpolator(getInterPolator(interPolatorPosi));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator)
            {
                float nowValue = (float) valueAnimator.getAnimatedValue();
                switch (porpertyPosi)
                {
                    default:
                    case Constant.PRO_TRANSLATIONX:

                        propertyView.setTranslationX(nowValue);
                        break;

                    case Constant.PRO_TRANSLATIONY:

                        propertyView.setTranslationY(nowValue);

                        break;

                    case Constant.PRO_SCALEX:

                        propertyView.setScaleX(nowValue/value);

                        break;

                    case Constant.PRO_SCALEY:

                        propertyView.setScaleY(nowValue/value);

                        break;

                    case Constant.PRO_ALPHA:

                        propertyView.setAlpha(nowValue/value);

                        break;

                    case Constant.PRO_ROTATION:

                        propertyView.setRotation(nowValue);

                        break;

                    case Constant.PRO_ROTATIONX:

                        propertyView.setRotationX(nowValue);

                        break;

                    case Constant.PRO_ROTATIONY:

                        propertyView.setRotationY(nowValue);

                        break;
                }
            }
        });

        valueAnimator.setTarget(propertyView);
        valueAnimator.start();
    }


    /**
     * 获得插值器
     * @param interPolatorPosi
     */
    private TimeInterpolator getInterPolator(int interPolatorPosi)
    {
        TimeInterpolator timeInterpolator = null;
        switch (interPolatorPosi)
        {
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


    private void goObjectAnimator(final float value , int interPolatorPosi , final int porpertyPosi)
    {
        ObjectAnimator objectAnimator = null;
        switch (porpertyPosi)
        {
            default:
            case Constant.PRO_TRANSLATIONX:

                objectAnimator = ObjectAnimator.ofFloat(propertyView , "translationX" , 0 , value);

                break;

            case Constant.PRO_TRANSLATIONY:

                objectAnimator = ObjectAnimator.ofFloat(propertyView , "translationY" , 0 , value);
                break;

            case Constant.PRO_SCALEX:

                float scale = value > 2 ?  2f : value;
                objectAnimator = ObjectAnimator.ofFloat(propertyView , "scaleX" , scale);
                break;

            case Constant.PRO_SCALEY:

                float scale1 = value > 2 ?  2f : value;
                objectAnimator = ObjectAnimator.ofFloat(propertyView , "scaleY" , scale1);
                break;

            case Constant.PRO_ALPHA:

                float alpha = value >1 ?  0.5f : value;
//                objectAnimator = ObjectAnimator.ofFloat(propertyView , "alpha" , alpha);
                objectAnimator = ObjectAnimator.ofFloat(propertyView , PROGRESS_PROPERTY , alpha);

                break;

            case Constant.PRO_ROTATION:

                objectAnimator = ObjectAnimator.ofFloat(propertyView , "rotation" , value);
                break;

            case Constant.PRO_ROTATIONX:

                objectAnimator = ObjectAnimator.ofFloat(propertyView , "rotationX" , value);
                break;

            case Constant.PRO_ROTATIONY:

                objectAnimator = ObjectAnimator.ofFloat(propertyView , "rotationY" , value);
                break;
        }

        objectAnimator.setDuration(1000);
        objectAnimator.setInterpolator(getInterPolator(interPolatorPosi));
        objectAnimator.start();
    }

    private final Property<ImageView, Float> PROGRESS_PROPERTY = new FloatProperty<ImageView>("al") {
        @Override
        public void setValue(ImageView imageView, float value)
        {
            imageView.setAlpha(value);
        }

        @Override
        public Float get(ImageView imageView) {
            return  imageView.getAlpha();
        }
    };


    private void goAnimatorSet(int interPosi)
    {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator translationX = ObjectAnimator.ofFloat(propertyView , "translationX" , 0 , 200);
        ObjectAnimator translationX1 = ObjectAnimator.ofFloat(propertyView , "translationX" , 200 , 0);
        ObjectAnimator translationY = ObjectAnimator.ofFloat(propertyView , "translationY" , 0 , -200);
        ObjectAnimator translationY1 = ObjectAnimator.ofFloat(propertyView , "translationY" , -200 , 0);
        set.play(translationX).after(translationY).before(translationY1).before(translationX1);
        set.setInterpolator(getInterPolator(interPosi));
        set.setDuration(2000);
        set.start();
    }

    private void goAnimatorSetTogether(int interPosi)
    {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator translationX = ObjectAnimator.ofFloat(propertyView , "translationX" , 0 , 200);
        ObjectAnimator translationX1 = ObjectAnimator.ofFloat(propertyView , "translationX" , 200 , 0);
        ObjectAnimator translationY = ObjectAnimator.ofFloat(propertyView , "translationY" , 0 , -200);
        ObjectAnimator translationY1 = ObjectAnimator.ofFloat(propertyView , "translationY" , -200 , 0);
        set.playTogether(translationX , translationY , translationX1 , translationY1);
        set.setInterpolator(getInterPolator(interPosi));
        set.setDuration(2000);
        set.start();
    }


    private void goAnimatorSetSequentially(int interPosi)
    {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator translationX = ObjectAnimator.ofFloat(propertyView , "translationX" , 0 , 200);
        ObjectAnimator translationX1 = ObjectAnimator.ofFloat(propertyView , "translationX" , 200 , 0);
        ObjectAnimator translationY = ObjectAnimator.ofFloat(propertyView , "translationY" , 0 , -200);
        ObjectAnimator translationY1 = ObjectAnimator.ofFloat(propertyView , "translationY" , -200 , 0);
        set.playSequentially(translationX , translationY , translationX1 , translationY1);
        set.setDuration(2000);
        set.setInterpolator(getInterPolator(interPosi));
        set.start();

    }
}
