package com.sera.androidarchitecture.pages;

import android.app.Activity;
import android.os.Handler;

import com.sera.amm.data.response.RallyResponModel;
import com.sera.amm.mvp.BasePresenter;
import com.sera.amm.userlist.RallyService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Fahmi Hakim on 04/12/2018.
 * for SERA
 */
public class MainPresenter extends BasePresenter<MainView>{

    private RallyService service;

    @Inject
    public MainPresenter(RallyService rallyService) {
        this.service = rallyService;
    }


    protected void loadMessage(){
        getView().showLoading(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                service.getDataRally()
                        .subscribe(new Observer<List<RallyResponModel>>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(List<RallyResponModel> rallyResponModels) {
                                if (rallyResponModels.size() != 0) getView().sendData(rallyResponModels);
                                getView().showLoading(false);
                            }

                            @Override
                            public void onError(Throwable e) {
                                getView().showLoading(false);
                            }

                            @Override
                            public void onComplete() {
                                getView().showLoading(false);
                            }
                        });
            }
        }, 5000);

    }


    @Override
    public MainView getNoOptView() {
        return null;
    }
}
