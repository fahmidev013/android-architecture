package com.sera.androidarchitecture.pages;

import android.os.Handler;

import com.sera.amm.services.beliNPLService.BeliNplService;
import com.sera.amm.services.rallyService.RallyService;
import com.sera.amm.services.rallyService.RallyResponModel;
import com.sera.amm.mvp.BasePresenter;
import com.sera.androidarchitecture.R;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Fahmi Hakim on 04/12/2018.
 * for SERA
 */
public class MainPresenter extends BasePresenter<MainView>{

    private RallyService serviceRally;
    private BeliNplService serviceBeliNpl;

    @Inject
    public MainPresenter(RallyService rallyService, BeliNplService beliNplService) {
        this.serviceRally = rallyService;
        this.serviceBeliNpl = beliNplService;
    }


    protected void loadMessage(){
        getView().showLoading(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                serviceRally.getDataRally()
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
                                getView().showErrorMessagefromResources(R.string.error_message_getDataFailed, null);
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
