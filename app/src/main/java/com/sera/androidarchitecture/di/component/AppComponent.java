package com.sera.androidarchitecture.di.component;

import com.sera.amm.data.DataModule;
import com.sera.amm.userlist.UsersComponent;
import com.sera.amm.userlist.UsersModule;
import com.sera.androidarchitecture.AmmApp;
import com.sera.androidarchitecture.di.module.AppModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by Fahmi Hakim on 9/5/17.
 */

@Singleton
@Component(modules = {
    AppModule.class, DataModule.class
})
public interface AppComponent {
  void inject(AmmApp ammApp);

  UsersComponent plus(UsersModule usersModule);
}
