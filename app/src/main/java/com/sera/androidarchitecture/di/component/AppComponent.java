package com.sera.androidarchitecture.di.component;


import android.app.Application;

import com.sera.amm.userlist.UsersComponent;
import com.sera.amm.userlist.UsersModule;
import com.sera.androidarchitecture.AmmApp;
import com.sera.androidarchitecture.MainActivity;
import com.sera.androidarchitecture.di.module.AppModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by Fahmi Hakim on 9/5/17.
 */

@ApplicationScope
@Component(modules = { AppModule.class })
public interface AppComponent {

  AmmApp provideApplication();

  String provideString();

  void inject(AmmApp ammApp);



  //UsersComponent plus(UsersModule usersModule);
}
