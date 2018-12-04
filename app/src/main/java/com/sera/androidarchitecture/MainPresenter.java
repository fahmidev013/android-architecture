package com.sera.androidarchitecture;

import com.sera.amm.mvp.BasePresenter;

/**
 * Created by Fahmi Hakim on 04/12/2018.
 * for SERA
 */
public class MainPresenter extends BasePresenter<MainView>{

    private MainView view;


    MainPresenter(MainView view) {
        this.view = view;
    }



    protected void loadMessage(String msg){
        view.showToast(msg);
    }

    @Override
    public void detachView() {
        super.detachView();
    }



    @Override
    public MainView getNoOptView() {
        return null;
    }
}
