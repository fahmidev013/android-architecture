package com.sera.amm.mvp;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by Fahmi Hakim on 04/12/2018.
 * for SERA
 */
public abstract class BaseFragment extends Fragment {

    /*public BaseActivityComponent component(AppComponent activityComponent, Activity activity) {
        return ((BaseActivity)getActivity()).component(activityComponent, activity);
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    protected Context getAppContext() {
        return getActivity().getApplicationContext();
    }



}
