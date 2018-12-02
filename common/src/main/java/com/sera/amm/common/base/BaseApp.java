package com.sera.amm.common.base;

import android.app.Application;
import android.content.Context;



/**
 * Created by Fahmi Hakim on 9/6/17.
 */

public abstract class BaseApp<T, V> extends Application {

  private boolean running;
//  private BaseAppComponent<T> component;
//  private Scheduler defaultSubscribeScheduler;




  /*public Scheduler getSubscribeScheduler() {
    if (defaultSubscribeScheduler == null) {
      defaultSubscribeScheduler = Schedulers.io();
    }
    return defaultSubscribeScheduler;
  }*/

  public abstract T getAppContext(Context context);

  public abstract V getDaggerComponent();

  /*public abstract <T> T makeSubComponent(Object module);

  public abstract void inject(Object target);

  public void onStart() {
    running = true;
  }

  public void onStop() {
    running = false;
  }

  public boolean isRunning() {
    return running;
  }*/
}
