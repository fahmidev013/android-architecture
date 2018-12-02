package com.sera.amm.mvp;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.sera.amm.common.base.BaseApp;
import com.sera.amm.common.dependencyInjection.BaseActivityComponent;

/**
 * Created by Fahmi Hakim on 9/5/17.
 */

public abstract class MvpFragment extends Fragment {

    public BaseActivityComponent component() {
        return ((MvpActivity) getActivity()).component();
    }

    protected BaseApp getApp(Fragment fragment) {
        return (BaseApp) fragment.getActivity().getApplication();
    }

    protected Context getAppContext() {
        return getActivity().getApplicationContext();
    }

}
