package com.yankang.androidanimexamples.Transitions;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.yankang.androidanimexamples.R;
import com.yankang.androidanimexamples.Transitions.CustomTransitions.ColorTransition;
import com.yankang.androidanimexamples.Transitions.CustomTransitions.ProgressTransition;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by yankang on 2018/1/26.
 */

public class CustomTransitionFragment extends Fragment {

    @BindView(R.id.img)
    ImageView img;
    Unbinder unbinder;
    @BindView(R.id.container)
    LinearLayout container;
    @BindView(R.id.container1)
    LinearLayout container1;

    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.container2)
    LinearLayout container2;

    private int[] colors = {Color.RED, Color.BLACK, Color.BLUE, Color.CYAN, Color.GRAY};
    private int posi = 0;
    private ArrayList<Scene> scenes = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.frag_custom_transition_layout, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        initView();

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick(R.id.to_change_color)
    public void toChangeColor()
    {
        ColorTransition colorTransition = new ColorTransition();
        colorTransition.setDuration(2000);
        TransitionManager.beginDelayedTransition(container, colorTransition);
        img.setBackgroundColor(colors[posi % colors.length]);
        posi++;
    }

    @OnClick(R.id.to_change_color_scene)
    public void toChangeColorScene()
    {
        TransitionSet set = new TransitionSet();
        set.setDuration(2000);
        set.addTransition(new ChangeBounds());
        set.addTransition(new ColorTransition());
        posi++;
        TransitionManager.go(scenes.get(posi%scenes.size()) ,set);
    }


    @OnClick({R.id.add, R.id.reduce})
    public void controlProgressBar(View view)
    {
        ProgressTransition progressTransition = new ProgressTransition();
        progressTransition.setDuration(500);
        android.transition.TransitionManager.beginDelayedTransition(container2 , progressTransition);
        switch (view.getId())
        {
            case R.id.add:

                progress.setProgress(progress.getProgress()+10);

                break;

            case R.id.reduce:
                progress.setProgress(progress.getProgress()-10);
                break;
        }
    }

    private void initView()
    {
        Scene scene1 = Scene.getSceneForLayout(container1 , R.layout.custom_scene_01 , getActivity());
        Scene scene2 = Scene.getSceneForLayout(container1 , R.layout.custom_scene_02 , getActivity());
        scenes.add(scene1);
        scenes.add(scene2);
        TransitionManager.go(scene1);
    }

}
