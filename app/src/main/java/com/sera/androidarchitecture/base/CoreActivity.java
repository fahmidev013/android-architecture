package com.sera.androidarchitecture.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.sera.amm.common.module.ActivityModule;
import com.sera.amm.common.module.DataModule;
import com.sera.androidarchitecture.AmmApp;
import com.sera.androidarchitecture.di.ActivityComponent;
import com.sera.androidarchitecture.di.DaggerActivityComponent;


/**
 * Created by Fahmi Hakim on 05/12/2018.
 * for SERA
 */

public abstract class CoreActivity<T> extends AppCompatActivity {
    private ActivityComponent component;
    private ProgressDialog dialog;
    private T presenter;

    public void createPresenter(T injectPresenter){
        this.presenter = injectPresenter;
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
        initActivityObject(this);
    }

    protected void showMessage(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    protected void showProgressDialog(boolean state){
        if (!state) {
            if (dialog.isShowing()) dialog.hide();
        } else {
            dialog.setMessage("Please Waiting..");
            dialog.show();
        }
    }


}
