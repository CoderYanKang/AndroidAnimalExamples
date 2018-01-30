package com.yankang.androidanimexamples.Transitions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.yankang.androidanimexamples.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by yankang on 2018/1/26.
 */

public class SceneSlideFragment extends Fragment
{

    @BindView(R.id.iv_01)
    ImageView iv01;
    @BindView(R.id.iv_02)
    ImageView iv02;
    @BindView(R.id.iv_03)
    ImageView iv03;
    @BindView(R.id.iv_04)
    ImageView iv04;
    @BindView(R.id.view_root)
    FrameLayout viewRoot;
    @BindView(R.id.doc_txt)
    TextView docTxt;
    @BindView(R.id.fade_default)
    Button fadeDefault;
    Unbinder unbinder;

    private ArrayList<ImageView> imageViews = new ArrayList<>();
    private String doc = "元素从四个方向滑动进入\n" +
            "Slide 属性：\n" +
            "android:slideEdge 从那边滑动出，有 left, top, right, bottom, start, end 模式, 默认bottom , new Slide(Gravity.TOP)";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_explode_layout, container, false);

        unbinder = ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.fade_default)
    public void fadeDefault()
    {
        TransitionManager.beginDelayedTransition(viewRoot, new Slide(Gravity.TOP));
        for (ImageView imageView : imageViews) {
            if (imageView.getVisibility() == View.VISIBLE) {
                imageView.setVisibility(View.GONE);
            } else {
                imageView.setVisibility(View.VISIBLE);
            }
        }
    }

    private void initView()
    {
        fadeDefault.setText("Slide");
        docTxt.setText(doc);
        imageViews.clear();
        imageViews.add(iv01);
        imageViews.add(iv02);
        imageViews.add(iv03);
        imageViews.add(iv04);
    }

}
