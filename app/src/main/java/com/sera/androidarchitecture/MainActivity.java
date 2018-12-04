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

public class MainActivity extends BaseActivity implements MainView{



  @Inject
  String data2;

  @Inject
  DataModule.DummyString dataDummy;

  @Inject
  UserService userService;

  MainPresenter presenter;


  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    presenter = new MainPresenter(this);
    presenter.loadMessage( userService.getMsg());
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



  @Override
  public void showToast(String msg) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
  }
}
