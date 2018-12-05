package com.sera.androidarchitecture.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.sera.amm.common.dagger.AppComponent;
import com.sera.amm.common.module.ActivityModule;
import com.sera.amm.common.module.DataModule;
import com.sera.androidarchitecture.AmmApp;
import com.sera.androidarchitecture.di.ActivityComponent;
import com.sera.androidarchitecture.di.DaggerActivityComponent;


/**
 * Created by Fahmi Hakim on 05/12/2018.
 * for SERA
 */
public  abstract class CoreActivity extends AppCompatActivity {
    private ActivityComponent component;

    public ActivityComponent createActivityComponent(Activity activity) {
        if (this.component == null) {
            this.component = DaggerActivityComponent.builder()
                    .appComponent(AmmApp.getApp(activity).getComponent())
                    .activityModule(new ActivityModule(activity))
                    .dataModule(new DataModule(false))
                    .build();
            //this.component = getApp().component().provideActivityComponent(new ActivityModule(this));
        }
        return this.component;
    }

    public ActivityComponent getComponent() {
        return component;
    }

}
