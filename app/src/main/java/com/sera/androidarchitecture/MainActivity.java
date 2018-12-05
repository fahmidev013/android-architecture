package com.sera.androidarchitecture;

import android.os.Bundle;
import android.widget.Toast;

import com.sera.amm.common.module.DataModule;

import com.sera.amm.userlist.UserService;
import com.sera.androidarchitecture.base.CoreActivity;


import javax.inject.Inject;

public class MainActivity extends CoreActivity implements MainView{



  @Inject
  String data2;

  @Inject
  DataModule.DummyString dataDummy;

  @Inject
  UserService userService;

  MainPresenter presenter;


  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    createActivityComponent(this).inject(this);
    setContentView(R.layout.activity_main);
    presenter = new MainPresenter(this, userService);
  }

  @Override
  public void showToast(String msg) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
  }
}
