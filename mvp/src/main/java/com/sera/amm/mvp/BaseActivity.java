package com.sera.amm.mvp;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sera.amm.common.dagger.AppComponent;
import com.sera.amm.common.module.ActivityModule;
import com.sera.amm.common.module.DataModule;

/**
 * Created by Fahmi Hakim on 04/12/2018.
 * for SERA
 */
public abstract class BaseActivity extends AppCompatActivity {

    /*private BaseActivityComponent component;

    public BaseActivityComponent component(AppComponent appComponent, Activity activity) {
        if (this.component == null) {
            this.component = DaggerBaseActivityComponent.builder()
                    .baseAppComponent(appComponent)
                    .baseActivityModule(new ActivityModule(activity))
                    .dataModule(new DataModule(false))
                    .build();
            //this.component = getApp().component().provideActivityComponent(new ActivityModule(this));
        }
        return this.component;
    }

    public BaseActivityComponent getComponent() {
        return component;
    }*/

    protected abstract void initDagger();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDagger();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }



}
