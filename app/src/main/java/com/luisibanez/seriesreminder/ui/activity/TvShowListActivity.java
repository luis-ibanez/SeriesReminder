package com.luisibanez.seriesreminder.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.luisibanez.seriesreminder.R;
import com.luisibanez.seriesreminder.ui.fragment.TvShowListFragment;
import com.luisibanez.seriesreminder.ui.presenter.TvShowUIModule;

import java.util.LinkedList;
import java.util.List;

public class TvShowListActivity extends BaseActivity {

    private TvShowListFragment tvShowListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_show_list);
        initializeTvShowListFragment();
    }

    @Override
    protected List<Object> getModules() {
        LinkedList<Object> modules = new LinkedList<>();
        modules.add(new TvShowUIModule());
        return modules;
    }

    private void initializeTvShowListFragment() {
        tvShowListFragment = (TvShowListFragment) getSupportFragmentManager().findFragmentById(R.id.f_series_list);
    }
}
