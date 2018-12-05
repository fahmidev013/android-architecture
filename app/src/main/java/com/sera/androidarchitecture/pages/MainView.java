package com.sera.androidarchitecture.pages;

import com.sera.amm.data.response.RallyResponModel;
import com.sera.amm.mvp.MvpView;

import java.util.List;

/**
 * Created by Fahmi Hakim on 04/12/2018.
 * for SERA
 */
public interface MainView extends MvpView {

    void changeActivity();
    void sendData(List<RallyResponModel> data);
}
