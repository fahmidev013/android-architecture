package com.sera.androidarchitecture.pages;

import android.content.Intent;


import android.os.Bundle;


import com.sera.amm.data.rallyService.RallyResponModel;
import com.sera.androidarchitecture.R;
import com.sera.androidarchitecture.base.CoreActivity;
import com.sera.androidarchitecture.databinding.ActivityMainBinding;
import com.sera.androidarchitecture.pages.home.HomeActivity;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.databinding.DataBindingUtil;


public class MainActivity extends CoreActivity<MainPresenter, MainView> implements MainView{


  @Inject
  MainPresenter presenter;

  private RallyResponModel rallyResponModel = new RallyResponModel("Initialized Title");


  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
      ActivityMainBinding binding = DataBindingUtil.setContentView( this, R.layout.activity_main);
      binding.setRally(rallyResponModel);
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
    rallyResponModel.setTitle(j.get(j.size() - 1));
    showToast(rallyResponModel.getTitle());
  }


}
