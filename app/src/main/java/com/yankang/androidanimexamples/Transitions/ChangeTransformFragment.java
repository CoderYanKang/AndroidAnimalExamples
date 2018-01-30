package com.yankang.androidanimexamples.Transitions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.ChangeTransform;
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

public class ChangeTransformFragment extends Fragment {

    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.doc)
    TextView docTxt;
    Unbinder unbinder;
    @BindView(R.id.container)
    LinearLayout container;

    private String doc = "在改变目标视图的缩放比例和旋转角度过程中，添加transition动画";
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
    public void toChangeTransfrom()
    {
        ChangeTransform changeTransform = new ChangeTransform();
        changeTransform.setDuration(1500);
        TransitionManager.beginDelayedTransition(container , changeTransform);
        if (flag)
        {
            icon.setRotation(45f);
            flag = false;
        }
        else
        {
            icon.setRotation(-45f);
            flag = true;
        }
    }

    private void initView() {
        docTxt.setText(doc);

    }
}
