package com.yankang.androidanimexamples;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yankang on 2018/1/23.
 */

public class FrameActivity extends AppCompatActivity
{


    @BindView(R.id.animal_view)
    ImageView animalView;
    @BindView(R.id.change_way)
    Button changeWay;

    private AnimationDrawable frameAnim;
    private boolean isXml = true;

    private int[] ids = {R.drawable.i01 , R.drawable.i02 , R.drawable.i03
            , R.drawable.i04  ,R.drawable.i05 , R.drawable.i06 , R.drawable.i07};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_frame_anim_layout);
        ButterKnife.bind(this);

        initView();
    }

    @OnClick({R.id.change_way , R.id.frame_start , R.id.frame_stop})
    public void startFrame(View view)
    {
        switch (view.getId())
        {
            case R.id.change_way:

                if (frameAnim != null)
                    frameAnim.stop();

                isXml = !isXml;
                if (isXml)
                {
                    changeWay.setText("xml/java");
                }
                else
                {
                    changeWay.setText("java/xml");
                    createAnimal();
                }
                break;

            case R.id.frame_start:
                if (frameAnim != null)
                frameAnim.start();
                break;

            case R.id.frame_stop:
                if (frameAnim != null)
                frameAnim.stop();

                break;
        }
    }

    private void initView()
    {
        animalView.setImageResource(R.drawable.frame_anim);
        frameAnim = (AnimationDrawable) animalView.getDrawable();
//        frameAnim.setOneShot(false);
    }

    private void createAnimal()
    {
        frameAnim = new AnimationDrawable();
        for (int i = 0; i < ids.length; i++)
        {
            Drawable item = getResources().getDrawable(ids[i]);
            frameAnim.addFrame(item , 100);
        }

        frameAnim.setOneShot(false);
        animalView.setImageDrawable(frameAnim);
    }

}
