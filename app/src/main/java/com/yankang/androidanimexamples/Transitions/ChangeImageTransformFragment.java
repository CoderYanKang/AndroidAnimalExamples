package com.yankang.androidanimexamples.Transitions;

import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.ChangeImageTransform;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yankang.androidanimexamples.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by yankang on 2018/1/26.
 */

public class ChangeImageTransformFragment extends Fragment
{

    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.container)
    LinearLayout container;
    @BindView(R.id.doc_txt)
    TextView docTxt;
    Unbinder unbinder;

    private String doc = "通过获取开始和结束时 Scene 中 ImageView 的 matrix ，并对他们做动画。 和 ChangeBounds 一起使用，来对 ImageView 改变大小，形状，和 ScaleType 来使动画更加流畅";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.frag_change_image_transform_layout, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.to_center , R.id.to_centerCrop , R.id.to_centerInside
            , R.id.to_fitCenter, R.id.to_fitEnd
            , R.id.to_fitStart , R.id.to_fitXY
            , R.id.to_matrix})
    public void toTransform(View view)
    {
        switch (view.getId())
        {
            case R.id.to_center:
                goImageTransform(ImageView.ScaleType.CENTER);
                break;

            case R.id.to_centerCrop:
                goImageTransform(ImageView.ScaleType.CENTER_CROP);
                break;

            case R.id.to_centerInside:
                goImageTransform(ImageView.ScaleType.CENTER_INSIDE);
                break;

            case R.id.to_fitCenter:
                goImageTransform(ImageView.ScaleType.FIT_CENTER);
                break;

            case R.id.to_fitEnd:
                goImageTransform(ImageView.ScaleType.FIT_END);
                break;

            case R.id.to_fitStart:
                goImageTransform(ImageView.ScaleType.FIT_START);
                break;

            case R.id.to_fitXY:
                goImageTransform(ImageView.ScaleType.FIT_XY);
                break;

            case R.id.to_matrix:
                goImageTransform(null);
                break;
        }
    }


    private void goImageTransform(ImageView.ScaleType scaleType)
    {
        ChangeImageTransform imageTransform = new ChangeImageTransform();
        imageTransform.setDuration(800);
        TransitionManager.beginDelayedTransition(container ,imageTransform);
        if (scaleType == null)
        {
            icon.setScaleType(ImageView.ScaleType.MATRIX);
            final Matrix matrix = new Matrix();
            matrix.setRotate(45.f);
            matrix.postTranslate(20, 10);
            matrix.postSkew(10 , 20);
            icon.setImageMatrix(matrix);
        }
        else
        {
            icon.setScaleType(scaleType);
        }
    }

    private void initView()
    {
        docTxt.setText(doc);
    }

}
