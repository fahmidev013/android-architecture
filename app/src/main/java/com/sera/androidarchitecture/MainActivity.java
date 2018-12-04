package com.sera.androidarchitecture;

import android.os.Bundle;
import android.widget.Toast;

import com.sera.amm.common.module.ActivityModule;
import com.sera.amm.common.module.AppModule;
import com.sera.amm.common.module.DataModule;
import com.sera.amm.mvp.BaseActivity;

import com.sera.amm.userlist.UserService;
import com.sera.androidarchitecture.di.ActivityComponent;
import com.sera.androidarchitecture.di.DaggerActivityComponent;


import javax.inject.Inject;

public class MainActivity extends BaseActivity{

  /*@Inject
  AppModule.Dummy data;

  @Inject
  DataModule.DummyString data3;*/

  @Inject
  String data2;

  @Inject
  DataModule.DummyString dataDummy;

  @Inject
  UserService userService;



  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toast.makeText(this, userService.getMsg(), Toast.LENGTH_LONG).show();
    //super.get(data.getMsg() + "  " + data2 + "  " + data3);
  }

  @Override
  protected void initDagger() {
    ActivityComponent componentChild = DaggerActivityComponent.builder()
            .appComponent(AmmApp.getApp(this).getComponent())
            .activityModule(new ActivityModule(this))
            .dataModule(new DataModule(false))
            .build();
    componentChild.inject(this);
  }

}
