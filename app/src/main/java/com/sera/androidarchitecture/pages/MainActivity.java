package com.sera.androidarchitecture.pages;

import android.content.Intent;
import android.os.Bundle;

import com.sera.amm.common.module.DataModule;

import com.sera.amm.data.response.RallyResponModel;
import com.sera.amm.userlist.RallyService;
import com.sera.androidarchitecture.R;
import com.sera.androidarchitecture.base.CoreActivity;
import com.sera.androidarchitecture.pages.home.HomeActivity;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends CoreActivity<MainPresenter> implements MainView{

  @Inject
  String data2;

  @Inject
  DataModule.DummyString dataDummy;

  @Inject
  RallyService rallyService;




  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getActivityComponent().inject(this);
    setContentView(R.layout.activity_main);
    createPresenter(new MainPresenter(this, rallyService));
   // getPresenter().loadMessage(rallyService.getMsg());
  }



    @Override
  protected void onDestroy() {
    getPresenter().detachView();
    super.onDestroy();
  }

  @Override
  public void showToast(String msg) {
    showMessage(msg);
  }


  @Override
  public void showLoading(boolean isShow) {
    showProgressDialog(isShow);
  }

  @Override
  public void changeActivity() {
    startActivity(new Intent(this, HomeActivity.class));
  }

  @Override
  public void sendData(List<RallyResponModel> data) {


    ArrayList<String> j = new ArrayList<>();
    for (int i =0 ; i< data.size(); i++) {
      j.add(data.get(i).getTitle());
    }
    showMessage(j.toString());
  }
}
