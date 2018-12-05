package com.sera.androidarchitecture.pages.home;

import com.sera.amm.mvp.BasePresenter;
import com.sera.amm.userlist.RallyService;

/**
 * Created by Fahmi Hakim on 05/12/2018.
 * for SERA
 */
public class HomePresenter extends BasePresenter<HomeView> {


    HomeView mView;
    RallyService rallyService;

    HomePresenter(HomeView mView, RallyService service) {
        this.mView = mView;
        this.rallyService = service;
        mView.showLoading(true);

    }


    @Override
    public HomeView getNoOptView() {
        return null;
    }

    public void setUserMsg(String berubah) {
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                rallyService.setMsg(berubah);
                mView.showToast(rallyService.getMsg());
                mView.showLoading(false);
                mView.finishActivity();
            }
        }, 5000);


    }
}
