package com.sera.amm.mvp;

import android.os.Bundle;

import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * Created by Fahmi Hakim on 9/5/17.
 */

public abstract class MvpActivity extends BaseActivity implements ClientView{

    MvpPresenter presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MvpPresenter();
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    public void get(String msg){

        presenter.showMsg(msg);
    }


    @Override
    public void showData(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
