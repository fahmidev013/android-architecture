package com.sera.androidarchitecture;

import com.sera.amm.mvp.BasePresenter;
import com.sera.amm.userlist.UserService;

/**
 * Created by Fahmi Hakim on 04/12/2018.
 * for SERA
 */
public class MainPresenter extends BasePresenter<MainView>{

    private MainView view;
    private UserService service;


    MainPresenter(MainView view, UserService userService) {
        this.view = view;
        this.service = userService;
        view.showToast(service.getMsg());
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
