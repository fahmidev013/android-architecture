package com.sera.androidarchitecture.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;

import android.text.TextUtils;
import android.widget.Toast;

import com.sera.amm.common.module.ActivityModule;
import com.sera.amm.common.module.DataModule;
import com.sera.amm.mvp.BasePresenter;
import com.sera.amm.mvp.MvpView;
import com.sera.androidarchitecture.AmmApp;
import com.sera.androidarchitecture.di.ActivityComponent;


import com.sera.androidarchitecture.di.DaggerActivityComponent;
import com.sera.androidarchitecture.utils.SystemUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


/**
 * Created by Fahmi Hakim on 05/12/2018.
 * for SERA
 */

public abstract class CoreActivity<T extends BasePresenter, V extends MvpView> extends AppCompatActivity implements MvpView {
    private ActivityComponent component;
    private ProgressDialog dialog;
    protected boolean isConnection = false;

    public T presenter;

    public void createPresenter(T injectPresenter, V iView){
        this.presenter = injectPresenter;
        this.presenter.attachView(iView);
    }

    public T getPresenter(){
        return presenter;
    }

    public ActivityComponent createActivityComponent(Activity activity) {
        if (this.component == null) {
            this.component = DaggerActivityComponent.builder()
                    .appComponent(AmmApp.getApp(activity).getComponent())
                    .activityModule(new ActivityModule(activity))
                    .dataModule(new DataModule(false, activity))
                    .build();
        }
        return this.component;
    }

    public ActivityComponent getActivityComponent() {
        return component;
    }

    private void initActivityObject(Activity activity){
        createActivityComponent(activity);
        dialog = new ProgressDialog(activity);
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(getLayoutResId());
//        EventBus.getDefault().register(this);
        /*setStatusBar();
        getIntentData();
        OtherSetting();*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        initActivityObject(this);
        initInject();
        initialize();
    }

    protected abstract void initInject();

    public abstract int getLayoutResId();

    public void initialize() {
        //getNetworkType();
        initData();
        initView();
        initEvent();
    }

    protected abstract void initEvent();

    protected abstract void initView();

    protected abstract void initData();


    protected void OtherSetting() {
    }

    public void getIntentData() {
    }

    @TargetApi(19)
    protected void setStatusBar() {
        //StatusBarUtil.setTransparent(this);
    }

    protected void setStatusBar(Toolbar toolBar, String title) {
        if (!TextUtils.isEmpty(title))
            toolBar.setTitle(title);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolBar.setNavigationOnClickListener((view) -> onBackPressed());
    }

    @Override
    public void showLoading(boolean isShow) {
        if (!isShow) {
            if (dialog.isShowing()) dialog.hide();
        } else {
            dialog.setMessage("Please Waiting..");
            dialog.show();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public String getNetworkType() {
        return isConnection ? SystemUtils.GetNetworkType(this) : "";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
          presenter.detachView();
//        unbinder.unbind();
    }

    /*@Subscribe(threadMode = ThreadMode.MAIN)
    public void receiverConnectionState(Events.ConnectionEvent event) {
        isConnection = event.isConnection();
    }*/



}
