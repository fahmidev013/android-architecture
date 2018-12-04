package com.sera.amm.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Fahmi Hakim on 9/5/17.
 */

public abstract class MvpActivity extends AppCompatActivity implements ClientView{

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
