package com.sera.androidarchitecture.pages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;

import com.sera.amm.common.module.DataModule;

import com.sera.amm.data.response.RallyResponModel;
import com.sera.amm.userlist.RallyService;
import com.sera.androidarchitecture.R;
import com.sera.androidarchitecture.base.CoreActivity;
import com.sera.androidarchitecture.pages.home.HomeActivity;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends CoreActivity<MainPresenter, MainView> implements MainView{


  @Inject
  MainPresenter presenter;


  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  protected void initInject() {
    getActivityComponent().inject(this);
    createPresenter(presenter, this);
  }



  @Override
  public int getLayoutResId() {
    return R.layout.activity_main;
  }

  @Override
  protected void initEvent() {

  }

  @Override
  protected void initView() {
    /*setToolBar(toolbar, "新闻");
    actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.app_name, R.string.app_name);
    actionBarDrawerToggle.syncState();
    drawer.addDrawerListener(actionBarDrawerToggle);
    mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    viewpagerMain.setScrollable(false);
    viewpagerMain.setAdapter(presenter.getPagerAdapter(getSupportFragmentManager()));
    mTabLayout.setTabData(presenter.getTabData());
    viewpagerMain.setOffscreenPageLimit(presenter.getTabData().size());
    MainTabHelper.bind(viewpagerMain, mTabLayout);
    drawerContentView = mInflater.inflate(R.layout.drawer_content, null, false);
    initDrawerView(drawerContentView);*/
  }

  @Override
  protected void initData() {
    getPresenter().loadMessage();
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
    showToast(j.toString());
  }
}
