package com.sera.amm.userlist;

import android.app.Activity;

/**
 * Created by Fahmi Hakim on 04/12/2018.
 * for SERA
 */
public class UserService {
    private Activity activity;
    private String psn;


    private boolean signalRSubscribed = false;
    private String signalRChannel;



    //make sure process order handling one at a time
    private boolean processing = false;


    public UserService(Activity activity, String msg) {
        this.activity = activity;
        this.psn = msg;
    }

    public String getMsg(){
        return psn;
    }




}
