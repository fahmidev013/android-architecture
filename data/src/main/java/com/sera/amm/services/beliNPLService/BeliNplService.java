package com.sera.amm.services.beliNPLService;

import android.app.Activity;

import com.sera.amm.services.rallyService.RallyResponModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Fahmi Hakim on 07/12/2018.
 * for SERA
 */
public class BeliNplService {
    private Activity activity;
    private String psn;
    private BeliNplAPI mBeliNplAPI;



    public BeliNplService(Activity activity, String msg, BeliNplAPI rallyAPI) {
        this.activity = activity;
        this.psn = msg;
        this.mBeliNplAPI = rallyAPI;
    }

    public Observable<List<BeliNPLResponModel>> getDataRally() {
        return mBeliNplAPI.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public String getMsg(){
        return psn;
    }

    public void setMsg(String psn) {
        this.psn = psn;
    }
}
