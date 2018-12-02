package com.sera.amm.mvp;

/**
 * Created by Fahmi Hakim on 29/11/2018.
 * for SERA
 */
public interface PresenterContructor<P extends MvpViewToActivity> {
    void attachView(P view);
    void detachView();

}
