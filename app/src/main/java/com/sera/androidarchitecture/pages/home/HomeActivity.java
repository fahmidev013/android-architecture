package com.sera.androidarchitecture.pages.home;

import android.os.Bundle;


import com.sera.amm.services.rallyService.RallyService;
import com.sera.androidarchitecture.R;
import com.sera.androidarchitecture.base.CoreActivity;

import javax.inject.Inject;

import androidx.annotation.Nullable;

/**
 * Created by Fahmi Hakim on 05/12/2018.
 * for SERA
 */
public class HomeActivity extends CoreActivity<HomePresenter, HomeView> implements HomeView{

    @Inject
    RallyService rallyService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initInject() {
        createActivityComponent(this).inject(this);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }


    @Override
    public void finishActivity() {
        finish();
    }
}
