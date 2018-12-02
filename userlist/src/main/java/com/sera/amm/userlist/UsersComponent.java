package com.sera.amm.userlist;

import dagger.Subcomponent;

/**
 * Created by Fahmi Hakim on 9/6/17.
 */

@Subcomponent(modules = UsersModule.class)
public interface UsersComponent {
  void inject(UsersActivity usersActivity);
  void inject(UsersFragment usersFragment);
}
