package com.yankang.androidanimexamples.Transitions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.ChangeScroll;
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

public class ChangeScrollFragment extends Fragment
{

    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.doc)
    TextView docTxt;
    Unbinder unbinder;
    @BindView(R.id.container)
    LinearLayout container;

    private String doc = "在改变目标视图的滑动位置之间，添加transition动画";
    private boolean flag = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_change_transform_layout, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.go_change_transform)
    public void toChangeScroll()
    {
        ChangeScroll transform = new ChangeScroll();
        transform.setDuration(1000);
        TransitionManager.beginDelayedTransition(container , transform);
        icon.scrollBy(-100, -100);

    }

    private void initView()
    {
        docTxt.setText(doc);
    }

}
