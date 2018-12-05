package com.sera.androidarchitecture.pages;

import android.os.Handler;

import com.sera.amm.data.response.RallyResponModel;
import com.sera.amm.mvp.BasePresenter;
import com.sera.amm.userlist.RallyService;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Fahmi Hakim on 04/12/2018.
 * for SERA
 */
public class MainPresenter extends BasePresenter<MainView>{

    private MainView mView;
    private RallyService service;



    public MainPresenter(MainView view, RallyService rallyService) {
        this.mView = view;
        this.service = rallyService;
        mView.showLoading(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadMessage();
            }
        }, 5000);

    }

    protected void loadMessage(){

        service.getDataRally()
                .subscribe(new Observer<List<RallyResponModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<RallyResponModel> rallyResponModels) {
                        if (rallyResponModels.size() != 0) mView.sendData(rallyResponModels);
                        mView.showLoading(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showLoading(false);
                    }

                    @Override
                    public void onComplete() {
                        mView.showLoading(false);
                    }
                });
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