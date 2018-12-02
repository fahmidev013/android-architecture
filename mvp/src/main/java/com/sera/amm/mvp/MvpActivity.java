package com.sera.amm.mvp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.sera.amm.common.base.BaseApp;
import com.sera.amm.common.dependencyInjection.BaseActivityComponent;
import com.sera.amm.common.dependencyInjection.BaseActivityModule;

/**
 * Created by Fahmi Hakim on 9/5/17.
 */

public abstract class MvpActivity extends AppCompatActivity  {

    private BaseActivityComponent component;

    public BaseActivityComponent component() {
        if (this.component == null) {
            this.component = DaggerActivityComponent.builder()
                    .appComponent(getApp().getDaggerComponent())
                    .activityModule(new BaseActivityModule(this))
                    .build();
        }
        return this.component;
    }

    protected BaseApp getApp() {
        return (BaseApp) getApplication();
    }

}
