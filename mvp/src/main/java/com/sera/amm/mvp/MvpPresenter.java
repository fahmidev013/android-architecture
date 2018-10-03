package com.sera.amm.mvp;

/**
 * Created by Fahmi Hakim on 25/09/2018.
 * for SERA
 */
public class MvpPresenter extends BasePresenter<ClientView> {

    @Override
    public void attachView(ClientView view) {
        super.attachView(view);
    }

    @Override
    public ClientView getNoOptView() {
        return null;
    }

    public void showMsg(String msg){
        getView().showData(msg);
    }

}
