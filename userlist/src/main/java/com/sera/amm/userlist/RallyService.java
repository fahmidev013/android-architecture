package com.sera.amm.userlist;

import android.app.Activity;


import com.sera.amm.data.RallyAPI;
import com.sera.amm.data.response.RallyResponModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Fahmi Hakim on 04/12/2018.
 * for SERA
 */
public class RallyService {
    private Activity activity;
    private String psn;
    private RallyAPI mRallyAPI;



    public RallyService(Activity activity, String msg, RallyAPI rallyAPI) {
        this.activity = activity;
        this.psn = msg;
        this.mRallyAPI = rallyAPI;
    }

    public Observable<List<RallyResponModel>> getDataRally() {
        return mRallyAPI.getData()
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
