package com.sera.androidarchitecture.module;

import android.os.Bundle;

import com.sera.amm.mvp.MvpActivity;
import com.sera.androidarchitecture.R;

import javax.inject.Inject;


public class MainActivity extends MvpActivity implements MainView {

  @Inject
  MainPresenter presenter;


  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    component().inject(this);
    presenter.attachView(this);

  }


  @Override
  public void showProgress() {

  }

  @Override
  public void hideProgress() {

  }

  @Override
  protected void onDestroy() {
    presenter.detachView();
    super.onDestroy();
  }
}
