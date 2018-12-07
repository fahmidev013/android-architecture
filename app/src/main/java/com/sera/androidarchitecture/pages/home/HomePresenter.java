package com.sera.androidarchitecture.pages.home;

import com.sera.amm.services.rallyService.RallyService;
import com.sera.amm.mvp.BasePresenter;

import javax.inject.Inject;

/**
 * Created by Fahmi Hakim on 05/12/2018.
 * for SERA
 */
public class HomePresenter extends BasePresenter<HomeView> {


    RallyService rallyService;

    @Inject
    HomePresenter(RallyService service) {
        this.rallyService = service;
    }


    @Override
    public HomeView getNoOptView() {
        return null;
    }

}
