package com.sera.amm.userlist;

import com.sera.amm.common.dagger.ActivityScope;
import dagger.Subcomponent;

/**
 * Created by Fahmi Hakim on 9/6/17.
 */

@ActivityScope
@Subcomponent(modules = UsersModule.class)
public interface UsersComponent {
  void inject(UsersActivity usersActivity);
  void inject(UsersFragment usersFragment);
}
