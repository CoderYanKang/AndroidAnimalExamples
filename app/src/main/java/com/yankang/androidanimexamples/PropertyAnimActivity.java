package com.yankang.androidanimexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yankang on 2018/1/24.
 */

public class PropertyAnimActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_property_anim_way_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.property_to_java)
    public void toPropertyByJava()
    {
        startActivity(new Intent(this , PropertyAnimJavaActivity.class));
    }

    @OnClick(R.id.property_to_xml)
    public void toPropertyByXml()
    {
        startActivity(new Intent(this , PropertyAnimXmlActivity.class));
    }

}
