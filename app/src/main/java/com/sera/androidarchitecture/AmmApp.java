package com.sera.androidarchitecture;

import android.content.Context;

import com.sera.amm.common.base.BaseApp;
import com.sera.amm.common.dagger.AppComponent;

/**
 * Created by Fahmi Hakim on 9/5/17.
 */

public class AmmApp extends BaseApp {


  @Override
  public void onCreate() {
    super.onCreate();
    component(this).inject(this);
  }

  public static AmmApp getApp(Context context){
    return (AmmApp) context.getApplicationContext();
  }

  public AppComponent getComponent(){
      return super.component(this);
  }

}
