package com.yankang.androidanimexamples.AppCompatTransition;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.transitionseverywhere.ChangeClipBounds;
import com.transitionseverywhere.TransitionManager;
import com.yankang.androidanimexamples.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by yankang on 2018/1/29.
 */

public class ChangeClipBoundsFragment extends Fragment
{

    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.doc_txt)
    TextView docTxt;
    Unbinder unbinder;
    @BindView(R.id.container)
    LinearLayout container;

    private String doc = "获取前后 Scene 中 getClipBounds() 的边界，并做动画，有如下属性：\n" +
            "android:resizeClip 通过改变 clipBounds 来改变 view，而不是改变view 自身的大小";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.frag_change_clip_bounds_layout, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.to_change_clips_bounds)
    public void toChangeClips()
    {
        ChangeClipBounds changeBounds = new ChangeClipBounds();
        changeBounds.setDuration(1000);
        Rect rect = new Rect(150, 150, 400, 400);
        TransitionManager.beginDelayedTransition(container, changeBounds);
        if (rect.equals(icon.getClipBounds())) {
            icon.setClipBounds(null);
        }
        else
        {
            icon.setClipBounds(rect);
        }
    }

    private void initView() {
        docTxt.setText(doc);
    }

}
