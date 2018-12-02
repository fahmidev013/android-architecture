package com.sera.androidarchitecture.module;

import android.app.Activity;

import com.sera.amm.mvp.PresenterContructor;
import com.sera.androidarchitecture.IbidApp;

import javax.inject.Inject;

import app.services.LoginService;

/**
 * Created by Fahmi Hakim on 29/11/2018.
 * for SERA
 */

public class MainPresenter implements PresenterContructor<MainView> {
    MainView mView;
    IbidApp mApp;
    LoginService mLoginService;


    @Inject
    MainPresenter(IbidApp app, LoginService loginService){
        this.mApp = app;
        this.mLoginService = loginService;
    }

    @Override
    public void attachView(MainView view) {
        this.mView = view;

    }


    private void loadData(){

    }

    @Override
    public void detachView() {

    }
}
