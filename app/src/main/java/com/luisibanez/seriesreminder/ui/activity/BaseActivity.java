package com.luisibanez.seriesreminder.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Base activity created to be extended by every activity in this application. This class provides
 * ButterKnife Android library configuration and some methods
 * common to every activity.
 *
 * Created by libanez on 01/11/2015.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectViews();
    }

    /**
     * Replace every field annotated with ButterKnife annotations like @InjectView with the proper
     * value.
     */
    private void injectViews() {
        ButterKnife.inject(this);
    }
}
