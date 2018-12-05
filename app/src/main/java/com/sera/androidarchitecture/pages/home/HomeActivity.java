package com.sera.androidarchitecture.pages.home;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sera.amm.userlist.RallyService;
import com.sera.androidarchitecture.R;
import com.sera.androidarchitecture.base.CoreActivity;

import javax.inject.Inject;

/**
 * Created by Fahmi Hakim on 05/12/2018.
 * for SERA
 */
public class HomeActivity extends CoreActivity<HomePresenter> implements HomeView{

    @Inject
    RallyService rallyService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createActivityComponent(this).inject(this);
        setContentView(R.layout.activity_main);
        createPresenter(new HomePresenter(this, rallyService));
        getPresenter().setUserMsg("Berubah");
    }

    @Override
    public void showLoading(boolean isShow) {
        showProgressDialog(isShow);
    }

    @Override
    public void showToast(String msg) {
        showMessage(msg);
    }

    @Override
    public void finishActivity() {
        finish();
    }
}
