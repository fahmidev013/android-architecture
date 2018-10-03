package com.sera.amm.mvp;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Fahmi Hakim on 9/5/17.
 */

public abstract class MvpActivity extends AppCompatActivity implements ClientView{

    MvpPresenter presenter;


    public void get(String msg){
        presenter = new MvpPresenter();
        presenter.attachView(this);
        presenter.showMsg(msg);
    }


    @Override
    public void showData(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
