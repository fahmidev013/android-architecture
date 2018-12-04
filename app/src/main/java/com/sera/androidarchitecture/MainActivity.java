package com.sera.androidarchitecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sera.amm.mvp.MvpActivity;
import com.sera.androidarchitecture.di.component.ActComponent;
import com.sera.androidarchitecture.di.component.DaggerActComponent;
import com.sera.androidarchitecture.di.module.ActModule;
import com.sera.androidarchitecture.di.module.AppModule;

import javax.inject.Inject;

public class MainActivity extends MvpActivity {

  @Inject
  AppModule.Dummy data;

  @Inject
  String data2;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActComponent component = DaggerActComponent.builder()
            .appComponent(AmmApp.getAppContext(this).getAppComponent())
            .actModule(new ActModule(this))
            .build();
    component.inject(this);
    setContentView(R.layout.activity_main);
    super.get(data.getMsg() + "  " + data2);
  }

}
