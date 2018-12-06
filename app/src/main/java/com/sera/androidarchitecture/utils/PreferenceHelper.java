package com.sera.androidarchitecture.utils;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * Created by Fahmi Hakim on 06/12/2018.
 * for SERA
 */
public class PreferenceHelper {

    private Context mContext;

    private SharedPreferences sharedPreferences;

    public static final String FIRST_INSTALL = "FIRST_INSTALL";


    @Inject
    public PreferenceHelper(Context mContext) {
        this.mContext = mContext;
        sharedPreferences = mContext.getSharedPreferences("setting", Context.MODE_PRIVATE);
    }


    public void saveAppPre(boolean b) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(FIRST_INSTALL, b);
        edit.commit();
    }


    public boolean isFirstInstallApp() {
        return sharedPreferences.getBoolean(FIRST_INSTALL, true);
    }
}
