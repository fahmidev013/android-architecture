package com.sera.amm.mvp;

import androidx.annotation.Nullable;

/**
 * Created by Fahmi Hakim on 9/5/17.
 */

public interface MvpView {
    void showLoading(boolean isShow);
    void showToast(String msg);
    void showErrorMessagefromResources(int resourceStringName, @Nullable String additionalMsg);
    String getStringFromResources(int resourceStringName);
}
